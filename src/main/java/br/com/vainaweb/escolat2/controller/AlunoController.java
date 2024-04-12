package br.com.vainaweb.escolat2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.escolat2.dto.DadosAluno;
import br.com.vainaweb.escolat2.dto.DadosAtualizados;
import br.com.vainaweb.escolat2.model.AlunoModel;
import br.com.vainaweb.escolat2.repository.AlunoRepository;
import br.com.vainaweb.escolat2.service.AlunoService;
import jakarta.validation.Valid;

@RestController // Deve ser tratada como uma classe controladora
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoRepository repository;
	
	@Autowired
	private AlunoService service;

	@GetMapping
	public List<AlunoModel> listarTodosOsAlunos() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AlunoModel> listarPorId(@PathVariable Long id) {
		return repository.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PostMapping
	public ResponseEntity<Object> cadastrar(@RequestBody DadosAluno dados) {
		return service.cadastrar(dados).map(resposta -> ResponseEntity.status(HttpStatus.CREATED).build())
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizados dados) {
		var aluno = repository.getReferenceById(id);
		aluno.atualizarInfo(dados);
		repository.save(aluno);
		return ResponseEntity.status(HttpStatus.OK).body("Dados Atualizados");
	}

	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id) {
		repository.deleteById(id);
		return "Deletado com sucesso";
	}
}
