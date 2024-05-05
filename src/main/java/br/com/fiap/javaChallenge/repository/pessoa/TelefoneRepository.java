package br.com.fiap.javaChallenge.repository.pessoa;

import br.com.fiap.javaChallenge.entity.pessoa.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {


}
