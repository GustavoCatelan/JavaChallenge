package br.com.fiap.javaChallenge.service.pessoa;

import br.com.fiap.javaChallenge.dto.request.pessoa.TelefoneRequest;
import br.com.fiap.javaChallenge.dto.response.pessoa.TelefoneResponse;
import br.com.fiap.javaChallenge.entity.pessoa.Telefone;
import br.com.fiap.javaChallenge.repository.pessoa.TelefoneRepository;
import br.com.fiap.javaChallenge.service.ServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TelefoneService implements ServiceDTO<Telefone, TelefoneRequest, TelefoneResponse> {

    @Autowired
    private TelefoneRepository repo;

    @Autowired
    private PessoaService pessoaService;

    @Override
    public Collection<Telefone> findAll(Example<Telefone> example){
        return repo.findAll(example);
    }

    @Override
    public Telefone findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Telefone save(Telefone d) {
        return repo.save(d);
    }

    @Override
    public Telefone toEntity(TelefoneRequest dto) {

        var pessoa = pessoaService.findById(dto.pessoa().id());

        return Telefone.builder()
                .ddi(dto.ddi())
                .ddd(dto.ddd())
                .numero(dto.numero())
                .pessoa(pessoa)
                .build();
    }

    @Override
    public TelefoneResponse toResponse(Telefone e) {

        var pessoa = pessoaService.toResponse(e.getPessoa());

        return TelefoneResponse.builder()
                .id(e.getId())
                .ddi(e.getDdi())
                .ddd(e.getDdd())
                .numero(e.getNumero())
                .pessoa(pessoa)
                .build();
    }
}
