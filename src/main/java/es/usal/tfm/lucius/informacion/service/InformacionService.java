package es.usal.tfm.lucius.informacion.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.usal.tfm.lucius.grafica.dto.ClienteDto;
import es.usal.tfm.lucius.grafica.dto.ContratoDto;
import es.usal.tfm.lucius.grafica.dto.GastoDto;
import es.usal.tfm.lucius.grafica.repository.GastosRepository;
import es.usal.tfm.lucius.grafica.service.IClienteService;
import es.usal.tfm.lucius.grafica.service.IContratoService;

@Service
public class InformacionService implements IInformacionService {
	
	@Autowired
	IClienteService clienteService;
	
	@Autowired
	IContratoService contratoService;
	
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
		Map<String,Double> ordGastos = new TreeMap<String,Double>(gastos);
		return ordGastos;
	}

	@Override
	public Map<String,Map<String,Double>> getStatsTotalesDetalle() {
		String formato="YYYY-MM";
		SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
		List<GastoDto> listGastos = (List<GastoDto>) grepository.findAll();
		Map<String,Map<String,Double>> gastos = new TreeMap<String,Map<String,Double>>();
		for(GastoDto g : listGastos) {
			String fecha = String.valueOf(dateFormat.format(g.getFecha()));
			if(gastos.containsKey(fecha)) {
				if(gastos.get(fecha).containsKey(g.getTipo())) {
					Double value = gastos.get(fecha).get(g.getTipo()) + g.getImporte();
					gastos.get(fecha).put(g.getTipo().toLowerCase(), value);
				} else {
					gastos.get(fecha).put(g.getTipo().toLowerCase(), g.getImporte());
				}
			} else {
				gastos.put(fecha, new HashMap<String,Double>());
				gastos.get(fecha).put(g.getTipo().toLowerCase(), g.getImporte());
			}
		}
		return gastos;
	}

	@Override
	public Map<String, Double> getStatsCostePorPieza() {
		return null;
	}

	@Override
	public Map<String, Double> getStatsClientesCpP(String id) {
		Map<String,Double> datos = new TreeMap<String,Double>();
		List<ContratoDto> contratos = contratoService.getContratosByClienteId(id);
		for(ContratoDto c : contratos) {
			datos.put(c.getId(), c.getCost_pieza());
		}
		return datos;
	}

	@Override
	public Map<String, Double> getStatsClienteBalance(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> getStatsClienteGF(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
