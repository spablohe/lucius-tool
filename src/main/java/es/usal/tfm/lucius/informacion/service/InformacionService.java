package es.usal.tfm.lucius.informacion.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import es.usal.tfm.lucius.grafica.dto.GastoDto;
import es.usal.tfm.lucius.grafica.repository.GastosRepository;

public class InformacionService implements IInformacionService {
	
	@Autowired
	GastosRepository grepository;

	public InformacionService() {
		super();
	}

	@Override
	public Map<String, Double> getStatsTotales() {
		List<GastoDto> listGastos = (List<GastoDto>) grepository.findAll();
		Map<String,Double> gastos = new HashMap<String,Double>();
		for(GastoDto g : listGastos) {
			gastos.put(g.getFecha().toString(), g.getImporte());
		}
		return gastos;
	}

	@Override
	public Map<String, Double> getStatsCostePorPieza() {
		return null;
	}

	@Override
	public Map<String, Double> getStatsClientes() {
		return null;
	}

}
