package br.com.fiap.javaChallenge.entity;

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
@Table(name = "TB_SERVICO")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SERVICO")
    @SequenceGenerator(name = "SQ_SERVICO", sequenceName = "SQ_SERVICO", allocationSize = 1)
    @Column(name = "ID_SERVICO")
    private Long id;

    @Column(name = "NM_SERVICO")
    private String nome;

    @Column(name = "DESC_SERVICO")
    private  String descricao;

    @Column(name = "PRECO_SERVICO")
    private float preco;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ANALISE_DADOS",
            referencedColumnName = "ID_ANALISE_DADOS",
            foreignKey = @ForeignKey(
                    name = "FK_SERVICO_ANALISE_DADOS"
            )
    )
    private AnaliseDados analiseDados;

}