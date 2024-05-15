package br.com.fiap.javaChallenge.service.produto;

import br.com.fiap.javaChallenge.dto.request.produto.NegociavelRequest;
import br.com.fiap.javaChallenge.dto.response.produto.NegociavelResponse;
import br.com.fiap.javaChallenge.entity.produto.Negociavel;
import br.com.fiap.javaChallenge.repository.produto.NegociavelRespository;
import br.com.fiap.javaChallenge.service.ServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class NegociavelService implements ServiceDTO<Negociavel ,NegociavelRequest, NegociavelResponse> {

    @Autowired
    private NegociavelRespository repo;

    @Override
    public Collection<Negociavel> findAll(Example<Negociavel> example){
        return repo.findAll(example);
    }

    @Override
    public Negociavel findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Negociavel save(Negociavel d) {
        return repo.save(d);
    }

    @Override
    public Negociavel toEntity(NegociavelRequest dto) {

        return Negociavel.builder()
                .nome(dto.nome())
                .descricao(dto.descricao())
                .preco(dto.preco())
                .build();
    }

    @Override
    public NegociavelResponse toResponse(Negociavel e) {

        return NegociavelResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .descricao(e.getDescricao())
                .preco(e.getPreco())
                .build();
    }
}
