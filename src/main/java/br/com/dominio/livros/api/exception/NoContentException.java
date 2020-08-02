package br.com.dominio.livros.api.exception;

public class NoContentException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoContentException(String exception) {
		super(exception);
	}
}
