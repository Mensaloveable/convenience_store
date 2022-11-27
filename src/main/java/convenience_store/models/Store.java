package convenience_store.models;

import convenience_store.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
@AllArgsConstructor
@Getter
@Setter

public class Store {
    private  final String storeName = "Loveable SuperStore";
    private Double accountBalance = 0d;
    private List<Product> productsList;
    private List<Staff> staffList;
    private List<Applicant> applicantList;
    private Queue<Customer> customerQueue = new LinkedList<>();
    private PriorityQueue<Customer> customerPriorityQueue = new PriorityQueue<>(new PrioritySort());

    public Store() {
        this.productsList = new ArrayList<>();
        this.staffList = new ArrayList<>();
        this.applicantList = new ArrayList<>();
    }

    public void readProduct(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String item;
            int count = 0;
            while ((item = reader.readLine()) != null) {
                if (count > 0) {
                    String[] itemArray = item.split(",");
                    productsList.add(new Product(itemArray[0],
                            Category.valueOf(itemArray[1]),
                            itemArray[2],
                            Double.valueOf(itemArray[3]),
                            Integer.valueOf(itemArray[4])));
                }
                ++count;
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeName='" + storeName + '\'' +
                ",\naccountBalance=" + accountBalance +
                ",\nproductsList=" + productsList +
                ",\nstaffList=" + staffList +
                ",\napplicantList=" + applicantList +
                ",\ncustomerQueue=" + customerQueue +
                ",\ncustomerPriorityQueue=" + customerPriorityQueue +
                '}';
    }

}

class PrioritySort implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        return o2.getQuantity().compareTo(o1.getQuantity());
    }
}
