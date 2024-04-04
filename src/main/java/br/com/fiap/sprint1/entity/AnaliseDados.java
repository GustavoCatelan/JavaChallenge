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
@Table(name = "TB_ANALISE_DADOS")
public class AnaliseDados {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ANALISE_DADOS")
    @SequenceGenerator(name = "SQ_ANALISE_DADOS", sequenceName = "SQ_ANALISE_DADOS", allocationSize = 1)
    @Column(name = "ID_ANALISE_DADOS")
    private Long id;

    @Column(name = "AVALIA_ANALISE_DADOS")
    private String avaliacoes;

    @Column(name = "NUM_COMP_ANALISE_DADOS")
    private  String numeroCompra;

    @Column(name = "RECOMENDACOES_ANALISE_DADOS")
    private String recomendacoes;

    @Column(name = "TIPO_ANALISE_DADOS")
    private String tipo;

    @Column(name = "DATA_ANALISE_DADOS")
    private String data;
}
