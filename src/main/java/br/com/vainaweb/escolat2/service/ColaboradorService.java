package br.com.vainaweb.escolat2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vainaweb.escolat2.dto.DadosColaborador;
import br.com.vainaweb.escolat2.model.ColaboradorModel;
import br.com.vainaweb.escolat2.repository.ColaboradorRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Service // Classe de serviço gerenciada pelo Spring
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repository;
	
	public List<ColaboradorModel> encontrarTodosOsColaboradores() {
		return repository.findAll(); // SELECT * FROM tb_colaboradores;
	}

	public void cadastrar(DadosColaborador dados) {
		var colaborador = new ColaboradorModel(dados.nome(), dados.cpf(), dados.email(), dados.cargo());
		repository.save(colaborador); //INSERT 
	}
	
}
