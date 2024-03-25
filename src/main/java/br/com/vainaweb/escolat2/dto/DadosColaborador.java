package br.com.vainaweb.escolat2.dto;

import br.com.vainaweb.escolat2.enums.Cargo;

public record DadosColaborador(String nome, String cpf, String email, Cargo cargo) {
	
}
