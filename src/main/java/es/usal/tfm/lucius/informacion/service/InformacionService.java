package es.usal.tfm.lucius.informacion.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.usal.tfm.lucius.grafica.dto.GastoDto;
import es.usal.tfm.lucius.grafica.repository.GastosRepository;

@Service
public class InformacionService implements IInformacionService {
	
	@Autowired
	GastosRepository grepository;

	public InformacionService() {
		super();
	}

	@Override
	public Map<String, Double> getStatsTotales() {
		String formato="YYYY-MM";
		SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
		List<GastoDto> listGastos = (List<GastoDto>) grepository.findAll();
		Map<String,Double> gastos = new HashMap<String,Double>();
		for(GastoDto g : listGastos) {
			String fecha = String.valueOf(dateFormat.format(g.getFecha()));
			if(gastos.containsKey(fecha)) {
				Double value = gastos.get(fecha) + g.getImporte();
				gastos.put(fecha, value);
			} else {
				gastos.put(fecha, g.getImporte());
			}
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
