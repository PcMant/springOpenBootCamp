package com.example.ejerciciosSesiones4_5_6;

import com.example.ejerciciosSesiones4_5_6.entities.Latop;
import com.example.ejerciciosSesiones4_5_6.repository.LatopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EjerciciosSesiones456Application {

	public static void main(String[] args) {

//		SpringApplication.run(EjerciciosSesiones456Application.class, args);

		ApplicationContext context = SpringApplication.run(EjerciciosSesiones456Application.class, args);
		LatopRepository repository = context.getBean(LatopRepository.class);

		// Crear latops
		Latop latop1 = new Latop(null, "HP", "Pavilium dv6", 2008, "123abc");
		Latop latop2 = new Latop(null, "Toshiba", "Satellite L650", 2010, "abv321");

		// Almacenar latops
		repository.save(latop1);
		repository.save(latop2);
	}

}
