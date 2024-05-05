package br.com.fiap.javaChallenge.repository.analise;

import br.com.fiap.javaChallenge.entity.analise.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
}
