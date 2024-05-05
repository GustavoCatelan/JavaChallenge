package br.com.fiap.javaChallenge.resource;

import br.com.fiap.javaChallenge.repository.pessoa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    @Autowired
    private CompraRepository compraRepository;

    @GetMapping
    public List<Usuario> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Usuario findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) {
        return repo.save(usuario);
    }

    @Transactional
    @PostMapping(value = "/{id}/telefone")
    public Telefone save(@PathVariable Long id, @RequestBody Telefone t) {
        Usuario usuario = repo.findById(id).orElseThrow();
        if (Objects.isNull(t)) return null;
        t.setUsuario(usuario);
        return telefoneRepository.save(t);
    }

    @GetMapping(value = "/{id}/telefone")
    public List<Telefone> findTelefonebyUsuario(@PathVariable Long id) {
        return telefoneRepository.findByUsuarioId(id);
    }

    @Transactional
    @PostMapping(value = "/{id}/endereco")
    public Endereco save(@PathVariable Long id, @RequestBody Endereco e) {
        Usuario usuario = repo.findById(id).orElseThrow();
        if (Objects.isNull(e)) return null;
        e.setUsuario(usuario);
        return enderecoRepository.save(e);
    }

    @GetMapping(value = "/{id}/endereco")
    public List<Endereco> findEnderecoByUsuario(@PathVariable Long id) {
        return enderecoRepository.findByUsuarioId(id);
    }

    @Transactional
    @PostMapping(value = "/{id}/pessoaFisica")
    public PessoaFisica save(@PathVariable Long id, @RequestBody PessoaFisica pf) {
        Usuario usuario = repo.findById(id).orElseThrow();
        if (Objects.isNull(pf)) return null;
        pf.setUsuario(usuario);
        return pessoaFisicaRepository.save(pf);
    }

    @GetMapping(value = "/{id}/pessoaFisica")
    public List<PessoaFisica> findPessoaFisicaByUsuario(@PathVariable Long id) {
        return pessoaFisicaRepository.findByUsuarioId(id);
    }

    @Transactional
    @PostMapping(value = "/{id}/pessoaJuridica")
    public PessoaJuridica save(@PathVariable Long id, @RequestBody PessoaJuridica pj) {
        Usuario usuario = repo.findById(id).orElseThrow();
        if (Objects.isNull(pj)) return null;
        pj.setUsuario(usuario);
        return pessoaJuridicaRepository.save(pj);
    }

    @GetMapping(value = "/{id}/PessoaJuridica")
    public List<PessoaJuridica> findPessoaJuridicaByUsuario(@PathVariable Long id) {
        return pessoaJuridicaRepository.findByUsuarioId(id);
    }

    @Transactional
    @PostMapping(value = "/{id}/compra")
    public Compra save(@PathVariable Long id, @RequestBody Compra c) {
        Usuario usuario = repo.findById(id).orElseThrow();
        if (Objects.isNull(c)) return null;
        c.setUsuario(usuario);
        return compraRepository.save(c);
    }

    @GetMapping(value = "/{id}/compra")
    public List<Compra> findCompraByUsuario(@PathVariable Long id) {
        return compraRepository.findByUsuarioId(id);
    }
}