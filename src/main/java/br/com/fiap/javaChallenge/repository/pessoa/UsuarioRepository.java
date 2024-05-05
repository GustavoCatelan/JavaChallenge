package br.com.fiap.javaChallenge.repository.pessoa;

import br.com.fiap.javaChallenge.entity.pessoa.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
