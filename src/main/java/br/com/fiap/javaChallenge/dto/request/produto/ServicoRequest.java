package br.com.fiap.javaChallenge.dto.request.produto;

import br.com.fiap.javaChallenge.dto.request.AbstractRequest;

public record ServicoRequest(

        String nome,

        String descricao,

        float preco,

        AbstractRequest avaliacao
) {
}
