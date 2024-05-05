package br.com.fiap.javaChallenge.repository.produto;

import br.com.fiap.javaChallenge.entity.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
