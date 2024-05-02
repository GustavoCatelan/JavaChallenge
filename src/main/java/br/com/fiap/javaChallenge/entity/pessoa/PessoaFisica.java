package br.com.fiap.javaChallenge.entity.pessoa;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
@Table(name = "TB_PESSOA_FISICA")
public class PessoaFisica extends Pessoa {


    @Column(name = "CPF_PESSOA_FISICA")
    private String cpf;

    @Column(name = "RG_PESSOA_FISICA")
    private  String rg;


}