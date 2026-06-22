package monitor_ml_promo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(nullable = false, updatable = false)
    private String id;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @Column(length = 500)
    private String permalink;

    @Column(length = 500)
    private String thumbnail;

    public Product() {

    }

    public Product(String id, String title, String permalink, String thumbnail) {
        this.id = id;
        this.title = title;
        this.permalink = permalink;
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
