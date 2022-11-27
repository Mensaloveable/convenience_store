package convenience_store.interfaces;

import convenience_store.models.Customer;

import java.util.Collection;

public interface CashierServices {
    void sell(Customer customer);

    void sellToQueue(Collection<Customer> customerList);

    Double dispenseReceipt(Customer customer);
}
