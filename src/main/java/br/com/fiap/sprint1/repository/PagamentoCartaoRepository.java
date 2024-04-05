package br.com.fiap.sprint1.repository;

import br.com.fiap.sprint1.entity.Compra;
import br.com.fiap.sprint1.entity.PagamentoCartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoCartaoRepository extends JpaRepository<PagamentoCartao, Long> {

    List<PagamentoCartao> findByPagamentoId(Long id);
}
