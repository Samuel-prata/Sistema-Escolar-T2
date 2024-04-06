package br.com.vainaweb.escolat2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vainaweb.escolat2.dto.DadosAluno;
import br.com.vainaweb.escolat2.model.AlunoModel;
import br.com.vainaweb.escolat2.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	public Optional<AlunoModel> cadastrar(DadosAluno dados) {
		
		var aluno = repository.findByCpf(dados.cpf());
		
		if(aluno.get().getCpf() != null || aluno.get().getEmail() != null) {
			return Optional.empty();
		}else {
			return Optional.of(repository.save(new AlunoModel(dados)));
		}
	}
}
