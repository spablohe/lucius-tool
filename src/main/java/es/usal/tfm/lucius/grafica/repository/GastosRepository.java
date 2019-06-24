package es.usal.tfm.lucius.grafica.repository;

import org.springframework.data.repository.CrudRepository;

import es.usal.tfm.lucius.grafica.dto.GastoDto;

public interface GastosRepository extends CrudRepository<GastoDto,String> {

}
