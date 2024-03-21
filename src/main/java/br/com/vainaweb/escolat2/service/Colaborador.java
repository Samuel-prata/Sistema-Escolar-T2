package br.com.vainaweb.escolat2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.vainaweb.escolat2.dto.DadosColaborador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service // Classe de serviço gerenciada pelo Spring
public class Colaborador {
	
	private List<Colaborador> lista = new ArrayList();
	
	private Long id;
	private String nome;
	private String cpf;
	private String endereco;
	
	public Colaborador(Long id, String nome, String cpf, String endereco) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}
	
	public void cadastrar(DadosColaborador dados) {
		lista.add(new Colaborador(dados.id(), dados.nome(), dados.cpf(), dados.endereco()));
	}
	
	public List<Colaborador> encontrar(){
		return lista;
	}
}
