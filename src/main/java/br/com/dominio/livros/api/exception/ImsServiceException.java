package br.com.dominio.livros.api.exception;

public class ImsServiceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImsServiceException(String exception) {
		super(exception);
	}
}
