package convenience_store.services;

import convenience_store.exceptions.InsufficientFundException;
import convenience_store.exceptions.NotEnoughQuantityException;
import convenience_store.exceptions.OutOfStockException;
import convenience_store.interfaces.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import convenience_store.models.Customer;
import convenience_store.models.Product;
import convenience_store.models.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerServiceImpl extends Thread implements CustomerService{
    private Customer customer;
    private Store store;

    @Override
    public void addToCart(Product... products) {
        for (Product product : products) {
            if (product.getQuantity() == 0) {
                try {
                    throw new OutOfStockException("OUT OF STOCK");
                } catch (OutOfStockException outOfStockException) {
                System.out.printf("Sorry dear %s, %s %s%n",customer.getFirstName(), product.getProductName(), outOfStockException.getMessage());
                }
            } else if (product.getQuantity() != 0) {
                customer.setQuantity(customer.getQuantity() + 1);
                customer.setCartPrice(customer.getCartPrice() + product.getProductPrice());
                if (customer.getCart().containsKey(product)) {
                    customer.getCart().replace(product, customer.getCart().get(product) + 1);
                    System.out.println(product.getProductName() + " added to cart" + " (" + customer.getFirstName() + ")");
                    continue;
                }customer.getCart().put(product, 1);
                System.out.println(product.getProductName() + " added to cart" + " (" + customer.getFirstName() + ")");
            }
        }
    }

    @Override
    public  List<Product> buyProducts() {
        List<Product> productsBought = new ArrayList<>();
        try {
            if (customer.getCartPrice() <= customer.getPersonalBalance()) {
                System.out.println(customer.getFirstName() + " buying...");
                for (Map.Entry<Product, Integer> entry : customer.getCart().entrySet()) {
                    if (entry.getKey().getQuantity() >= entry.getValue()) {
                        customer.setPersonalBalance(customer.getPersonalBalance() - (entry.getKey().getProductPrice() * entry.getValue()));
                        entry.getKey().setQuantity(entry.getKey().getQuantity() - entry.getValue());
                        productsBought.add(entry.getKey());
                    } else {
                        throw new NotEnoughQuantityException("Sorry,there is only " + entry.getValue() + " " + entry.getKey().getProductName() + " left");
                    }
                }
            } else {
                throw new InsufficientFundException("Sorry " + customer.getFirstName() + ", you don't have sufficient fund");
            }
        } catch (NotEnoughQuantityException | InsufficientFundException e) {
            System.out.println(e.getMessage());
        }
                return productsBought;
    }

    @Override
    public void run() {
        buyProducts();
    }

    @Override
    public void checkout(Customer customer) {
       store.getCustomerQueue().offer(customer);
    }
}
