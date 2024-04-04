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
@Table(name = "TB_ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ENDERECO")
    @SequenceGenerator(name = "SQ_ENDERECO", sequenceName = "SQ_ENDERECO", allocationSize = 1)
    @Column(name = "ID_ENDERECO")
    private Long id;

    @Column(name = "CEP_ENDERECO")
    private int cep;

    @Column(name = "LOGRADOURO_ENDERECO")
    private  String logradouro;

    @Column(name = "NUM_ENDERECO")
    private int numero;

    @Column(name = "COMPLEMENTO_ENDERECO")
    private String complemento;

    @Column(name = "BAIRRO_ENDERECO")
    private String bairro;

    @Column(name = "CIDADE_ENDERECO")
    private String cidade;

    @Column(name = "ESTADO_ENDERECO")
    private String estado;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "USUARIO",
            referencedColumnName = "ID_USUARIO",
            foreignKey = @ForeignKey(
                    name = "FK_ENDERECO_USUARIO"
            )
    )
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "DISTRIBUIDOR",
            referencedColumnName = "ID_DISTRIBUIDOR",
            foreignKey = @ForeignKey(
                    name = "FK_ENDERECO_DISTRIBUIDOR"
            )
    )

    private Distribuidor distribuidor;


}
