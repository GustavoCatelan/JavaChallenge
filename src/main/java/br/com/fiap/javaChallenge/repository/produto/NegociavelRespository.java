package br.com.fiap.javaChallenge.repository.produto;

import br.com.fiap.javaChallenge.entity.produto.Negociavel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NegociavelRespository extends JpaRepository<Negociavel, Long> {
}
