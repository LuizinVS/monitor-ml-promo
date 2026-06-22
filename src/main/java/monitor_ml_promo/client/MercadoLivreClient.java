package monitor_ml_promo.client;

import monitor_ml_promo.DTO.MercadoLivreItemResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MercadoLivreClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String BASE_URL = "https://api.mercadolibre.com";

    public MercadoLivreItemResponse getItemById(String id) {
        String url = BASE_URL + "/items/" + id;

        return restTemplate.getForObject(url, MercadoLivreItemResponse.class);
    }
}