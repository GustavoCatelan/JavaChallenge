package br.com.fiap.javaChallenge.dto.request;

public record TelefoneRequest(

        String ddi,

        String ddd,

        String numero,

        AbstractRequest distribuidor,

        AbstractRequest usuario
) {
}
