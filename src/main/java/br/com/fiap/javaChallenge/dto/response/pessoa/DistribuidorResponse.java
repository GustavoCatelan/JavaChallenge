package br.com.fiap.javaChallenge.dto.response.pessoa;

import br.com.fiap.javaChallenge.dto.response.produto.ProdutoResponse;
import br.com.fiap.javaChallenge.dto.response.produto.ServicoResponse;
import lombok.Builder;

import java.util.Collection;

@Builder
public record DistribuidorResponse(

        Long id,

        String areaCobertura,

        String localizacao,

        String tipo,

        Collection<ServicoResponse> servico,

        Collection<ProdutoResponse> produto,

        PessoaResponse pessoa
) {
}
