package es.usal.tfm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LuciusToolApplication {

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(LuciusToolApplication.class, args);
	}

}
