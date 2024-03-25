package br.com.vainaweb.escolat2.model;

import org.hibernate.validator.constraints.br.CPF;

import br.com.vainaweb.escolat2.enums.Cargo;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //Trata a classe como uma entidade
@Table(name = "tb_colaboradores") //Defino o nome da minha tabela

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorModel {
	
	@Id // Determina a chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Transforma nosso id em um auto_increment
	private Long id;
	
	private String nome;
	
	@Email
	@Column(unique = true)  //Adiciona constraint UNIQUE 
	private String email;
	
	@CPF
	@Column(unique = true) 
	private String cpf;
	
	private Cargo cargo;
	
	@Embedded // diz que o atributo é incorporavel
	private Endereco endereco;
	
//  |----------------------------------------Construtor-----------------------------------------|
	
	public ColaboradorModel(String nome, String cpf, String email, Cargo cargo) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.cargo = cargo;
	}
	
	
}
