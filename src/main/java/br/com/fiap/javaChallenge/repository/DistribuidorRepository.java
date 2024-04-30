package br.com.fiap.javaChallenge.repository;

import br.com.fiap.javaChallenge.entity.Distribuidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistribuidorRepository extends JpaRepository<Distribuidor, Long> {
}
