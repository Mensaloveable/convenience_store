package convenience_store.models;

import convenience_store.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Product {
    private String productName;
    private Category category;
    private String productId ;
    private Double productPrice;
    private Integer quantity;

    @Override
    public String toString() {
        return "\nProduct{" +
                "productName='" + productName + '\'' +
                ", category=" + category +
                ", productId='" + productId + '\'' +
                ", productPrice=" + productPrice +
                ", quantity=" + quantity +
                '}';
    }
}
