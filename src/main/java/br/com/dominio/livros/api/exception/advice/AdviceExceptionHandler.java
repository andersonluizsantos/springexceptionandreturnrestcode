package br.com.dominio.livros.api.exception.advice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.dominio.livros.api.exception.BadRequestException;
import br.com.dominio.livros.api.exception.ConflictException;
import br.com.dominio.livros.api.exception.ImsServiceException;
import br.com.dominio.livros.api.exception.NotFoundException;
import br.com.dominio.livros.api.exception.UnauthorizedException;
import br.com.dominio.livros.api.exception.dto.RetornoRequisicao;

@RestControllerAdvice
public class AdviceExceptionHandler {
	@Value("${spring.application.name}")
    private String nomeAplicacao;
	
	@ExceptionHandler(ImsServiceException.class)
    public final ResponseEntity<Object> imsServiceException(ImsServiceException ex) {
        return ResponseEntity.status(400).body(RetornoRequisicao.builder()
                .nomeAplicacao(nomeAplicacao)
                .textoMensagemRetorno(ex.getMessage()).build());
    }

	@ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> notFoundException(NotFoundException ex) {
        return ResponseEntity.status(404).body(RetornoRequisicao.builder()
                .nomeAplicacao(nomeAplicacao)
                .textoMensagemRetorno(ex.getMessage()).build());
    }
	
	@ExceptionHandler(UnauthorizedException.class)
    public final ResponseEntity<Object> unauthorizedException(NotFoundException ex) {
        return ResponseEntity.status(401).body(RetornoRequisicao.builder()
                .nomeAplicacao(nomeAplicacao)
                .textoMensagemRetorno(ex.getMessage()).build());
    }
	
    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<Object> badRequestException(BadRequestException ex) {
        return ResponseEntity.badRequest().body(RetornoRequisicao.builder()
                .nomeAplicacao(nomeAplicacao)
                .textoMensagemRetorno(ex.getMessage()).build());
    }
    
    @ExceptionHandler(ConflictException.class)
    public final ResponseEntity<Object> conflictException(ConflictException ex) {
        return ResponseEntity.status(409).body(RetornoRequisicao.builder()
                .nomeAplicacao(nomeAplicacao)
                .textoMensagemRetorno(ex.getMessage()).build());
    }
}
