package ApplicacaoGaragem.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // a classe é criada como uma entidade do banco de dados.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)// gera valor id de forma automatica
	Long id;
	String marca;
	String modelo;
	String placa;
	String ano;

}
