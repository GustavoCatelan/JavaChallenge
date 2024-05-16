package br.com.fiap.javaChallenge.resource.pessoa;

import br.com.fiap.javaChallenge.dto.request.pessoa.DistribuidorRequest;
import br.com.fiap.javaChallenge.dto.response.pessoa.DistribuidorResponse;
import br.com.fiap.javaChallenge.entity.pessoa.Distribuidor;
import br.com.fiap.javaChallenge.resource.ResourceDTO;
import br.com.fiap.javaChallenge.service.pessoa.DistribuidorService;
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
@RequestMapping(value = "/distribuidor")
public class DistribuidorResource implements ResourceDTO<DistribuidorRequest, DistribuidorResponse> {

    @Autowired
    private DistribuidorService service;

    @GetMapping
    public ResponseEntity<Collection<DistribuidorResponse>> findAll(
            @RequestParam(name = "areaCobertura", required = false) String areaCobertura,
            @RequestParam(name = "localizacao", required = false) String  localizacao,
            @RequestParam(name = "tipo", required = false) String  tipo

    ) {
        var distribuidor = Distribuidor.builder()
                .areaCobertura(areaCobertura)
                .localizacao(localizacao)
                .tipo(tipo)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Distribuidor> example = Example.of(distribuidor, matcher);

        var entities = service.findAll(example);

        if (entities.isEmpty()) return ResponseEntity.notFound().build();

        var response = entities.stream().map(service::toResponse).toList();

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<DistribuidorResponse> findById(@PathVariable Long id) {
        var entity = service.findById(id);
        if (Objects.isNull(entity)) return ResponseEntity.notFound().build();
        var response = service.toResponse(entity);
        return ResponseEntity.ok(response);
    }

    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<DistribuidorResponse> save(@RequestBody DistribuidorRequest dto) {

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
