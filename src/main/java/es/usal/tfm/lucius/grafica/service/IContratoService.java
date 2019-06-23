package es.usal.tfm.lucius.grafica.service;

import java.util.List;

import es.usal.tfm.lucius.grafica.dto.ContratoDto;

public interface IContratoService {
	
	List<ContratoDto> getAllContratos();
	
	ContratoDto getContratoById(String id);
	
	List<ContratoDto> getContratosByClienteId(String id_cliente);

}
