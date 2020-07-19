package br.com.dominio.livros.api.exception;

public class ConflictException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConflictException(String exception) {
		super(exception);
	}
}
