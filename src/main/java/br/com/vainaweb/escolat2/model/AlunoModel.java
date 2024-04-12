package br.com.vainaweb.escolat2.model;

import org.hibernate.validator.constraints.br.CPF;

import br.com.vainaweb.escolat2.dto.DadosAluno;
import br.com.vainaweb.escolat2.dto.DadosAtualizados;
import br.com.vainaweb.escolat2.enums.Curso;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_alunos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto incrementado
	private Long id;

	private String nome;

	@Email
	@Column(unique = true, nullable = false)
	private String email;

	@CPF
	@Column(unique = true, nullable = false)
	private String cpf;

	private String telefone;

	private Curso curso;

	@Embedded
	private Endereco endereco;

	public AlunoModel(DadosAluno dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.cpf = dados.cpf();
		this.telefone = dados.telefone();
		this.curso = dados.curso();
		this.endereco = new Endereco(dados.endereco().cep(), dados.endereco().logradouro(), dados.endereco().bairro(),
				dados.endereco().cidade(), dados.endereco().complemento(), dados.endereco().uf(),
				dados.endereco().numero());
	}

	public void atualizarInfo(@Valid DadosAtualizados dados) {
		this.nome = dados.nome() != null ? dados.nome(): nome;
		this.email = dados.email() != null ? dados.email(): email;
	}

}
