package ApplicacaoGaragem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ApplicacaoGaragem.dto.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{

}
