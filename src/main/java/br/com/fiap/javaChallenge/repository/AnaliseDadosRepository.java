package br.com.fiap.javaChallenge.repository;

import br.com.fiap.javaChallenge.entity.AnaliseDados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnaliseDadosRepository extends JpaRepository<AnaliseDados, Long> {
}
