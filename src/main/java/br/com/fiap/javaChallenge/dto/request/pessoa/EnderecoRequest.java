package br.com.fiap.javaChallenge.dto.request.pessoa;

import br.com.fiap.javaChallenge.dto.request.AbstractRequest;

public record EnderecoRequest(

        String cep,

        String logradouro,

        String numero,

        String complemento,

        String bairro,

        String cidade,

        String estado,

        AbstractRequest pessoa
) {
}
