package br.com.fiap.sprint1.repository;

import br.com.fiap.sprint1.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findByDistribuidorId(Long id);

    List<Endereco> findByUsuarioId(Long id);
}
