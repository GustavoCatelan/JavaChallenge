package br.com.fiap.javaChallenge.dto.request;

public record CompraResquest(

        float valorTotal,

        String status,

        AbstractRequest usuario,

        AbstractRequest pagamento
) {
}
