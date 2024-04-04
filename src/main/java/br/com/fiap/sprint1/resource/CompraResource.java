package br.com.fiap.sprint1.resource;

import br.com.fiap.sprint1.entity.*;
import br.com.fiap.sprint1.repository.CompraRepository;
import br.com.fiap.sprint1.repository.PagamentoRepository;
import br.com.fiap.sprint1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/compra")
public class CompraResource {

    @Autowired
    private CompraRepository repo;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @GetMapping
    public List<Compra> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Compra findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Compra save(@RequestBody Compra compra) {
        return repo.save(compra);
    }

    @Transactional
    @PostMapping(value = "/{id}/usuario")
    public Compra addUsuario(@PathVariable Long id, @RequestBody Usuario u) {
        Compra compra = repo.findById(id).orElseThrow();
        u.setCompra(compra);
        return compra;
    }

    @GetMapping(value = "/{id}/usuario")
    public List<Usuario> findUsuarioByCompra(@PathVariable Long id){
        return usuarioRepository.findByCompraId(id);
    }

    @Transactional
    @PostMapping(value = "/{id}/pagamento")
    public Compra addPagamento(@PathVariable Long id, @RequestBody Pagamento p) {
        Compra compra = repo.findById(id).orElseThrow();
        p.setCompra(compra);
        return compra;
    }

    @GetMapping(value = "/{id}/pagamento")
    public List<Pagamento> findPagamentoByCompra(@PathVariable Long id){
        return pagamentoRepository.findByCompraId(id);
    }
}
