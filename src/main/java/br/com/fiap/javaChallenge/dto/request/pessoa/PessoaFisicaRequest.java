package br.com.fiap.javaChallenge.dto.request.pessoa;

public record PessoaFisicaRequest(

        String nome,

        String cpf,

        String rg
) {
}
