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
@Table(name = "TB_PAGAMENTO")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PAGAMENTO")
    @SequenceGenerator(name = "SQ_PAGAMENTO", sequenceName = "SQ_PAGAMENTO", allocationSize = 1)
    @Column(name = "ID_PAGAMENTO")
    private Long id;

    @Column(name = "METODO_PAGAMENTO")
    private String metodo;

    @Column(name = "STATUS_PAGAMENTO")
    private String status;
}
