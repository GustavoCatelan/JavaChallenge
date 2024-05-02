package br.com.fiap.javaChallenge.entity.analise;

import br.com.fiap.sprint1.entity.produto.Negociavel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
@Table(name = "TB_AVALIACAO")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AVALIACAO")
    @SequenceGenerator(name = "SQ_AVALIACAO", sequenceName = "SQ_AVALIACAO", allocationSize = 1)
    @Column(name = "ID_AVALIACAO")
    private Long id;

    @Column(name = "TEXTO_AVALIACAO")
    private String texto;

    @Column(name = "DATA_AVALIACAO")
    private LocalDate data;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "NEGOCIAVEL",
            referencedColumnName = "ID_NEGOCIAVEL",
            foreignKey = @ForeignKey(
                    name = "FK_NEGOCIAVEL_AVALIACAO"
            )
    )
    private Negociavel negociavel;
}
