package br.com.dominio.livros.api.exception.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class RetornoRequisicao {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty(value = "nome_aplicao_exception")
	private String nomeAplicacao;
	
	@JsonProperty(value = "texto_mensagem_dev")
	private String textoMensagemDev;
	
	@JsonProperty(value = "texto_mensagem_user")
	private String textoMensagemUser;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty(value = "lista_campos_invalidos")
	// private List<ErrorObjects> listaCamposInvalidos;
	private List<String> listaCamposInvalidos;
}
