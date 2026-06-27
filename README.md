## Como rodar o projeto

1. Subir banco:
   docker compose up -d

2. Rodar aplicação:
   ./mvnw spring-boot:run

3. Expor API com ngrok:
   ngrok http 8080

4. Configurar Redirect URI:
   https://portion-swipe-satiable.ngrok-free.dev/oauth/callback
