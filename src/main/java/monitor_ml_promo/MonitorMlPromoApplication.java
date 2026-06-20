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

    @Bean
    CommandLineRunner test(ProductRepository repository) {
        return args -> {
            Product product = new Product();

            product.setId("MLB123");
            product.setTitle("Produto Teste");

            repository.save(product);

            System.out.println("Produto salvo com sucesso!");
        };
    }
}
