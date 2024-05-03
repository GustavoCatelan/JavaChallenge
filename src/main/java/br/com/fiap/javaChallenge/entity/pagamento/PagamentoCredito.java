package br.com.fiap.javaChallenge.entity.pagamento;

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
@Table(name = "TB_PAGAMENTO_CREDITO")
public class PagamentoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PAGAMENTO_CREDITO")
    @SequenceGenerator(name = "SQ_PAGAMENTO_CREDITO", sequenceName = "SQ_PAGAMENTO_CREDITO", allocationSize = 1)
    @Column(name = "ID_PAGAMENTO_CREDITO")
    private Long id;

    @Column(name = "TIPO_PAGAMENTO_CREDITO")
    private String tipo;

    @Column(name = "BANDEIRA_PAGAMENTO_CREDITO")
    private String bandeira;

    @Column(name = "VALIDADE_PAGAMENTO_CREDITO")
    private String validade;

    @Column(name = "NUM_PAGAMENTO_CREDITO")
    private String numero;

    @Column(name = "CVV_PAGAMENTO_CREDITO")
    private String cvv;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PAGAMENTO", referencedColumnName = "ID_PAGAMENTO")
    private Pagamento pagamento;
}
