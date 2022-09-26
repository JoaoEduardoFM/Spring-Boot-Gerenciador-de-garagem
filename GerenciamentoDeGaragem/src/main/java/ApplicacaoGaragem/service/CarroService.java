package ApplicacaoGaragem.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ApplicacaoGaragem.dto.Carro;
import ApplicacaoGaragem.repository.CarroRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CarroService {

	CarroRepository repository;

	public ResponseEntity<Carro> create(Carro carro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(carro));
	}

	public Carro update(Long id, Carro carro) {
		Carro carroSalvo = findById(id);
		BeanUtils.copyProperties(carro, carroSalvo, "id");
		return repository.save(carroSalvo);
	}

	public List<Carro> findAll() {
		return repository.findAll();
	}

	public Carro findById(Long id) {
		Carro carroSalvo = repository.findById(id).orElseThrow(() -> new RuntimeException());
		return carroSalvo;
	}

	public void delete(Long id) {
		repository.delete(repository.findById(id).orElseThrow(() -> new RuntimeException()));

	}
}
