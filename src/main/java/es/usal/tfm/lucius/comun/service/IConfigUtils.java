package es.usal.tfm.lucius.comun.service;

import java.util.List;

import es.usal.tfm.lucius.comun.dto.ConfigDto;

public interface IConfigUtils {
	
	List<ConfigDto> findAll();
	
	String findById(String id);

}
