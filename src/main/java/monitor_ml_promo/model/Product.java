package monitor_ml_promo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
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
