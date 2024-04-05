package br.com.fiap.sprint1.repository;

import br.com.fiap.sprint1.entity.Pagamento;
import br.com.fiap.sprint1.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
