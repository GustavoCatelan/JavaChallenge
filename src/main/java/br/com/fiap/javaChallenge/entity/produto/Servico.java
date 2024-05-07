package br.com.fiap.javaChallenge.entity.produto;

import br.com.fiap.javaChallenge.entity.analise.Avaliacao;
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
@Table(name = "TB_SERVICO")
public class Servico extends Negociavel{


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "AVALIACAO",
            referencedColumnName = "ID_AVALIACAO",
            foreignKey = @ForeignKey(
                    name = "FK_SERVICO_AVALIACAO"
            )
    )
    private Avaliacao avaliacao;

}
