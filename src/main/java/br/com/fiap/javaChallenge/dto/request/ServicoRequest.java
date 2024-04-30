package br.com.fiap.javaChallenge.dto.request;

public record ServicoRequest(

        String nome,

        String descricao,

        float preco,

        AbstractRequest analiseDados
) {
}
