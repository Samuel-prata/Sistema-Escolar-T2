package br.com.vainaweb.escolat2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vainaweb.escolat2.dto.DadosColaborador;
import br.com.vainaweb.escolat2.model.ColaboradorModel;
import br.com.vainaweb.escolat2.repository.ColaboradorRepository;

@Service // Classe de serviço gerenciada pelo Spring
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repository;

	public List<ColaboradorModel> encontrarTodosOsColaboradores() {
		return repository.findAll(); // SELECT * FROM tb_colaboradores;
	}

	public String cadastrar(DadosColaborador dados) {

		// select * from tb_colaboradores WHERE cpf = ??
		var existente = repository.findByCpf(dados.cpf());

		if (existente.isPresent()) {
			return "CPF Ja cadastrado";
		} else {
			var colaborador = new ColaboradorModel(dados.nome(), dados.cpf(), dados.email(), dados.cargo(), dados.endereco());
			repository.save(colaborador); // INSERT
			return "Cadastro feito com sucesso";
		}

	}

}
