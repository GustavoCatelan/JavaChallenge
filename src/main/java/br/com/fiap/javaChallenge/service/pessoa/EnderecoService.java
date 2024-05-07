package br.com.fiap.javaChallenge.service.pessoa;

import br.com.fiap.javaChallenge.dto.request.pessoa.EnderecoRequest;
import br.com.fiap.javaChallenge.dto.response.pessoa.EnderecoResponse;
import br.com.fiap.javaChallenge.entity.pessoa.Endereco;
import br.com.fiap.javaChallenge.repository.pessoa.EnderecoRepository;
import br.com.fiap.javaChallenge.service.ServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EnderecoService implements ServiceDTO<Endereco, EnderecoRequest, EnderecoResponse> {

    @Autowired
    private EnderecoRepository repo;

    @Autowired
    private PessoaService pessoaService;

    @Override
    public Collection<Endereco> findAll(Example<Endereco> example){
        return repo.findAll(example);
    }

    @Override
    public Endereco findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Endereco save(Endereco d) {
        return repo.save(d);
    }

    @Override
    public Endereco toEntity(EnderecoRequest dto) {

        var pessoa = pessoaService.findById(dto.pessoa().id());

        return Endereco.builder()
                .cep(dto.cep())
                .logradouro(dto.logradouro())
                .numero(dto.numero())
                .complemento(dto.complemento())
                .bairro(dto.bairro())
                .cidade(dto.cidade())
                .estado(dto.estado())
                .pessoa(pessoa)
                .build();
    }

    @Override
    public EnderecoResponse toResponse(Endereco e) {

        var pessoa = pessoaService.toResponse(e.getPessoa());

        return EnderecoResponse.builder()
                .id(e.getId())
                .cep(e.getCep())
                .logradouro(e.getLogradouro())
                .numero(e.getNumero())
                .complemento(e.getComplemento())
                .bairro(e.getBairro())
                .cidade(e.getCidade())
                .estado(e.getEstado())
                .pessoa(pessoa)
                .build();
    }
}
