package br.com.fiap.sprint1.entity;


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
@Table(name = "TB_PESSOA_JURIDICA")
public class PessoaJuridica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PESSOA_JURIDICA")
    @SequenceGenerator(name = "SQ_PESSOA_JURIDICA", sequenceName = "SQ_PESSOA_JURIDICA", allocationSize = 1)
    @Column(name = "ID_PESSOA_JURIDICA")
    private Long id;

    @Column(name = "CNPJ_PESSOA_JURIDICA")
    private int cnpj;

    @Column(name = "NM_EMP_PESSOA_JURIDICA")
    private  String nomeEmpresa;

    @Column(name = "NM_FAN_PESSOA_JURIDICA")
    private String nomeFantasia;

    @Column(name = "NAT_JUR_PESSOA_JURIDICA")
    private String naturezaJuridica;

    @Column(name = "SIT_PESSOA_JURIDICA")
    private String situacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USUARIO", referencedColumnName = "ID_USUARIO")
    private Usuario usuario;

}
