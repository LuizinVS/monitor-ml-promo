package monitor_ml_promo;

import monitor_ml_promo.model.Product;
import monitor_ml_promo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MonitorMlPromoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorMlPromoApplication.class, args);
	}

}
