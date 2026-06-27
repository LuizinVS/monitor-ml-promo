package monitor_ml_promo.repository;

import monitor_ml_promo.model.PriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Long> {
    List<PriceHistory> findByProduct_IdOrderByTimestampDesc(String productId);
}
