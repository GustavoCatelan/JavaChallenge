package br.com.fiap.sprint1.repository;

import br.com.fiap.sprint1.entity.Servico;
import br.com.fiap.sprint1.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface ServicoRepository extends JpaRepository<Servico, Long> {

    List<Servico> findByAnaliseDadosId(Long id);
}
