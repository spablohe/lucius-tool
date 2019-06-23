package es.usal.tfm.lucius.grafica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.usal.tfm.lucius.grafica.dto.ClienteDto;
import es.usal.tfm.lucius.grafica.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService {
	
	@Autowired
	ClienteRepository repository;

	public ClienteService() {
		super();
	}

	@Override
	public List<ClienteDto> getAllClientes() {
		return (List<ClienteDto>) repository.findAll();
	}

	@Override
	public ClienteDto getClienteById(String id) {
		return repository.findById(id).get();
	}

}
