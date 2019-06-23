package es.usal.tfm.lucius.grafica.service;

import java.util.List;

import es.usal.tfm.lucius.grafica.dto.ClienteDto;

public interface IClienteService {
	
	List<ClienteDto> getAllClientes();
	
	ClienteDto getClienteById(String id);

}
