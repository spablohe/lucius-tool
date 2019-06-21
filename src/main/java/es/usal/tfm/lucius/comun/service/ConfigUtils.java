package es.usal.tfm.lucius.comun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.usal.tfm.lucius.comun.dto.ConfigDto;
import es.usal.tfm.lucius.comun.repository.ConfigRepository;

@Service
public class ConfigUtils implements IConfigUtils {
	
	@Autowired
	ConfigRepository repository;

	public ConfigUtils() {
		super();
	}

	@Override
	public List<ConfigDto> findAll() {
		return (List<ConfigDto>) repository.findAll();
	}

}
