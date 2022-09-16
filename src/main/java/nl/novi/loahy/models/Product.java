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
    @Column
    private Integer productId;
    @Column
    private String productName;
    @Column(columnDefinition = "TEXT")
    private String productInformation;
    @Column
    private Double productPrice;
    @Column
    private Integer productQuantity;

    @OneToOne
    FileUploadResponse file;

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
            Double productPrice,
            Integer productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productInformation = productInformation;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
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

    public String getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(String productInformation) {
        this.productInformation = productInformation;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public FileUploadResponse getFile() {
        return file;
    }

    public void setFile(FileUploadResponse file) {
        this.file = file;
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

