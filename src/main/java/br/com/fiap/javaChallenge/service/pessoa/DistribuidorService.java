package br.com.fiap.javaChallenge.service.pessoa;

import br.com.fiap.javaChallenge.dto.request.pessoa.DistribuidorRequest;
import br.com.fiap.javaChallenge.dto.response.pessoa.DistribuidorResponse;
import br.com.fiap.javaChallenge.entity.pessoa.Distribuidor;
import br.com.fiap.javaChallenge.repository.pessoa.DistribuidorRepository;
import br.com.fiap.javaChallenge.service.ServiceDTO;
import br.com.fiap.javaChallenge.service.produto.NegociavelService;
import br.com.fiap.javaChallenge.service.produto.ProdutoService;
import br.com.fiap.javaChallenge.service.produto.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DistribuidorService implements ServiceDTO<Distribuidor, DistribuidorRequest, DistribuidorResponse> {

    @Autowired
    private DistribuidorRepository repo;

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private PessoaService pessoaService;

    @Override
    public Collection<Distribuidor> findAll(Example<Distribuidor> example){
        return repo.findAll(example);
    }

    @Override
    public Distribuidor findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Distribuidor save(Distribuidor d) {
        return repo.save(d);
    }

    @Override
    public Distribuidor toEntity(DistribuidorRequest dto) {

        var pessoa = pessoaService.findById(dto.pessoa().id());

        return Distribuidor.builder()
                .areaCobertura(dto.areaCobertura())
                .localizacao(dto.localizacao())
                .tipo(dto.tipo())
                .pessoa(pessoa)
                .build();
    }

    @Override
    public DistribuidorResponse toResponse(Distribuidor e) {

        var pessoa = pessoaService.toResponse(e.getPessoa());

        var produto = e.getProduto().stream().map(produtoService::toResponse).toList();

        var servico = e.getServico().stream().map(servicoService::toResponse).toList();

        return DistribuidorResponse.builder()
                .id(e.getId())
                .areaCobertura(e.getAreaCobertura())
                .localizacao(e.getLocalizacao())
                .tipo(e.getTipo())
                .servico(servico)
                .produto(produto)
                .pessoa(pessoa)
                .build();
    }
}
