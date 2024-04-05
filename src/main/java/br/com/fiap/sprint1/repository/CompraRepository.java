package br.com.fiap.sprint1.repository;

import br.com.fiap.sprint1.entity.Compra;
import br.com.fiap.sprint1.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findByUsuarioId(Long id);

    List<Compra> findByPagamentoId(Long id);
}
