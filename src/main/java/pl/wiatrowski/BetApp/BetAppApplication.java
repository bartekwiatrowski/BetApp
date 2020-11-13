package pl.wiatrowski.BetApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import pl.wiatrowski.BetApp.config.SwaggerConfiguration;

@SpringBootApplication
@EnableAsync
@Import(SwaggerConfiguration.class)
public class BetAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetAppApplication.class, args);
	}

}

