package br.com.fiap.javaChallenge.dto.request;


public record PessoaFisicaRequest(


        String cpf,

        String rg,

        AbstractRequest usuario
) {
}
