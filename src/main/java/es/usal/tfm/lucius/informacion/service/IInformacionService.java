package es.usal.tfm.lucius.informacion.service;

import java.util.Map;

public interface IInformacionService {
	
	Map<String,Double> getStatsTotales();
	
	Map<String,Double> getStatsCostePorPieza();
	
	Map<String,Double> getStatsClientes();

}
