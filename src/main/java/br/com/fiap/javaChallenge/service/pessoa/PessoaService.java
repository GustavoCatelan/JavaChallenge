package br.com.fiap.javaChallenge.service.pessoa;

import br.com.fiap.javaChallenge.dto.request.pessoa.PessoaRequest;
import br.com.fiap.javaChallenge.dto.response.pessoa.PessoaResponse;
import br.com.fiap.javaChallenge.entity.pessoa.Pessoa;
import br.com.fiap.javaChallenge.repository.pessoa.PessoaRepository;
import br.com.fiap.javaChallenge.repository.produto.NegociavelRespository;
import br.com.fiap.javaChallenge.service.ServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PessoaService implements ServiceDTO<Pessoa, PessoaRequest, PessoaResponse> {
    @Autowired
    private PessoaRepository repo;

    @Override
    public Collection<Pessoa> findAll(Example<Pessoa> example){
        return repo.findAll(example);
    }

    @Override
    public Pessoa findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Pessoa save(Pessoa d) {
        return repo.save(d);
    }

    @Override
    public Pessoa toEntity(PessoaRequest dto) {

        return Pessoa.builder()
                .nome(dto.nome())
                .build();
    }

    @Override
    public PessoaResponse toResponse(Pessoa e) {

        return PessoaResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .build();
    }
}
