package ApplicacaoGaragem.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestException {
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> NotFoundException(RuntimeException exception) {
		NotFoundDetails detail = NotFoundDetails.builder().data(new Date())
				.status(HttpStatus.NOT_FOUND.value()).detail("Registro não encontrado;").build();
		return new ResponseEntity<>(detail, HttpStatus.NOT_FOUND);		
	}
	
		@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
		public ResponseEntity<?> MethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
			NotFoundDetails detail = NotFoundDetails.builder().data(new Date())
					.status(HttpStatus.BAD_REQUEST.value()).detail("Solicitação não suporta.").build();
			return new ResponseEntity<>(detail, HttpStatus.BAD_REQUEST);
		
	}
}