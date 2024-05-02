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
@Table(name = "TB_ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ENDERECO")
    @SequenceGenerator(name = "SQ_ENDERECO", sequenceName = "SQ_ENDERECO", allocationSize = 1)
    @Column(name = "ID_ENDERECO")
    private Long id;

    @Column(name = "CEP_ENDERECO")
    private String cep;

    @Column(name = "LOGRADOURO_ENDERECO")
    private  String logradouro;

    @Column(name = "NUM_ENDERECO")
    private String numero;

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
            name = "PESSOA",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(
                    name = "FK_ENDERECO_PESSOA"
            )
    )
    private Pessoa pessoa;


}
