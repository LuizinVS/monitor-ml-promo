package monitor_ml_promo.controller;

import monitor_ml_promo.model.PriceHistory;
import monitor_ml_promo.model.Product;
import monitor_ml_promo.repository.PriceHistoryRepository;
import monitor_ml_promo.repository.ProductRepository;
import monitor_ml_promo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;
    private final ProductRepository productRepository;
    private final PriceHistoryRepository priceHistoryRepository;

    public ProductController(ProductService service,
                             ProductRepository productRepository,
                             PriceHistoryRepository priceHistoryRepository) {
        this.service = service;
        this.productRepository = productRepository;
        this.priceHistoryRepository = priceHistoryRepository;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Product> fetchAndSaveProduct(@PathVariable String id) {

        service.fetchAndSaveProduct(id);

        Optional<Product> p = productRepository.findById(id);

        return p.map(product -> new ResponseEntity<>(product, HttpStatus.CREATED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}/history")
    public ResponseEntity<List<PriceHistory>> getPriceHistory(@PathVariable String id) {
        List<PriceHistory> history = priceHistoryRepository.findByProduct_IdOrderByTimestampDesc(id);
        return ResponseEntity.ok(history);
    }
}
