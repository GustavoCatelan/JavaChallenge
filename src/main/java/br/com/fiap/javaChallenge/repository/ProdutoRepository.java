package br.com.fiap.javaChallenge.repository;

import br.com.fiap.javaChallenge.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByAnaliseDadosId(Long id);
}
