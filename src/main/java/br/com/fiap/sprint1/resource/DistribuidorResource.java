package br.com.fiap.sprint1.resource;

import br.com.fiap.sprint1.entity.*;
import br.com.fiap.sprint1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

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
    public Distribuidor addEndereco(@PathVariable Long id, @RequestBody Endereco e) {
        Distribuidor distribuidor = repo.findById(id).orElseThrow();
        e.setDistribuidor(distribuidor);
        return distribuidor;
    }

    @GetMapping(value = "/{id}/endereco")
    public List<Endereco> findEnderecoByDistribuidor(@PathVariable Long id){
        return enderecoRepository.findByDistribuidorId(id);
    }

    @Transactional
    @PostMapping(value = "/{id}/telefone")
    public Distribuidor addTelefone(@PathVariable Long id, @RequestBody Telefone t) {
        Distribuidor distribuidor = repo.findById(id).orElseThrow();
        t.setDistribuidor(distribuidor);
        return distribuidor;
    }

    @GetMapping(value = "/{id}/telefone")
    public List<Telefone> findTelefonebyDistribuidor(@PathVariable Long id) {
        return telefoneRepository.findByDistribuidorId(id);
    }

    @Transactional
    @PostMapping(value = "/{id}/servico")
    public Distribuidor save(@PathVariable Long id, @RequestBody Servico s) {

        if (Objects.isNull(s)) return null;

        Distribuidor distribuidor = repo.findById(id).orElseThrow();

        if (Objects.nonNull(s.getId())) {
            s = servicoRepository.findById(s.getId()).orElseThrow();
        }
        s.getDistribuidor().add(distribuidor);
        return distribuidor;

    }

    @GetMapping(value = "/{id}/servico")
    public List<Servico> findServicoByDistribuidor(@PathVariable Long id) {
        return servicoRepository.findByDistribuidorId(id);
    }

    @Transactional
    @PostMapping(value = "/{id}/produto")
    public Distribuidor save(@PathVariable Long id, @RequestBody Produto p) {

        if (Objects.isNull(p)) return null;

        Distribuidor distribuidor = repo.findById(id).orElseThrow();

        if (Objects.nonNull(p.getId())) {
            p = produtoRepository.findById(p.getId()).orElseThrow();
        }
        p.getDistribuidor().add(distribuidor);
        return distribuidor;
    }

    @GetMapping(value = "/{id}/produto")
    public List<Produto> findProdutoByUsuario(@PathVariable Long id) {
        return produtoRepository.findByDistribuidorId(id);
    }
}