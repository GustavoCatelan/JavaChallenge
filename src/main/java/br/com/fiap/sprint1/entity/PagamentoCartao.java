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
@Table(name = "TB_PAGAMENTO_CARTAO")
public class PagamentoCartao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PAGAMENTO_CARTAO")
    @SequenceGenerator(name = "SQ_PAGAMENTO_CARTAO", sequenceName = "SQ_PAGAMENTO_CARTAO", allocationSize = 1)
    @Column(name = "ID_PAGAMENTO_CARTAO")
    private Long id;

    @Column(name = "TIPO_PAGAMENTO_CARTAO")
    private String tipo;

    @Column(name = "BANDEIRA_PAGAMENTO_CARTAO")
    private String bandeira;

    @Column(name = "VALIDADE_PAGAMENTO_CARTAO")
    private String validade;

    @Column(name = "NUM_PAGAMENTO_CARTAO")
    private int numero;

    @Column(name = "CVV_PAGAMENTO_CARTAO")
    private int cvv;
}
