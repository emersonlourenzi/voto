package com.desafio.voto.associado;

import com.desafio.voto.associado.model.AssociadoModelImplementacao;
import com.desafio.voto.associado.repository.AssociadoRepository;
import com.desafio.voto.error.NoContent;
import com.desafio.voto.error.NotFound;
import com.mongodb.MongoClient;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AssociadoService {

    private final AssociadoRepository repository;
    private final MongoClient mongoClient = new MongoClient();
    private final MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "bancovoto");

    public AssociadoModelImplementacao adicionar(AssociadoModelImplementacao model) {
        if (model.getCpf() == null || model.getCpf().equals("") || model.getCpf().length() != 11 ||
                model.getNome() == null || model.getNome().equals("")) {
            throw new NotFound("Dados informados são inválidos");
        } else {
            final Query query = new Query();
            final MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "bancovoto");
            query.addCriteria(Criteria.where("cpf").is(model.getCpf()));
            AssociadoModelImplementacao modelImpl = mongoTemplate.findOne(query, AssociadoModelImplementacao.class);
            if (modelImpl != null && repository.existsById(modelImpl.getId())) {
                throw new NotFound("CPF já existemnte em nossos dados.");
            } else {
                return repository.save(model);
            }
        }
    }

    public void excluirPorId(String id) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        AssociadoModelImplementacao model = mongoTemplate.findOne(query, AssociadoModelImplementacao.class);
        if (model != null) {
            mongoTemplate.remove(query, "associado");
            throw new NoContent("Associado excluido com sucesso");
        } else {
            throw new NotFound("ID inexistente");
        }
    }

    public void excluirPorCPF(String cpf) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("cpf").is(cpf));
        AssociadoModelImplementacao model = mongoTemplate.findOne(query, AssociadoModelImplementacao.class);
        if (model != null) {
            mongoTemplate.remove(query, "associado");
            throw new NoContent("Associado exluido com sucesso");
        } else {
            throw new NotFound("CPF de usuario não existe");
        }
    }

    public AssociadoModelImplementacao editarPorId(String id, AssociadoModelImplementacao model) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        AssociadoModelImplementacao modelImpl = mongoTemplate.findOne(query, AssociadoModelImplementacao.class);
        if (modelImpl != null && repository.existsById(modelImpl.getId())) {
            repository.deleteById(modelImpl.getId());
            modelImpl.setId(modelImpl.getId());
            return repository.save(modelImpl);
        } else {
            throw new NotFound("ID de associado inexistente");
        }
    }

    public AssociadoModelImplementacao editarPorCPF(String cpf, AssociadoModelImplementacao model) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("cpf").is(cpf));
        AssociadoModelImplementacao modelImpl = mongoTemplate.findOne(query, AssociadoModelImplementacao.class);
        if (modelImpl != null) {
            mongoTemplate.remove(query, "associado");
            modelImpl.setId(modelImpl.getId());
            return repository.save(modelImpl);
        } else {
            throw new NotFound("CPF de usuario não existe");
        }
    }

    public AssociadoModelImplementacao buscaAssociadoPorId(String id) {
        Optional<AssociadoModelImplementacao> model = repository.findById(id);
        if (!model.isEmpty()) {
            return repository.findById(id).orElseThrow(InputMismatchException::new);
        } else {
            throw new NotFound("Associado não encontrado");
        }
    }

    public AssociadoModelImplementacao buscaAssociadoPorCPF(String cpf) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("cpf").is(cpf));
        AssociadoModelImplementacao modelImpl = mongoTemplate.findOne(query, AssociadoModelImplementacao.class);
        if (modelImpl != null) {
            return repository.findById(modelImpl.getId()).orElseThrow(InputMismatchException::new);
        } else {
            throw new NotFound("CPF de usuario não existe");
        }
    }

}
