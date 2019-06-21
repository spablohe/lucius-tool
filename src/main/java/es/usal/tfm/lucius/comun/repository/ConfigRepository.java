package es.usal.tfm.lucius.comun.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.usal.tfm.lucius.comun.dto.ConfigDto;

@Repository
public interface ConfigRepository extends CrudRepository<ConfigDto, String> {

}
