package br.com.fiap.javaChallenge.resource.pessoa;

import br.com.fiap.javaChallenge.dto.request.pessoa.*;
import br.com.fiap.javaChallenge.dto.request.produto.ProdutoRequest;
import br.com.fiap.javaChallenge.dto.request.produto.ServicoRequest;
import br.com.fiap.javaChallenge.dto.response.pessoa.*;
import br.com.fiap.javaChallenge.dto.response.produto.ProdutoResponse;
import br.com.fiap.javaChallenge.dto.response.produto.ServicoResponse;
import br.com.fiap.javaChallenge.entity.pessoa.*;
import br.com.fiap.javaChallenge.entity.produto.Produto;
import br.com.fiap.javaChallenge.entity.produto.Servico;
import br.com.fiap.javaChallenge.repository.pessoa.EnderecoRepository;
import br.com.fiap.javaChallenge.repository.pessoa.PessoaFisicaRepository;
import br.com.fiap.javaChallenge.repository.pessoa.PessoaJuridicaRepository;
import br.com.fiap.javaChallenge.repository.pessoa.TelefoneRepository;
import br.com.fiap.javaChallenge.resource.ResourceDTO;
import br.com.fiap.javaChallenge.service.pessoa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.Objects;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource implements ResourceDTO<PessoaRequest, PessoaResponse> {

    @Autowired
    private PessoaService service;

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private TelefoneService telefoneService;

    @GetMapping
    public ResponseEntity<Collection<PessoaResponse>> findAll(
            @RequestParam(name = "nome", required = false) String nome

    ) {
        var pessoa = Pessoa.builder()
                .nome(nome)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Pessoa> example = Example.of(pessoa, matcher);

        var entities = service.findAll(example);

        if (entities.isEmpty()) return ResponseEntity.notFound().build();

        var response = entities.stream().map(service::toResponse).toList();

        return ResponseEntity.ok(response);

    }


    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<PessoaResponse> findById(@PathVariable Long id) {
        var entity = service.findById(id);
        if (Objects.isNull(entity)) return ResponseEntity.notFound().build();
        var response = service.toResponse(entity);
        return ResponseEntity.ok(response);
    }


    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<PessoaResponse> save(@RequestBody PessoaRequest dto) {

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

    @GetMapping(value = "/pessoaFisica")
    public ResponseEntity<Collection<PessoaFisicaResponse>> findAllPessoaFisica(
            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "cpf", required = false) String cpf,
            @RequestParam(name = "rg", required = false) String rg

    ) {
        var pessoaFisica = PessoaFisica.builder()
                .nome(nome)
                .cpf(cpf)
                .rg(rg)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<PessoaFisica> example = Example.of(pessoaFisica, matcher);

        var entities = pessoaFisicaService.findAll(example);

        if (entities.isEmpty()) return ResponseEntity.notFound().build();

        var response = entities.stream().map(pessoaFisicaService::toResponse).toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/pessoaFisica/{id}")
    public ResponseEntity<PessoaFisicaResponse> findByIdPessoaFisica(@PathVariable Long id){
        var entity = pessoaFisicaService.findById(id);
        if (Objects.isNull(entity)) return ResponseEntity.notFound().build();
        var response = pessoaFisicaService.toResponse(entity);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping(value = "/pessoaFisica")
    public ResponseEntity<PessoaFisicaResponse> savePessoaFisica(@RequestBody PessoaFisicaRequest r) {

        var entity = pessoaFisicaService.toEntity(r);
        var saved = pessoaFisicaService.save(entity);

        var response = pessoaFisicaService.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);

    }

    @GetMapping(value = "/pessoaJuridica")
    public ResponseEntity<Collection<PessoaJuridicaResponse>> findAllPessoaJuridica(
            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "cnpj", required = false) String cnpj,
            @RequestParam(name = "nomeFantasia", required = false) String nomeFantasia,
            @RequestParam(name = "naturezaJuridica", required = false) String naturezaJuridica,
            @RequestParam(name = "situacao", required = false) String situacao

    ) {
        var pessoaJuridica = PessoaJuridica.builder()
                .nome(nome)
                .cnpj(cnpj)
                .naturezaJuridica(naturezaJuridica)
                .situacao(situacao)
                .nomeFantasia(nomeFantasia)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<PessoaJuridica> example = Example.of(pessoaJuridica, matcher);

        var entities = pessoaJuridicaService.findAll(example);

        if (entities.isEmpty()) return ResponseEntity.notFound().build();

        var response = entities.stream().map(pessoaJuridicaService::toResponse).toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/pessoaJuridica/{id}")
    public ResponseEntity<PessoaJuridicaResponse> findByIdSPessoaJuridica(@PathVariable Long id){
        var entity = pessoaJuridicaService.findById(id);
        if (Objects.isNull(entity)) return ResponseEntity.notFound().build();
        var response = pessoaJuridicaService.toResponse(entity);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping(value = "/pessoaJuridica")
    public ResponseEntity<PessoaJuridicaResponse> savePessoaJuridica(@RequestBody PessoaJuridicaRequest r) {

        var entity = pessoaJuridicaService.toEntity(r);
        var saved = pessoaJuridicaService.save(entity);

        var response = pessoaJuridicaService.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);

    }

    @GetMapping(value = "/{id}/telefone")
    public ResponseEntity<TelefoneResponse> findTelefoneByPessoa(@PathVariable Long id) {
        var telefone = telefoneService.findById(id);
        var response = telefoneService.toResponse(telefone);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping(value = "/{id}/telefone")
    public ResponseEntity<TelefoneResponse> save(@PathVariable Long id, @RequestBody TelefoneRequest telefone) {

        Pessoa pessoa = service.findById(id);

        if (Objects.isNull(telefone)) return ResponseEntity.badRequest().build();

        var entity = telefoneService.toEntity(telefone);

        entity.setPessoa(pessoa);

        Telefone saved = telefoneService.save(entity);
        var response = telefoneService.toResponse(saved);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping(value = "/{id}/endereco")
    public ResponseEntity<EnderecoResponse> findEnderecoByPessoa(@PathVariable Long id) {
        var endereco = enderecoService.findById(id);
        var response = enderecoService.toResponse(endereco);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping(value = "/{id}/endereco")
    public ResponseEntity<EnderecoResponse> save(@PathVariable Long id, @RequestBody EnderecoRequest endereco) {

        Pessoa pessoa = service.findById(id);

        if (Objects.isNull(endereco)) return ResponseEntity.badRequest().build();

        var entity = enderecoService.toEntity(endereco);

        entity.setPessoa(pessoa);

        Endereco saved = enderecoService.save(entity);
        var response = enderecoService.toResponse(saved);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
