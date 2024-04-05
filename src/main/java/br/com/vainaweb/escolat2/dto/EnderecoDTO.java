package br.com.vainaweb.escolat2.dto;

public record EnderecoDTO(String cep, String logradouro, String bairro, String cidade,
		String complemento, String uf, Integer numero) {

}
