package br.com.vainaweb.escolat2.model;

import br.com.vainaweb.escolat2.enums.Cargo;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //Trata a classe como uma entidade
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorModel {
	
	@Id
	private Long id;
	
	private String nome;
	private String email;
	private String cpf;
	
	private Cargo cargo;
	
	@Embedded // diz que o atributo é incorporavel
	private Endereco endereco;
}
