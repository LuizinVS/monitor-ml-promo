package monitor_ml_promo.service;

import monitor_ml_promo.client.MercadoLivreClient;
import monitor_ml_promo.DTO.MercadoLivreItemResponse;
import monitor_ml_promo.model.PriceHistory;
import monitor_ml_promo.model.Product;
import monitor_ml_promo.repository.PriceHistoryRepository;
import monitor_ml_promo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final PriceHistoryRepository priceHistoryRepository;
    private final MercadoLivreClient mercadoLivreClient;

    public ProductService(ProductRepository productRepository,
                          PriceHistoryRepository priceHistoryRepository,
                          MercadoLivreClient mercadoLivreClient) {
        this.productRepository = productRepository;
        this.priceHistoryRepository = priceHistoryRepository;
        this.mercadoLivreClient = mercadoLivreClient;
    }

    public void fetchAndSaveProduct(String productId) {

        MercadoLivreItemResponse response =
                mercadoLivreClient.getItemById(productId);

        Product product = new Product();
        product.setId(response.id);
        product.setTitle(response.title);
        product.setPermalink(response.permalink);
        product.setThumbnail(response.thumbnail);

        productRepository.save(product);

        PriceHistory history = new PriceHistory();
        history.setProduct(product);
        history.setPrice(response.price);
        history.setTimestamp(LocalDateTime.now());

        priceHistoryRepository.save(history);
    }
}