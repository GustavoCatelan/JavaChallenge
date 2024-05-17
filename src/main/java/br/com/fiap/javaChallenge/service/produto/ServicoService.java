package br.com.fiap.javaChallenge.service.produto;

import br.com.fiap.javaChallenge.dto.request.produto.ProdutoRequest;
import br.com.fiap.javaChallenge.dto.request.produto.ServicoRequest;
import br.com.fiap.javaChallenge.dto.response.produto.ProdutoResponse;
import br.com.fiap.javaChallenge.dto.response.produto.ServicoResponse;
import br.com.fiap.javaChallenge.entity.produto.Produto;
import br.com.fiap.javaChallenge.entity.produto.Servico;
import br.com.fiap.javaChallenge.repository.produto.ServicoRepository;
import br.com.fiap.javaChallenge.service.ServiceDTO;
import br.com.fiap.javaChallenge.service.analise.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ServicoService implements ServiceDTO<Servico, ServicoRequest, ServicoResponse> {

    @Autowired
    private ServicoRepository repo;

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Override
    public Collection<Servico> findAll(Example<Servico> example){
        return repo.findAll(example);
    }

    @Override
    public Servico findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Servico save(Servico d) {
        return repo.save(d);
    }

    @Override
    public Servico toEntity(ServicoRequest dto) {

        var avaliacao = avaliacaoService.findById(dto.avaliacao().id());

        return Servico.builder()
                .avaliacao(avaliacao)
                .build();
    }

    @Override
    public ServicoResponse toResponse(Servico e) {

        var avaliacao = avaliacaoService.toResponse(e.getAvaliacao());

        return ServicoResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .descricao(e.getDescricao())
                .preco(e.getPreco())
                .avaliacao(avaliacao)
                .build();
    }
}
