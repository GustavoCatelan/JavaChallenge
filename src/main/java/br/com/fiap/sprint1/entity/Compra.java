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
            name = "USUARIO",
            referencedColumnName = "ID_USUARIO",
            foreignKey = @ForeignKey(
                    name = "FK_COMPRA_USUARIO"
            )
    )

    private Usuario usuario;

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
