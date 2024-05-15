package br.com.fiap.javaChallenge.resource.produto;

import br.com.fiap.javaChallenge.dto.request.produto.NegociavelRequest;
import br.com.fiap.javaChallenge.dto.response.produto.NegociavelResponse;
import br.com.fiap.javaChallenge.entity.produto.Negociavel;
import br.com.fiap.javaChallenge.repository.produto.ProdutoRepository;
import br.com.fiap.javaChallenge.repository.produto.ServicoRepository;
import br.com.fiap.javaChallenge.resource.ResourceDTO;
import br.com.fiap.javaChallenge.service.produto.NegociavelService;
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
    private ProdutoRepository produtoRepository;

    @Autowired
    private ServicoRepository servicoRepository;

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
}
