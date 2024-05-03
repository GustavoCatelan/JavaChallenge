package br.com.fiap.javaChallenge.entity.produto;

import br.com.fiap.javaChallenge.entity.analise.Avaliacao;
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
            name = "AVALIACAO",
            referencedColumnName = "ID_AVALIACAO",
            foreignKey = @ForeignKey(
                    name = "FK_PRODUTO_AVALIACAO"
            )
    )
    private Avaliacao avaliacao;


}
