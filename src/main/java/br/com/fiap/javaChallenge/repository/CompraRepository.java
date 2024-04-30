package br.com.fiap.javaChallenge.repository;

import br.com.fiap.javaChallenge.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findByUsuarioId(Long id);

    List<Compra> findByPagamentoId(Long id);
}
