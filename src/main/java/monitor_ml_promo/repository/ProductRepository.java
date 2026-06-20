package monitor_ml_promo.repository;

import monitor_ml_promo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
    extends JpaRepository<Product, String> {
}
