package nl.novi.loahy.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="products")
public class Product{

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "product_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1006"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_description",
            columnDefinition = "TEXT")
    private String productDescription;
    @Column(name = "product_price")
    private Double productPrice;

    @OneToOne
    FileUploadResponse image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToMany(mappedBy = "wishlist")
    @JsonIgnore
    List<WishlistProduct> wishlistProducts;

    @OneToMany(mappedBy = "shoppingCart")
    @JsonIgnore
    List<ShoppingCartProduct> shoppingCartProducts;

    public Product(
            Integer productId,
            String productName,
            String productInformation,
            Double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productInformation;
        this.productPrice = productPrice;
    }

    public Product() {

    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productInformation) {
        this.productDescription = productInformation;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }


    public FileUploadResponse getImage() {
        return image;
    }

    public void setImage(FileUploadResponse file) {
        this.image = file;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<WishlistProduct> getWishlistProducts() {
        return wishlistProducts;
    }

    public void setWishlistProducts(List<WishlistProduct> wishlistProducts) {
        this.wishlistProducts = wishlistProducts;
    }

    public List<ShoppingCartProduct> getShoppingCartProducts() {
        return shoppingCartProducts;
    }

    public void setShoppingCartProducts(List<ShoppingCartProduct> shoppingCartProducts) {
        this.shoppingCartProducts = shoppingCartProducts;
    }
}

