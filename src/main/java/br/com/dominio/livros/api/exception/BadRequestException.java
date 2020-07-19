package br.com.dominio.livros.api.exception;

public class BadRequestException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadRequestException(String exception) {
		super(exception);
	}
}
