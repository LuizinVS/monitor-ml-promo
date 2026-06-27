package monitor_ml_promo.service;

import org.springframework.beans.factory.annotation.Value;
import monitor_ml_promo.DTO.TokenResponseDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class OAuthService {

    @Value("${mercadolivre.client-id}")
    private String clientId;

    @Value("${mercadolivre.client-secret}")
    private String clientSecret;

    @Value("${mercadolivre.redirect-uri}")
    private String redirectUri;

    private final RestTemplate restTemplate = new RestTemplate();

    public TokenResponseDTO exchangeCode(String code) {

        String url = "https://api.mercadolibre.com/oauth/token";

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", clientId);
        body.add("client_secret", clientSecret);
        body.add("code", code);
        body.add("redirect_uri", redirectUri);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<>(body, headers);

        return restTemplate.postForObject(url, request, TokenResponseDTO.class);
    }
}
