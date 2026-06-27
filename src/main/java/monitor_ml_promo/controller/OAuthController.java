package monitor_ml_promo.controller;

import monitor_ml_promo.DTO.TokenResponseDTO;
import monitor_ml_promo.service.OAuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {

    private final OAuthService oauthService;

    public OAuthController(OAuthService oauthService) {
        this.oauthService = oauthService;
    }

    @GetMapping("/oauth/callback")
    public TokenResponseDTO callback(@RequestParam String code) {
        return oauthService.exchangeCode(code);
    }
}
