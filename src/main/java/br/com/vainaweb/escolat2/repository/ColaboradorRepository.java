package br.com.vainaweb.escolat2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vainaweb.escolat2.model.ColaboradorModel;

@Repository // Trata a interface como a camada de persistência
public interface ColaboradorRepository extends JpaRepository<ColaboradorModel, Long>{
	
}
