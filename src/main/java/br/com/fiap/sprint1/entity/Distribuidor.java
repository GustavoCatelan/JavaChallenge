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
@Table(name = "TB_DISTRIBUIDOR")
public class Distribuidor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DISTRIBUIDOR")
    @SequenceGenerator(name = "SQ_DISTRIBUIDOR", sequenceName = "SQ_DISTRIBUIDOR", allocationSize = 1)
    @Column(name = "ID_DISTRIBUIDOR")
    private Long id;

    @Column(name = "NM_DISTRIBUIDOR")
    private String nome;

    @Column(name = "AREA_COBER_DISTRIBUIDOR")
    private  String areaCobertura;

    @Column(name = "LOCALIZACAO_DISTRIBUIDOR")
    private String localizacao;

    @Column(name = "TIPO_DISTRIBUIDOR")
    private String tipo;
}
