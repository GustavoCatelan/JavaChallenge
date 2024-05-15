package br.com.fiap.javaChallenge.entity.produto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "TB_NEGOCIAVEL")
public class Negociavel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_NEGOCIAVEL")
    @SequenceGenerator(name = "SQ_NEGOCIAVEL", sequenceName = "SQ_NEGOCIAVEL", allocationSize = 1)
    @Column(name = "ID_NEGOCIAVEL")
    private Long id;

    @Column(name = "NM_NEGOCIAVEL")
    private String nome;

    @Column(name = "DESC_NEGOCIAVEL")
    private String descricao;

    @Column(name = "PRECO_NEGOCIAVEL")
    private Float preco;
}
