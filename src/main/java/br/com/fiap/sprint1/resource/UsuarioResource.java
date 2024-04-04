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
    @PostMapping(value = "/{id}/endereco")
    public Usuario addEndereco(@PathVariable Long id, @RequestBody Endereco e) {
        Usuario usuario = repo.findById(id).orElseThrow();
        e.setUsuario(usuario);
        return usuario;
    }

    @GetMapping(value = "/{id}/endereco")
    public List<Endereco> findEnderecoByUsuario(@PathVariable Long id) {
        return enderecoRepository.findByUsuarioId(id);
    }

    @Transactional
    @PostMapping(value = "/{id}/telefone")
    public Usuario addTelefone(@PathVariable Long id, @RequestBody Telefone t) {
        Usuario usuario = repo.findById(id).orElseThrow();
        t.setUsuario(usuario);
        return usuario;
    }

    @GetMapping(value = "/{id}/telefone")
    public List<Telefone> findTelefoneByUsuario(@PathVariable Long id) {
        return telefoneRepository.findByUsuarioId(id);
    }

    @Transactional
    @PostMapping(value = "/{id}/pessoaFisica")
    public Usuario addPessoaFisica(@PathVariable Long id, @RequestBody PessoaFisica pf) {
        Usuario usuario = repo.findById(id).orElseThrow();
        pf.setUsuario(usuario);
        return usuario;
    }

    @GetMapping(value = "/{id}/PessoaFisica")
    public List<PessoaFisica> findPessoaFisicaByUsuario(@PathVariable Long id) {
        return pessoaFisicaRepository.findByUsuarioId(id);
    }

    @Transactional
    @PostMapping(value = "/{id}/pessoaJuridica")
    public Usuario addPessoaJuridica(@PathVariable Long id, @RequestBody PessoaJuridica pj) {
        Usuario usuario = repo.findById(id).orElseThrow();
        pj.setUsuario(usuario);
        return usuario;
    }

    @GetMapping(value = "/{id}/PessoaJuridica")
    public List<PessoaJuridica> findPessoaJuridicaByUsuario(@PathVariable Long id) {
        return pessoaJuridicaRepository.findByUsuarioId(id);
    }
}