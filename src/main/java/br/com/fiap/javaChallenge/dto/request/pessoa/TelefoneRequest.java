package br.com.fiap.javaChallenge.dto.request.pessoa;

import br.com.fiap.javaChallenge.dto.request.AbstractRequest;

public record TelefoneRequest(

        String ddi,

        String ddd,

        String numero,

        AbstractRequest pessoa
) {
}
