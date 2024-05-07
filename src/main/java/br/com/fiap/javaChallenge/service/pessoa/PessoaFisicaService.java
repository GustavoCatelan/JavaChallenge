package br.com.fiap.javaChallenge.service.pessoa;

import br.com.fiap.javaChallenge.dto.request.pessoa.PessoaFisicaRequest;
import br.com.fiap.javaChallenge.dto.response.pessoa.PessoaFisicaResponse;
import br.com.fiap.javaChallenge.entity.pessoa.PessoaFisica;
import br.com.fiap.javaChallenge.repository.pessoa.PessoaFisicaRepository;
import br.com.fiap.javaChallenge.service.ServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PessoaFisicaService implements ServiceDTO<PessoaFisica, PessoaFisicaRequest, PessoaFisicaResponse> {


    @Autowired
    private PessoaFisicaRepository repo;

    @Override
    public Collection<PessoaFisica> findAll(Example<PessoaFisica> example){
        return repo.findAll(example);
    }

    @Override
    public PessoaFisica findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public PessoaFisica save(PessoaFisica d) {
        return repo.save(d);
    }

    @Override
    public PessoaFisica toEntity(PessoaFisicaRequest dto) {

        return PessoaFisica.builder()
                .nome(dto.nome())
                .cpf(dto.cpf())
                .rg(dto.rg())
                .build();
    }

    @Override
    public PessoaFisicaResponse toResponse(PessoaFisica e) {

        return PessoaFisicaResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .cpf(e.getCpf())
                .rg(e.getRg())
                .build();
    }
}
