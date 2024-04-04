package br.com.fiap.sprint1.resource;

import br.com.fiap.sprint1.entity.*;
import br.com.fiap.sprint1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/analiseDados")
public class AnaliseDadosResource {

    @Autowired
    private AnaliseDadosRepository repo;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<AnaliseDados> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public AnaliseDados findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public AnaliseDados save(@RequestBody AnaliseDados analiseDados) {
        return repo.save(analiseDados);
    }


    @Transactional
    @PostMapping(value = "/{id}/servico")
    public AnaliseDados addServico(@PathVariable Long id, @RequestBody Servico s) {
        AnaliseDados analiseDados = repo.findById(id).orElseThrow();
        s.setAnaliseDados(analiseDados);
        return analiseDados;
    }

    @GetMapping(value = "/{id}/servico")
    public List<Servico> findServicoByAnaliseDados(@PathVariable Long id) {
        return servicoRepository.findByAnaliseDadosId(id);
    }

    @Transactional
    @PostMapping(value = "/{id}/produto")
    public AnaliseDados addProduto(@PathVariable Long id, @RequestBody Produto p) {
        AnaliseDados analiseDados = repo.findById(id).orElseThrow();
        p.setAnaliseDados(analiseDados);
        return analiseDados;
    }

    @GetMapping(value = "/{id}/produto")
    public List<Produto> findProduto(@PathVariable Long id) {
        return produtoRepository.findByAnaliseDadosId(id);
    }
}
