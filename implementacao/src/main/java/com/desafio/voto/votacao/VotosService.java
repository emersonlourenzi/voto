package com.desafio.voto.votacao;

import com.desafio.voto.associado.AssociadoFacadeImplementacao;
import com.desafio.voto.associado.AssociadoFacadeIntegracao;
import com.desafio.voto.enuns.VotoEnum;
import com.desafio.voto.error.NotFound;
import com.desafio.voto.votacao.model.VotacaoModelImplementacao;
import com.desafio.voto.votacao.model.VotosModelImplementacao;
import com.desafio.voto.votacao.repository.VotosRepository;
import com.mongodb.MongoClient;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VotosService {
    private final VotosRepository repository;
    private final MongoClient mongoClient = new MongoClient();
    private final MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "bancovotacao");
    private final AssociadoFacadeIntegracao associadoFacade;
    private final AssociadoFacadeImplementacao associadoFacadeImplementacao;

    public VotosModelImplementacao votar(VotosModelImplementacao model) {

        if (!verificaVotoAssociado(model.getCpfAssociado(), model.getIdVotacao())) {
            throw new NotFound("Associado já votou");
        } else if (!verificaVotacao(model.getIdVotacao())) {
            throw new NotFound("Votação encerrada");
        } else if (associadoFacade.verificarCPF(model.getCpfAssociado()).equals("UNABLE_TO_VOTE")) {
            throw new NotFound("CPF inválido");
        } else if (associadoFacadeImplementacao.buscaAssociadoPorCPF(model.getCpfAssociado()) == null) {
            throw new NotFound("Associado não encontrado");
        } else {
            return repository.save(model);
        }
    }

    private boolean verificaVotoAssociado(String cpfAssociado, String idVotacao) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("cpfAssociado").is(cpfAssociado));
        query.addCriteria(Criteria.where("idVotacao").is(idVotacao));
        VotosModelImplementacao modelImpl = mongoTemplate.findOne(query, VotosModelImplementacao.class);
        if (modelImpl != null) {
            return false;
        } else {
            return true;
        }
    }

    private boolean verificaVotacao(String idVotacao) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("idVotacao").is(idVotacao));
        VotacaoModelImplementacao modelImpl = mongoTemplate.findOne(query, VotacaoModelImplementacao.class);
        if (modelImpl != null && new Date().getTime() <= modelImpl.getFimVotacao()) {
            return true;
        } else {
            return false;
        }
    }

    public String resultadoVotacao(String idVotacao) {
        Optional<VotosModelImplementacao> votos = repository.findById(idVotacao);
        List<VotoEnum> votosNao = votos.stream()
                .map(VotosModelImplementacao::getVoto).filter(a -> a.equals(VotoEnum.NAO))
                .collect(Collectors.toList());
        int totVotosNao = votosNao.size();
        List<VotoEnum> votosSim = votos.stream()
                .map(VotosModelImplementacao::getVoto).filter(a -> a.equals(VotoEnum.SIM))
                .collect(Collectors.toList());
        int totVotosSim = votosSim.size();

        if (totVotosNao > totVotosSim) {
            return "NÃO VENCEU";
        } else if (totVotosNao < totVotosSim) {
            return "SIM VENCEU";
        } else {
            return "EMPATE";
        }
    }
}
