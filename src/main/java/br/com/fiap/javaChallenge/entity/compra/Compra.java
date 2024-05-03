package br.com.fiap.javaChallenge.entity.compra;

import br.com.fiap.javaChallenge.entity.pagamento.Pagamento;
import br.com.fiap.javaChallenge.entity.pessoa.Pessoa;
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
@Table(name = "TB_COMPRA")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_COMPRA")
    @SequenceGenerator(name = "SQ_COMPRA", sequenceName = "SQ_COMPRA", allocationSize = 1)
    @Column(name = "ID_COMPRA")
    private Long id;

    @Column(name = "VALOR_TOTAL_COMPRA")
    private float valorTotal;

    @Column(name = "STATUS_COMPRA")
    private String status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "PESSOA",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(
                    name = "FK_COMPRA_PESSOA"
            )
    )

    private Pessoa pessoa;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "PAGAMENTO",
            referencedColumnName = "ID_PAGAMENTO",
            foreignKey = @ForeignKey(
                    name = "FK_COMPRA_USUARIO"
            )
    )

    private Pagamento pagamento;

}
