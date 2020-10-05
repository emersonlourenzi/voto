package com.desafio.voto.votacao;

import com.desafio.voto.associado.AssociadoFacadeImplementacao;
import com.desafio.voto.associado.AssociadoFacadeIntegracao;
import com.desafio.voto.enuns.VotoEnum;
import com.desafio.voto.error.NotFound;
import com.desafio.voto.votacao.model.VotacaoModelImplementacao;
import com.desafio.voto.votacao.model.VotosModelImplementacao;
import com.desafio.voto.votacao.repository.VotacaoRepository;
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
    private final VotacaoRepository votacaoRepository;
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
        return modelImpl != null;
    }

    private boolean verificaVotacao(String id) {
        Optional<VotacaoModelImplementacao> votacao = votacaoRepository.findById(id);
        Long fimVotacao = votacao.map(VotacaoModelImplementacao::getFimVotacao).get();
        return new Date().getTime() <= fimVotacao;

    }

    public String resultadoVotacao(String idVotacao) {
        List<VotosModelImplementacao> votos = repository.findAll();
        List<VotosModelImplementacao> votosId = votos.stream()
                .filter(voto -> voto.getIdVotacao().equals(idVotacao)).collect(Collectors.toList());
        int nao = votosId.stream()
                .filter(voto -> voto.getVoto() == VotoEnum.NAO).collect(Collectors.toList()).size();
        int sim = votosId.stream()
                .filter(voto -> voto.getVoto() == VotoEnum.SIM).collect(Collectors.toList()).size();
        if (nao > sim) {
            return "VOTOS NÃO VENCEU";
        } else if (nao < sim) {
            return "VOTOS SIM VENCEU";
        } else {
            return "EMPATE";
        }
    }
}
