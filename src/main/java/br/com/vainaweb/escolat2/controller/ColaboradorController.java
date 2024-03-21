package br.com.vainaweb.escolat2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.escolat2.dto.DadosColaborador;
import br.com.vainaweb.escolat2.service.Colaborador;

@RestController //Classe controladora Gerenciada pelo Spring
@RequestMapping("/colaborador-teste")
public class ColaboradorController {
	
	@Autowired
	private Colaborador colaborador;
		
	@GetMapping("/{id}")
	public String encontrarUmColaborador() {
		return "Nome: Zeca Pagodinho, CPF: 222.578.976-90";
	}
	
	@GetMapping
	public List<Colaborador> encontrarTodosOsColaboradores(){
		return colaborador.encontrar();
	}
	
	@PostMapping
	public String cadastrarColaborador(@RequestBody DadosColaborador dados) {
		colaborador.cadastrar(dados);
		return "ok";
	}
	
}
