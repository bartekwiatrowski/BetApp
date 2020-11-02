package pl.wiatrowski.BetApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BetAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetAppApplication.class, args);
	}

}

