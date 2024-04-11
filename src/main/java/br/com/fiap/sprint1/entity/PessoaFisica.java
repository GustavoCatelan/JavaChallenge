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
@Table(name = "TB_PESSOA_FISICA")
public class PessoaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PESSOA_FISICA")
    @SequenceGenerator(name = "SQ_PESSOA_FISICA", sequenceName = "SQ_PESSOA_FISICA", allocationSize = 1)
    @Column(name = "ID_PESSOA_FISICA")
    private Long id;

    @Column(name = "CPF_PESSOA_FISICA")
    private String cpf;

    @Column(name = "RG_PESSOA_FISICA")
    private  String rg;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USUARIO", referencedColumnName = "ID_USUARIO")
    private Usuario usuario;

}