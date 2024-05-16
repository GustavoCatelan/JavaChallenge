package br.com.fiap.javaChallenge.dto.response.produto;

import br.com.fiap.javaChallenge.dto.response.anlise.AvaliacaoResponse;
import lombok.Builder;

@Builder
public record ProdutoResponse(

        Long id,

        String nome,

        String descricao,

        Float preco,

        Integer quantidade,

        AvaliacaoResponse avaliacao
) {
}
