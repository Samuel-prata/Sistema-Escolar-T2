package br.com.vainaweb.escolat2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.escolat2.dto.DadosColaborador;
import br.com.vainaweb.escolat2.model.ColaboradorModel;
import br.com.vainaweb.escolat2.service.ColaboradorService;

@RestController //Classe controladora Gerenciada pelo Spring
@RequestMapping("/colaborador-teste")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService service;
	
	@GetMapping
	public List<ColaboradorModel> listarTodosOsColaboradores(){
		return service.encontrarTodosOsColaboradores();
	}
	
//	@PostMapping
//	public String cadastrarColaborador(@RequestBody DadosColaborador dados) {
//		service.cadastrar(dados);
//		return "ok";
//	}
	
}
