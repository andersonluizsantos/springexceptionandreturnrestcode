package br.com.dominio.livros.api.exception.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.dominio.livros.api.exception.BadRequestException;
import br.com.dominio.livros.api.exception.ConflictException;
import br.com.dominio.livros.api.exception.ImsServiceException;
import br.com.dominio.livros.api.exception.NoContentException;
import br.com.dominio.livros.api.exception.NotFoundException;
import br.com.dominio.livros.api.exception.UnauthorizedException;
import br.com.dominio.livros.api.exception.dto.RetornoRequisicao;

@RestControllerAdvice
public class AdviceExceptionHandler {
	@Value("${spring.application.name}")
	private String nomeAplicacao;
	
	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public final ResponseEntity<Object> httpMessageNotReadableException(HttpMessageNotReadableException ex) {
		
		String mensagemUsuario = messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.getMessage().toString();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RetornoRequisicao.builder().nomeAplicacao(nomeAplicacao)
				.textoMensagemDev(mensagemDesenvolvedor).textoMensagemUser(mensagemUsuario).build());
	}

	@ExceptionHandler(ImsServiceException.class)
	public final ResponseEntity<Object> imsServiceException(ImsServiceException ex) {
		String mensagemUsuario = messageSource.getMessage("mensagem.mainframe", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.getMessage().toString();
		
		return ResponseEntity.status(400).body(RetornoRequisicao.builder().nomeAplicacao(nomeAplicacao)
				.textoMensagemDev(mensagemDesenvolvedor).textoMensagemUser(mensagemUsuario).build());
	}

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Object> notFoundException(NotFoundException ex) {
		String mensagemUsuario = messageSource.getMessage("mensagem.naoencontrdo", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.getMessage().toString();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(RetornoRequisicao.builder().nomeAplicacao(nomeAplicacao)
				.textoMensagemDev(mensagemDesenvolvedor).textoMensagemUser(mensagemUsuario).build());
	}

	@ExceptionHandler(UnauthorizedException.class)
	public final ResponseEntity<Object> unauthorizedException(UnauthorizedException ex) {
		String mensagemUsuario = messageSource.getMessage("mensagem.naoautorizado", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.getMessage().toString();
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(RetornoRequisicao.builder().nomeAplicacao(nomeAplicacao)
				.textoMensagemDev(mensagemDesenvolvedor).textoMensagemUser(mensagemUsuario).build());
	}

	@ExceptionHandler(BadRequestException.class)
	public final ResponseEntity<Object> badRequestException(BadRequestException ex) {
		String mensagemUsuario = messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.getMessage().toString();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RetornoRequisicao.builder().nomeAplicacao(nomeAplicacao)
				.textoMensagemDev(mensagemDesenvolvedor).textoMensagemUser(mensagemUsuario).build());
	}

	@ExceptionHandler(ConflictException.class)
	public final ResponseEntity<Object> conflictException(ConflictException ex) {
		String mensagemUsuario = messageSource.getMessage("mensagem.conflito", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.getMessage().toString();
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(RetornoRequisicao.builder().nomeAplicacao(nomeAplicacao)
				.textoMensagemDev(mensagemDesenvolvedor).textoMensagemUser(mensagemUsuario).build());
	}
	
	@ExceptionHandler(NoContentException.class)
	public final ResponseEntity<Object> noContentException(NoContentException ex) {
		String mensagemUsuario = messageSource.getMessage("mensagem.excluido", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.getMessage().toString();
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(RetornoRequisicao.builder().nomeAplicacao(nomeAplicacao)
				.textoMensagemDev(mensagemDesenvolvedor).textoMensagemUser(mensagemUsuario).build());
	}
}
