package convenience_store.interfaces;

import convenience_store.models.Customer;
import convenience_store.models.Product;

import java.util.List;

public interface CustomerService {
    void addToCart(Product... products);
    List<Product> buyProducts();

    void checkout(Customer customer);
}
