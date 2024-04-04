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
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTO")
    @SequenceGenerator(name = "SQ_PRODUTO", sequenceName = "SQ_PRODUTO", allocationSize = 1)
    @Column(name = "ID_PRODUTO")
    private Long id;

    @Column(name = "NM_PRODUTO")
    private String nome;

    @Column(name = "DESC_PRODUTO")
    private  String descricao;

    @Column(name = "PRECO_PRODUTO")
    private float preco;

    @Column(name = "QUANT_PRODUTO")
    private int quantidade;


    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    @JoinTable(
            name = "ACESSORIO_VEICULO",
            joinColumns = {
                    @JoinColumn(
                            name = "PRODUTO",
                            referencedColumnName = "ID_PRODUTO",
                            foreignKey = @ForeignKey(name = "FK_PRODUTO_DISTRIBUIDOR"))
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "DISTRIBUIDOR",
                            referencedColumnName = "ID_DISTRIBUIDOR",
                            foreignKey = @ForeignKey(name = "FK_DISTRIBUIDOR_PRODUTO"))
            }
    )
    private Set<Distribuidor> distribuidor = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ANALISE_DADOS",
            referencedColumnName = "ID_ANALISE_DADOS",
            foreignKey = @ForeignKey(
                    name = "FK_PRODUTO_ANALISE_DADOS"
            )
    )
    private AnaliseDados analiseDados;


}
