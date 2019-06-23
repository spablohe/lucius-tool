package es.usal.tfm.lucius.grafica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.usal.tfm.lucius.grafica.dto.ContratoDto;

@Repository
public interface ContratoRepository extends CrudRepository<ContratoDto, String> {
	
	@Query(value="SELECT * FROM CONTRATOS WHERE id_cliente= :id_cliente",
			nativeQuery=true)
	List<ContratoDto> findAllByClienteId(@Param("id_cliente")
	String id_cliente);

}