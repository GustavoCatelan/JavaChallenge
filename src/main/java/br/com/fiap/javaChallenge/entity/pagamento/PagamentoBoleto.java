package br.com.fiap.javaChallenge.entity.pagamento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
@Table(name = "TB_PAGAMENTO_BOLETO")
public class PagamentoBoleto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PAGAMENTO_BOLETO")
    @SequenceGenerator(name = "SQ_PAGAMENTO_BOLETO", sequenceName = "SQ_PAGAMENTO_BOLETO", allocationSize = 1)
    @Column(name = "ID_PAGAMENTO_BOLETO")
    private  Long id;

    @Column(name = "NUM_BOLETO")
    private String numeroBoleto;

    @Column(name = "DATA_EMISSAO_BOLETO")
    private LocalDate dataEmissao;

    @Column(name = "PRECO_BOLETO")
    private float preco;
}
