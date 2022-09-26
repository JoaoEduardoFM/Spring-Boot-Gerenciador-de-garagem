package ApplicacaoGaragem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ApplicacaoGaragem.dto.Carro;
import ApplicacaoGaragem.repository.CarroRepository;
import ApplicacaoGaragem.service.CarroService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/carro")
public class CarroController {
	
	CarroRepository carroRepository;
	
	CarroService serviceCarro;
	
	
	// cadastra um novo registro
	@PostMapping
	public ResponseEntity<Carro> salvaCarro(@RequestBody Carro carro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(carroRepository.save(carro));
	}
	
	// atualiza registro de um carro cadastrado.
	@PutMapping("/{id}")
	public ResponseEntity<Carro> atualizarCarro(@PathVariable Long id, @RequestBody Carro carro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceCarro.update(id, carro));
	}
	
	// busca um registro especifico 
	@GetMapping("/{id}")
	public ResponseEntity<Carro> buscaCarroEspecifico(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(serviceCarro.findById(id));	
	}
	
	// busca todos os registros de todos os carros.
	@GetMapping
	public List<Carro> listaTodosCarros(){
		return carroRepository.findAll();	
		
	}
	
	// deleta registro do banco de dados
	@DeleteMapping("/{id}")
	public void deletaCarro(@PathVariable Long id) {
		carroRepository.deleteById(id);
		
	}
}
