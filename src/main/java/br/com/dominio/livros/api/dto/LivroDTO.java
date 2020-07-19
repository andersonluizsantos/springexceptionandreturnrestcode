package br.com.dominio.livros.api.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LivroDTO {
	@NotBlank(message = "nome do livro")
	private String nome;
	@NotBlank(message = "data de publica")
	private LocalDate publicacao;
}
