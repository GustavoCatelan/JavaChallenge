package br.com.fiap.javaChallenge.dto.request.pessoa;

public record PessoaJuridicaRequest(

        String nome,

        String cnpj,

        String nomeFantasia,

        String naturezaJuridica,

        String situacao
){
}
