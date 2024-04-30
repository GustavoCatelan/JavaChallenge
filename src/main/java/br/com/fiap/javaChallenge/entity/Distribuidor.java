package br.com.fiap.javaChallenge.entity;

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

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    @JoinTable(
            name = "SERVICO_DISTRIBUIDOR",
            joinColumns = {
                    @JoinColumn(
                            name = "DISTRIBUIDOR",
                            referencedColumnName = "ID_DISTRIBUIDOR",
                            foreignKey = @ForeignKey(name = "FK_DISTRIBUIDOR_SERVICO"))
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "SERVICO",
                            referencedColumnName = "ID_SERVICO",
                            foreignKey = @ForeignKey(name = "FK_SERVICO_DISTRIBUIDOR"))
            }
    )
    private Set<Servico> servico = new LinkedHashSet<>();

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    @JoinTable(
            name = "PRODUTO_DISTRIBUIDOR",
            joinColumns = {
                    @JoinColumn(
                            name = "DISTRIBUIDOR",
                            referencedColumnName = "ID_DISTRIBUIDOR",
                            foreignKey = @ForeignKey(name = "FK_DISTRIBUIDOR_PRODUTO"))
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "PRODUTO",
                            referencedColumnName = "ID_PRODUTO",
                            foreignKey = @ForeignKey(name = "FK_PRODUTO_DISTRIBUIDOR"))
            }
    )
    private Set<Produto> produto = new LinkedHashSet<>();
}
