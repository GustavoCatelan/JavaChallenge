package br.com.fiap.javaChallenge.resource.analise;

import br.com.fiap.javaChallenge.dto.request.analise.AvaliacaoRequest;
import br.com.fiap.javaChallenge.dto.response.anlise.AvaliacaoResponse;
import br.com.fiap.javaChallenge.entity.analise.Avaliacao;
import br.com.fiap.javaChallenge.resource.ResourceDTO;
import br.com.fiap.javaChallenge.service.analise.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@RestController
@RequestMapping(value = "/avaliacao")
public class AvaliacaoResource implements ResourceDTO<AvaliacaoRequest, AvaliacaoResponse> {

    @Autowired
    private AvaliacaoService service;

    @GetMapping
    public ResponseEntity<Collection<AvaliacaoResponse>> findAll(
            @RequestParam(name = "texto", required = false) String texto,
            @RequestParam(name = "data", required = false) LocalDate data
    ) {

        var avaliacao = Avaliacao.builder()
                .texto(texto)
                .data(data)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase()
                .withIgnoreNullValues();

        Example<Avaliacao> example = Example.of(avaliacao, matcher);
        var entities = service.findAll(example);
        if (entities.isEmpty()) return ResponseEntity.notFound().build();
        var response = entities.stream().map(service::toResponse).toList();
        return ResponseEntity.ok(response);
    }


    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoResponse> findById(@PathVariable Long id) {
        var entity = service.findById(id);
        if (Objects.isNull(entity)) return ResponseEntity.notFound().build();
        var response = service.toResponse(entity);
        return ResponseEntity.ok(response);
    }

    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<AvaliacaoResponse> save(@RequestBody AvaliacaoRequest r) {

        var entity = service.toEntity(r);

        service.save(entity);

        var response = service.toResponse(entity);

        var uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
        return ResponseEntity.created(uri).body(response);
    }

}
