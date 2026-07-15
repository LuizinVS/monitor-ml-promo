package monitor_ml_promo.service;


import monitor_ml_promo.DTO.TokenResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


import java.time.LocalDateTime;

@Service
public class TokenService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${mercadolivre.client-id}")
    private String clientId;

    @Value("${mercadolivre.client-secret}")
    private String clientSecret;

    private String cachedToken;
    private LocalDateTime tokenExpiresAt;

    public String getAccessToken() {
        if (cachedToken == null || LocalDateTime.now().isAfter(tokenExpiresAt)) {
            renewToken();
        }
        return cachedToken;
    }

    private void renewToken() {
        String url = "https://api.mercadolibre.com/oauth/token";

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");
        body.add("client_id", clientId);
        body.add("client_secret", clientSecret);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

        TokenResponseDTO response = restTemplate.postForObject(url, request, TokenResponseDTO.class);

        this.cachedToken = response.getAccess_token();
        this.tokenExpiresAt = LocalDateTime.now().plusSeconds(response.getExpires_in() - 60);
    }
}
