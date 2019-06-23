package es.usal.tfm.lucius.grafica.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.usal.tfm.lucius.grafica.dto.ClienteDto;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteDto, String> {

	
	
}
