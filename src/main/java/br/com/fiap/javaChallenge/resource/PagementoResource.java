package br.com.fiap.javaChallenge.resource;

import br.com.fiap.javaChallenge.entity.*;
import br.com.fiap.javaChallenge.repository.CompraRepository;
import br.com.fiap.javaChallenge.repository.PagamentoCartaoRepository;
import br.com.fiap.javaChallenge.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/pagamento")
public class PagementoResource {

    @Autowired
    private PagamentoRepository repo;

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private PagamentoCartaoRepository pagamentoCartaoRepository;

    @GetMapping
    public List<Pagamento> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Pagamento findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Pagamento save(@RequestBody Pagamento pagamento) {
        return repo.save(pagamento);
    }

    @Transactional
    @PostMapping(value = "/{id}/compra")
    public Compra save(@PathVariable Long id, @RequestBody Compra c) {
        Pagamento pagamento = repo.findById(id).orElseThrow();
        if (Objects.isNull(c)) return null;
        c.setPagamento(pagamento);
        return compraRepository.save(c);
    }

    @GetMapping(value = "/{id}/compra")
    public List<Compra> findCompraByPagamento(@PathVariable Long id){
        return compraRepository.findByPagamentoId(id);
    }

    @Transactional
    @PostMapping(value = "/{id}/pagamentoCartao")
    public PagamentoCartao save(@PathVariable Long id, @RequestBody PagamentoCartao pc) {
        Pagamento pagamento = repo.findById(id).orElseThrow();
        if (Objects.isNull(pc)) return null;
        pc.setPagamento(pagamento);
        return pagamentoCartaoRepository.save(pc);
    }

    @GetMapping(value = "/{id}/pagamentoCartao")
    public List<PagamentoCartao> findPagamentoCartaoByPagamento(@PathVariable Long id){
        return pagamentoCartaoRepository.findByPagamentoId(id);
    }
}
