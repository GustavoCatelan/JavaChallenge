package br.com.fiap.javaChallenge.repository.pessoa;

import br.com.fiap.javaChallenge.entity.pessoa.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

}
