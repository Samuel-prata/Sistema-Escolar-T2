package br.com.vainaweb.escolat2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.escolat2.dto.DadosAtualizados;
import br.com.vainaweb.escolat2.dto.DadosColaborador;
import br.com.vainaweb.escolat2.model.ColaboradorModel;
import br.com.vainaweb.escolat2.repository.ColaboradorRepository;
import br.com.vainaweb.escolat2.service.ColaboradorService;
import jakarta.validation.Valid;

@RestController // Classe controladora Gerenciada pelo Spring
@RequestMapping("/colaborador")
public class ColaboradorController {

	@Autowired
	private ColaboradorService service;

	@Autowired
	private ColaboradorRepository repository;

	@GetMapping
	public List<ColaboradorModel> listarTodosOsColaboradores() {
		return service.encontrarTodosOsColaboradores();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ColaboradorModel> listarPorId(@PathVariable Long id) {
		return repository.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	// SELECT * FROM tb_colaboradores WHERE id = 1000;

	@PostMapping // Verbo HTTP POST
	public ResponseEntity<String> cadastrarColaborador(@RequestBody DadosColaborador dados) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dados));
	}

	// http://localhost:8080/colaborador-teste/1000
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizados dados) {
		var colaborador = repository.getReferenceById(id);
		colaborador.atualizarInfo(dados);
		repository.save(colaborador);
		return ResponseEntity.status(HttpStatus.OK).body("Dados Atualizados");
	}

	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id) {
		repository.deleteById(id);
		return "Deletado com sucesso";
	}

}
