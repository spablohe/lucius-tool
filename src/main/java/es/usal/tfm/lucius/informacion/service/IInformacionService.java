package es.usal.tfm.lucius.informacion.service;

import java.util.Map;

public interface IInformacionService {
	
	Map<String,Double> getStatsTotales();
	
	Map<String,Map<String,Double>> getStatsTotalesDetalle();
	
	Map<String,Double> getStatsClientesCpP(String id);
	
	Map<String,Double> getStatsClienteBalance(String id);
	
	Map<String,Double> getStatsClienteGF(String id);

}
