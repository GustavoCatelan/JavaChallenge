package br.com.fiap.javaChallenge.entity.produto;

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
@Table(name = "TB_PRODUTO")
public class Produto extends Negociavel{

    @Column(name = "QUANT_PRODUTO")
    private int quantidade;

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
