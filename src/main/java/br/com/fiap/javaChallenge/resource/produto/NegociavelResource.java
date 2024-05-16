package br.com.fiap.javaChallenge.resource.produto;

import br.com.fiap.javaChallenge.dto.request.produto.NegociavelRequest;
import br.com.fiap.javaChallenge.dto.request.produto.ProdutoRequest;
import br.com.fiap.javaChallenge.dto.request.produto.ServicoRequest;
import br.com.fiap.javaChallenge.dto.response.produto.NegociavelResponse;
import br.com.fiap.javaChallenge.dto.response.produto.ProdutoResponse;
import br.com.fiap.javaChallenge.dto.response.produto.ServicoResponse;
import br.com.fiap.javaChallenge.entity.produto.Negociavel;
import br.com.fiap.javaChallenge.entity.produto.Produto;
import br.com.fiap.javaChallenge.entity.produto.Servico;
import br.com.fiap.javaChallenge.resource.ResourceDTO;
import br.com.fiap.javaChallenge.service.produto.NegociavelService;
import br.com.fiap.javaChallenge.service.produto.ProdutoService;
import br.com.fiap.javaChallenge.service.produto.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;
import java.util.Objects;

@RestController
@RequestMapping(value = "/negociavel")
public class NegociavelResource implements ResourceDTO<NegociavelRequest, NegociavelResponse> {

    @Autowired
    private NegociavelService service;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<Collection<NegociavelResponse>> findAll(
            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "descricao", required = false) String descricao,
            @RequestParam(name = "preco", required = false) Float preco

    ) {
        var negociavel = Negociavel.builder()
                .nome(nome)
                .descricao(descricao)
                .preco(preco)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Negociavel> example = Example.of(negociavel, matcher);

        var entities = service.findAll(example);

        if (entities.isEmpty()) return ResponseEntity.notFound().build();

        var response = entities.stream().map(service::toResponse).toList();

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<NegociavelResponse> findById(@PathVariable Long id) {
        var entity = service.findById(id);
        if (Objects.isNull(entity)) return ResponseEntity.notFound().build();
        var response = service.toResponse(entity);
        return ResponseEntity.ok(response);
    }


    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<NegociavelResponse> save(@RequestBody NegociavelRequest dto) {

        var entity = service.toEntity(dto);
        var saved = service.save(entity);

        var response = service.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);

    }

    @GetMapping(value = "/produto")
    public ResponseEntity<Collection<ProdutoResponse>> findAllProduto(
            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "descricao", required = false) String descricao,
            @RequestParam(name = "preco", required = false) Float preco,
            @RequestParam(name = "quantidade", required = false) Integer quantidade

    ) {
        var produto = Produto.builder()
                .nome(nome)
                .descricao(descricao)
                .preco(preco)
                .quantidade(quantidade)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Produto> example = Example.of(produto, matcher);

        var entities = produtoService.findAll(example);

        if (entities.isEmpty()) return ResponseEntity.notFound().build();

        var response = entities.stream().map(produtoService::toResponse).toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/produto/{id}")
    public ResponseEntity<ProdutoResponse> findByIdProduto(@PathVariable Long id){
        var entity = produtoService.findById(id);
        if (Objects.isNull(entity)) return ResponseEntity.notFound().build();
        var response = produtoService.toResponse(entity);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping(value = "/produto")
    public ResponseEntity<ProdutoResponse> saveProduto(@RequestBody ProdutoRequest r) {

        var entity = produtoService.toEntity(r);
        var saved = produtoService.save(entity);

        var response = produtoService.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);

    }

    @GetMapping(value = "/servico")
    public ResponseEntity<Collection<ServicoResponse>> findAllServico(
            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "descricao", required = false) String descricao,
            @RequestParam(name = "preco", required = false) Float preco

    ) {
        var servico = Servico.builder()
                .nome(nome)
                .descricao(descricao)
                .preco(preco)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Servico> example = Example.of(servico, matcher);

        var entities = servicoService.findAll(example);

        if (entities.isEmpty()) return ResponseEntity.notFound().build();

        var response = entities.stream().map(servicoService::toResponse).toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/servico/{id}")
    public ResponseEntity<ServicoResponse> findByIdServico(@PathVariable Long id){
        var entity = servicoService.findById(id);
        if (Objects.isNull(entity)) return ResponseEntity.notFound().build();
        var response = servicoService.toResponse(entity);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping(value = "/servico")
    public ResponseEntity<ServicoResponse> saveServico(@RequestBody ServicoRequest r) {

        var entity = servicoService.toEntity(r);
        var saved = servicoService.save(entity);

        var response = servicoService.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);

    }

}
