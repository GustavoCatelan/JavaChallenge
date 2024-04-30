package br.com.fiap.javaChallenge.repository;

import br.com.fiap.javaChallenge.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
