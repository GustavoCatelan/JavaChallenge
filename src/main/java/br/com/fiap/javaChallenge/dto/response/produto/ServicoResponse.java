package br.com.fiap.javaChallenge.dto.response.produto;

import br.com.fiap.javaChallenge.dto.response.anlise.AvaliacaoResponse;
import lombok.Builder;

@Builder
public record ServicoResponse(

        AvaliacaoResponse avaliacao
) {
}
