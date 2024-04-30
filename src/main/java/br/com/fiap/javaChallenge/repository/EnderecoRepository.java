package br.com.fiap.javaChallenge.repository;

import br.com.fiap.javaChallenge.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findByDistribuidorId(Long id);

    List<Endereco> findByUsuarioId(Long id);
}
