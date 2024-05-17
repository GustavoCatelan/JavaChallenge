package br.com.fiap.javaChallenge.service.pessoa;

import br.com.fiap.javaChallenge.dto.request.pessoa.PessoaJuridicaRequest;
import br.com.fiap.javaChallenge.dto.response.pessoa.PessoaJuridicaResponse;
import br.com.fiap.javaChallenge.entity.pessoa.PessoaJuridica;
import br.com.fiap.javaChallenge.repository.pessoa.PessoaJuridicaRepository;
import br.com.fiap.javaChallenge.service.ServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PessoaJuridicaService implements ServiceDTO<PessoaJuridica, PessoaJuridicaRequest, PessoaJuridicaResponse> {

    @Autowired
    private PessoaJuridicaRepository repo;

    @Override
    public Collection<PessoaJuridica> findAll(Example<PessoaJuridica> example){
        return repo.findAll(example);
    }

    @Override
    public PessoaJuridica findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public PessoaJuridica save(PessoaJuridica d) {
        return repo.save(d);
    }

    @Override
    public PessoaJuridica toEntity(PessoaJuridicaRequest dto) {

        return PessoaJuridica.builder()
                .cnpj(dto.cnpj())
                .nomeFantasia(dto.nomeFantasia())
                .naturezaJuridica(dto.naturezaJuridica())
                .situacao(dto.situacao())
                .build();
    }

    @Override
    public PessoaJuridicaResponse toResponse(PessoaJuridica e) {

        return PessoaJuridicaResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .cnpj(e.getCnpj())
                .nomeFantasia(e.getNomeFantasia())
                .naturezaJuridica(e.getNaturezaJuridica())
                .situacao(e.getSituacao())
                .build();
    }
}
