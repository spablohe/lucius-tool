package es.usal.tfm.lucius.grafica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.usal.tfm.lucius.grafica.dto.ContratoDto;
import es.usal.tfm.lucius.grafica.repository.ContratoRepository;

@Service
public class ContratoService implements IContratoService {
	
	@Autowired
	ContratoRepository repository;

	public ContratoService() {
		super();
	}

	@Override
	public List<ContratoDto> getAllContratos() {
		return (List<ContratoDto>) repository.findAll();
	}

	@Override
	public ContratoDto getContratoById(String id) {
		return repository.findById(id).get();
	}

	@Override
	public List<ContratoDto> getContratosByClienteId(String id_cliente) {
		return repository.findAllByClienteId(id_cliente);
	}

}
