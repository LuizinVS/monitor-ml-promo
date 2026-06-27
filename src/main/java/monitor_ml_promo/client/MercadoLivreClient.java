package monitor_ml_promo.client;

import monitor_ml_promo.DTO.MercadoLivreItemResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class MercadoLivreClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String BASE_URL = "https://api.mercadolibre.com";

    public MercadoLivreItemResponse getItemById(String id) {

        String url = BASE_URL + "/items/" + id;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("User-Agent", "Mozilla/5.0");

            HttpEntity<Void> entity = new HttpEntity<>(headers);

            ResponseEntity<MercadoLivreItemResponse> response =
                    restTemplate.exchange(
                            url,
                            HttpMethod.GET,
                            entity,
                            MercadoLivreItemResponse.class
                    );

            return response.getBody();

        } catch (HttpClientErrorException e) {
            System.out.println("Erro ML: " + e.getStatusCode());
            System.out.println("Body: " + e.getResponseBodyAsString());

            throw e;
        }
    }
}