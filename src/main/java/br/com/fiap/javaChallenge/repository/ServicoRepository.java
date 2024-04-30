package br.com.fiap.javaChallenge.repository;

import br.com.fiap.javaChallenge.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface ServicoRepository extends JpaRepository<Servico, Long> {

    List<Servico> findByAnaliseDadosId(Long id);
}
