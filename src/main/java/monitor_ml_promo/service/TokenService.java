package monitor_ml_promo.service;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private String accessToken;

    public void setAccessToken(String token) {
        this.accessToken = token;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
