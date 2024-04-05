package br.com.fiap.sprint1.repository;

import br.com.fiap.sprint1.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

    List<Telefone> findByDistribuidorId(Long id);

    List<Telefone> findByUsuarioId(Long id);

}
