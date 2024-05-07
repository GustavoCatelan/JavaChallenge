package br.com.fiap.javaChallenge.entity.pessoa;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder


@Entity
@Table(name = "TB_PESSOA_JURIDICA")
public class PessoaJuridica extends Pessoa{

    @Column(name = "CNPJ_PESSOA_JURIDICA")
    private String cnpj;

    @Column(name = "NM_FAN_PESSOA_JURIDICA")
    private String nomeFantasia;

    @Column(name = "NAT_JUR_PESSOA_JURIDICA")
    private String naturezaJuridica;

    @Column(name = "SIT_PESSOA_JURIDICA")
    private String situacao;

}
