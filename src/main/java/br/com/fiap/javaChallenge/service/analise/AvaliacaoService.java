package br.com.fiap.javaChallenge.service.analise;

import br.com.fiap.javaChallenge.dto.request.analise.AvaliacaoRequest;
import br.com.fiap.javaChallenge.dto.response.anlise.AvaliacaoResponse;
import br.com.fiap.javaChallenge.entity.analise.Avaliacao;
import br.com.fiap.javaChallenge.repository.analise.AvaliacaoRepository;
import br.com.fiap.javaChallenge.service.ServiceDTO;
import br.com.fiap.javaChallenge.service.produto.NegociavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AvaliacaoService implements ServiceDTO<Avaliacao, AvaliacaoRequest, AvaliacaoResponse> {

    @Autowired
    private AvaliacaoRepository repo;

    @Autowired
    private NegociavelService negociavelService;

    @Override
    public Collection<Avaliacao> findAll(Example<Avaliacao> example) {
        return repo.findAll(example);
    }

    @Override
    public Avaliacao findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Avaliacao save(Avaliacao a) {
        return repo.save(a);
    }

    @Override
    public Avaliacao toEntity(AvaliacaoRequest dto) {

        var negociavel = negociavelService.findById(dto.negociavel().id());

        return Avaliacao.builder()
                .texto(dto.texto())
                .data(dto.data())
                .negociavel(negociavel)
                .build();

    }

    @Override
    public AvaliacaoResponse toResponse(Avaliacao e) {

        var negociavel = negociavelService.toResponse(e.getNegociavel());

        return AvaliacaoResponse.builder()
                .id(e.getId())
                .texto(e.getTexto())
                .data(e.getData())
                .negociavel(negociavel)
                .build();
    }

}
