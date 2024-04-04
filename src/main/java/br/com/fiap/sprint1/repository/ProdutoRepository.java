package br.com.fiap.sprint1.repository;

import br.com.fiap.sprint1.entity.Produto;
import br.com.fiap.sprint1.entity.Servico;
import br.com.fiap.sprint1.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByDistribuidorId(Long id);

    List<Produto> findByAnaliseDadosId(Long id);
}
