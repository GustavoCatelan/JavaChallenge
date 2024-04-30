package br.com.fiap.javaChallenge.dto.request;


public record PagamentoCartaoRequest(

        String tipo,

        String bandeira,

        String validade,

        String numero,

        String cvv,

        AbstractRequest pagamento
) {
}
