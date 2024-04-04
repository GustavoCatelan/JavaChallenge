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
@Table(name = "TB_TELEFONE")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TELEFONE")
    @SequenceGenerator(name = "SQ_TELEFONE", sequenceName = "SQ_TELEFONE", allocationSize = 1)
    @Column(name = "ID_TELEFONE")
    private Long id;

    @Column(name = "DDI_TELEFONE")
    private int ddi;

    @Column(name = "DDD_TELEFONE")
    private int ddd;

    @Column(name = "NUM_TELEFONE")
    private int numero;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "USUARIO",
            referencedColumnName = "ID_USUARIO",
            foreignKey = @ForeignKey(
                    name = "FK_TELEFONE_USUARIO"
            )
    )
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "DISTRIBUIDOR",
            referencedColumnName = "ID_DISTRIBUIDOR",
            foreignKey = @ForeignKey(
                    name = "FK_TELEFONE_DISTRIBUIDOR"
            )
    )
    private Distribuidor distribuidor;

}
