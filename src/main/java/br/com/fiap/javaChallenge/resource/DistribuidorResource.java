package br.com.fiap.javaChallenge.resource;

import br.com.fiap.javaChallenge.entity.*;
import br.com.fiap.javaChallenge.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/distribuidor")
public class DistribuidorResource {

    @Autowired
    private DistribuidorRepository repo;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Distribuidor> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Distribuidor findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Distribuidor save(@RequestBody Distribuidor distribuidor) {
        return repo.save(distribuidor);
    }

    @Transactional
    @PostMapping(value = "/{id}/endereco")
    public Endereco save(@PathVariable Long id, @RequestBody Endereco e) {
        Distribuidor distribuidor = repo.findById(id).orElseThrow();
        if (Objects.isNull(e)) return null;
        e.setDistribuidor(distribuidor);
        return enderecoRepository.save(e);
    }

    @GetMapping(value = "/{id}/endereco")
    public List<Endereco> findEnderecoByDistribuidor(@PathVariable Long id){
        return enderecoRepository.findByDistribuidorId(id);
    }

    @Transactional
    @PostMapping(value = "/{id}/telefone")
    public Telefone save(@PathVariable Long id, @RequestBody Telefone t) {
        Distribuidor distribuidor = repo.findById(id).orElseThrow();
        if (Objects.isNull(t)) return null;
        t.setDistribuidor(distribuidor);
        return telefoneRepository.save(t);
    }

    @GetMapping(value = "/{id}/telefone")
    public List<Telefone> findTelefonebyDistribuidor(@PathVariable Long id) {
        return telefoneRepository.findByDistribuidorId(id);
    }

    @Transactional
    @PostMapping(value = "/{id}/servico")
    public Servico addServico(@PathVariable Long id, @RequestBody Servico s) {
        if (Objects.isNull( s)) return null;
        if (Objects.nonNull( s.getId() )) {
            s = servicoRepository.findById( s.getId() ).orElseThrow();
        }
        Distribuidor distribuidor = repo.findById( id ).orElseThrow();
        distribuidor.getServico().add( s );
        return servicoRepository.save( s );
    }

    @GetMapping(value = "/{id}/servico")
    public List<Servico> getServico(@PathVariable Long id) {
        Distribuidor distribuidor = repo.findById( id ).orElseThrow();
        return distribuidor.getServico().stream().toList();
    }

    @Transactional
    @PostMapping(value = "/{id}/produto")
    public Produto addProduto(@PathVariable Long id, @RequestBody Produto p) {
        if (Objects.isNull( p)) return null;
        if (Objects.nonNull( p.getId() )) {
            p = produtoRepository.findById( p.getId() ).orElseThrow();
        }
        Distribuidor distribuidor = repo.findById( id ).orElseThrow();
        distribuidor.getProduto().add( p );
        return produtoRepository.save( p );
    }

    @GetMapping(value = "/{id}/produto")
    public List<Produto> getProduto(@PathVariable Long id) {
        Distribuidor distribuidor = repo.findById( id ).orElseThrow();
        return distribuidor.getProduto().stream().toList();
    }
}