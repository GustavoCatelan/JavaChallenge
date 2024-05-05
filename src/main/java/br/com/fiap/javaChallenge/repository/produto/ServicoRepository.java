package br.com.fiap.javaChallenge.repository.produto;

import br.com.fiap.javaChallenge.entity.produto.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
