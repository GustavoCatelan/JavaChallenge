package br.com.fiap.javaChallenge.service.produto;

import br.com.fiap.javaChallenge.dto.request.produto.ProdutoRequest;
import br.com.fiap.javaChallenge.dto.response.produto.ProdutoResponse;
import br.com.fiap.javaChallenge.entity.produto.Produto;
import br.com.fiap.javaChallenge.repository.produto.ProdutoRepository;
import br.com.fiap.javaChallenge.service.ServiceDTO;
import br.com.fiap.javaChallenge.service.analise.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProdutoService implements ServiceDTO<Produto, ProdutoRequest, ProdutoResponse>{

    @Autowired
    private ProdutoRepository repo;

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Override
    public Collection<Produto> findAll(Example<Produto> example){
        return repo.findAll(example);
    }

    @Override
    public Produto findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Produto save(Produto d) {
        return repo.save(d);
    }

    @Override
    public Produto toEntity(ProdutoRequest dto) {

        var avaliacao = avaliacaoService.findById(dto.avaliacao().id());

        return Produto.builder()
                .quantidade(dto.quantidade())
                .avaliacao(avaliacao)
                .build();
    }

    @Override
    public ProdutoResponse toResponse(Produto e) {

        var avaliacao = avaliacaoService.toResponse(e.getAvaliacao());

        return ProdutoResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .descricao(e.getDescricao())
                .preco(e.getPreco())
                .quantidade(e.getQuantidade())
                .avaliacao(avaliacao)
                .build();
    }
}
