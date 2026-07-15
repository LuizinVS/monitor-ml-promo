package monitor_ml_promo.client;

import monitor_ml_promo.DTO.MercadoLivreBatchItemResponse;
import monitor_ml_promo.DTO.MercadoLivreItemResponse;
import monitor_ml_promo.service.TokenService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MercadoLivreClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final TokenService tokenService;

    private static final String BASE_URL = "https://api.mercadolibre.com";

    public MercadoLivreClient(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public MercadoLivreItemResponse getItemById(String id) {
        return getItemsByIds(List.of(id)).get(0);
    }

    public List<MercadoLivreItemResponse> getItemsByIds(List<String> ids) {
        String idsParam = String.join(",", ids);
        String url = BASE_URL + "/items?ids=" + idsParam;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + tokenService.getAccessToken());

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<MercadoLivreBatchItemResponse[]> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, MercadoLivreBatchItemResponse[].class
        );

        return Arrays.stream(response.getBody())
                .map(MercadoLivreBatchItemResponse::getBody)
                .collect(Collectors.toList());
    }
}