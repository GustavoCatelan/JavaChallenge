package br.com.fiap.javaChallenge.service.pessoa;

import br.com.fiap.javaChallenge.dto.request.pessoa.UsuarioRequest;
import br.com.fiap.javaChallenge.dto.response.pessoa.UsuarioResponse;
import br.com.fiap.javaChallenge.entity.pessoa.Usuario;
import br.com.fiap.javaChallenge.repository.pessoa.UsuarioRepository;
import br.com.fiap.javaChallenge.service.ServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UsuarioService implements ServiceDTO<Usuario, UsuarioRequest, UsuarioResponse> {

    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private PessoaService pessoaService;

    @Override
    public Collection<Usuario> findAll(Example<Usuario> example){
        return repo.findAll(example);
    }

    @Override
    public Usuario findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario d) {
        return repo.save(d);
    }

    @Override
    public Usuario toEntity(UsuarioRequest dto) {

        var pessoa = pessoaService.findById(dto.pessoa().id());

        return Usuario.builder()
                .userName(dto.userName())
                .password(dto.password())
                .pessoa(pessoa)
                .build();
    }

    @Override
    public UsuarioResponse toResponse(Usuario e) {

        var pessoa = pessoaService.toResponse(e.getPessoa());

        return UsuarioResponse.builder()
                .id(e.getId())
                .userName(e.getUserName())
                .password(e.getPassword())
                .pessoa(pessoa)
                .build();
    }
}
