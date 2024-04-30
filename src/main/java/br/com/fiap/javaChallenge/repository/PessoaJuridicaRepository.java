package br.com.fiap.javaChallenge.repository;

import br.com.fiap.javaChallenge.entity.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

    List<PessoaJuridica> findByUsuarioId(Long id);
}
