package nl.novi.loahy.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="about_brand")
public class AboutBrand {

    @Id
    @Column(nullable = false, unique = true)
    private String brandTitle;

    @Column(columnDefinition = "TEXT")
    private String brandInformation;


    public String getBrandTitle() {
        return brandTitle;
    }

    public void setBrandTitle(String brandTitle) {
        this.brandTitle = brandTitle;
    }

    public String getBrandInformation() {
        return brandInformation;
    }

    public void setBrandInformation(String brandInformation) {
        this.brandInformation = brandInformation;
    }

}
