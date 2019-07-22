package es.usal.tfm.lucius.jobs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class JobsScheduler {
	
	Logger logger = LogManager.getLogger(JobsScheduler.class);

	/**
	 * Ejecucion: Todos los lunes y jueves a las 4 de la mañana
	 * Tarea de prueba
	 */
	@Scheduled(cron = "0 0 4 ? * 1,4 ")
	public void jobBuscarNotificaciones() {
		System.out.println("CRON EJECUTADO DE GENERAR INFORMES");
		logger.info("CRON EJECUTAR SISTEMAS: --- OK");
	}

}
