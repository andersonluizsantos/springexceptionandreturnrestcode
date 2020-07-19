package br.com.dominio.livros.api.service;

import static net.logstash.logback.argument.StructuredArguments.value;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.dominio.livros.api.dto.LivroDTO;
import br.com.dominio.livros.api.exception.ConflictException;
import br.com.dominio.livros.api.exception.NotFoundException;
import br.com.dominio.livros.api.model.Livro;
import br.com.dominio.livros.api.util.StringUtil;

@Service
public class LivroService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LivroService.class);

	public List<Livro> listarLivros() {
		MDC.put("Nome ", "Anderson Luiz dos Santos");
		LOGGER.info("Iniciando a listagem de livros");
		List<Livro> livros = null;
		try {			
			livros = new ArrayList<>();
			Livro l1 = new Livro(1, "Spring Total", LocalDate.of(2020, 5, 15));
			Livro l2 = new Livro(2, "Java total", LocalDate.of(2019, 2, 15));
			Livro l3 = new Livro(3, "Angular total", LocalDate.of(2019, 2, 15));
			LOGGER.info("Verificando os campos do livro3. ", value("Entrada: ", StringUtil.browseFields(l3)));
			livros.add(l1);
			livros.add(l2);
			livros.add(l3);
		} catch (Exception e) {
			LOGGER.error("Erro ao tentar se comunicar com o mainframe", value("error_message: ", e.getMessage()),
					value("stacktrace", e));
		}
		LOGGER.info("Listagem Concluída com Sucesso");
		
		return livros;
	}

	public Object buscarLivros(Integer id) {
		Livro l1 = new Livro(1, "Spring Total", LocalDate.of(2020, 5, 15));
		if (id.equals(1)) {
			return l1;
		} else {
			throw new NotFoundException("Este livro não existe na base de dados");
		}
	}

	public Object incluirLivros(LivroDTO livroDTO) {
		Livro l1 = new Livro(1, livroDTO.getNome(), livroDTO.getPublicacao());
		
		if (livroDTO.getNome().equals("Java Total")) {
			throw new ConflictException("Esse livro já existe na base de dados");		
		} else {
			return l1;
		}
		
	}

	public Object atualizarLivros(Integer id, LivroDTO livroDTO) {
		Livro l1 = new Livro(id, livroDTO.getNome(), livroDTO.getPublicacao());
		if (id.equals(1)) {
			return l1;
		} else {
			throw new NotFoundException("Este livro não existe na base de dados");
		}
	}

	public ResponseEntity<Void> excluirLivros(Integer id) {
		if (id.equals(1)) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
