package br.com.fiap.sprint1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

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

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    @JoinTable(
            name = "DISTRIBUIDOR_SERVICO",
            joinColumns = {
                    @JoinColumn(
                            name = "SERVICO",
                            referencedColumnName = "ID_SERVICO",
                            foreignKey = @ForeignKey(name = "FK_SERVICO_DISTRIBUIDOR"))
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "DISTRIBUIDOR",
                            referencedColumnName = "ID_DISTRIBUIDOR",
                            foreignKey = @ForeignKey(name = "FK_DISTRIBUIODR_SERVICO"))
            }
    )
    private Set<Distribuidor> distribuidor = new LinkedHashSet<>();

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
