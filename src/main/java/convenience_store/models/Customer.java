package convenience_store.models;

import convenience_store.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Customer extends Person{
    private Integer quantity = 0;
    private Double personalBalance;
    private  Double cartPrice = 0d;
    private Map<Product, Integer> cart = new HashMap<>();
    private List<Product> houseStore;

    public Customer(String firstName, String lastName, Integer age, String phoneNumber, Gender gender, Double personalBalance) {
        super(firstName, lastName, age, phoneNumber, gender);
        this.personalBalance = personalBalance;
    }

    @Override
    public String toString() {
        return "\nCustomer{" + super.toString() +
                "\nquantity=" + quantity +
                ",\npersonalBalance=" + personalBalance +
                ",\ncart=" + cart +
                ",\nhouseStore=" + houseStore +
                "}";
    }
}
