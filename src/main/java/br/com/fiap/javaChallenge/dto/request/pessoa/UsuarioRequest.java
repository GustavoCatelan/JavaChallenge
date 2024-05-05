package br.com.fiap.javaChallenge.dto.request.pessoa;

import br.com.fiap.javaChallenge.dto.request.AbstractRequest;

public record UsuarioRequest(

        String userName,

        String password,

        AbstractRequest pessoa
) {
}
