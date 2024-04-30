package br.com.fiap.javaChallenge.repository;

import br.com.fiap.javaChallenge.entity.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

    List<PessoaFisica> findByUsuarioId(Long id);
}
