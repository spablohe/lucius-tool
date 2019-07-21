package es.usal.tfm.lucius.notificaciones.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificacionesController {
	
	@Scheduled(fixedRate = 3000)
	public void jobBuscarNotificaciones() {
		System.out.println("jobBuscarNotificaciones");
	}
	
}
