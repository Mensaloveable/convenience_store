package convenience_store.services;

import convenience_store.interfaces.CashierServices;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import convenience_store.models.Customer;
import convenience_store.models.Product;
import convenience_store.models.Store;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CashierServicesImpl implements CashierServices{

    private Store store;
    private Customer customer;
    static double totalBill = 0;

    public CashierServicesImpl(Store store) {
        this.store = store;
    }

    @Override
    public void sell(Customer customer) {
        System.out.println("Selling to " + customer.getFirstName() + "...");
        for(Map.Entry<Product, Integer> entry : customer.getCart().entrySet()) {
            store.setAccountBalance(store.getAccountBalance() + (entry.getKey().getProductPrice() * entry.getValue()));
        }
        customer.getCart().clear();
        customer.setQuantity(0);
        customer.setCartPrice(0d);
    }

    @Override
    public void sellToQueue(Collection<Customer> customerList) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        int totalCustomer = store.getCustomerQueue().size();
        for(int i = 0; i < totalCustomer; ++i) {
            Customer nextCustomer = store.getCustomerQueue().poll();
            assert nextCustomer != null;
            executorService.execute(() -> {
                try{
                    sleep(5000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(nextCustomer.getFirstName() + " is being attended to on " + Thread.currentThread().getName());
                sell(nextCustomer);
                System.out.println(nextCustomer.getFirstName() + " has been attended to");
            });
        }
        executorService.shutdown();
    }

    @Override
    public Double dispenseReceipt(Customer customer) {
        System.out.println("---------------------------------------------------------------------");
        System.out.println(customer.getFirstName() + " " + customer.getLastName());
        System.out.println("Data & Time: " + LocalDateTime.now());
        double total = 0;
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("%-9s %-10s %-8s %-8s %-11s%n", "Item name", "Product Id", "Price", "Quantity", "Total price");
        for(Map.Entry<Product, Integer> entry : customer.getCart().entrySet()) {
            Integer quantity = entry.getValue();
            Product product = entry.getKey();
            System.out.printf("%-9s %-10s %-8.2f %-8d %-11.2f%n", product.getProductName(), product.getProductId(),
                    product.getProductPrice(), quantity, product.getProductPrice() * quantity);
            total += (product.getProductPrice() * quantity);

        }
        System.out.printf("Total payment: %31.2f%n", total);
        System.out.println("---------------------------------------------------------------------");
        return total;
    }
}
