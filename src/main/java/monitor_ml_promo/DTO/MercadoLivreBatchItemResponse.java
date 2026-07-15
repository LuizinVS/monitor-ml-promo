package monitor_ml_promo.DTO;

public class MercadoLivreBatchItemResponse {

    private Integer code;
    private MercadoLivreItemResponse body;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public MercadoLivreItemResponse getBody() {
        return body;
    }

    public void setBody(MercadoLivreItemResponse body) {
        this.body = body;
    }
}
