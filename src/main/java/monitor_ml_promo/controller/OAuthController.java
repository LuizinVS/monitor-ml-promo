package monitor_ml_promo.controller;

import monitor_ml_promo.DTO.TokenResponseDTO;
import monitor_ml_promo.service.OAuthService;
import monitor_ml_promo.service.TokenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {

    private final OAuthService oauthService;
    private final TokenService tokenService;

    public OAuthController(OAuthService oauthService,
                           TokenService tokenService) {

        this.oauthService = oauthService;
        this.tokenService = tokenService;
    }

    @GetMapping("/oauth/callback")
    public TokenResponseDTO callback(@RequestParam String code) {

        TokenResponseDTO token =
                oauthService.exchangeCode(code);

        tokenService.setAccessToken(token.getAccess_token());

        return token;
    }

}
