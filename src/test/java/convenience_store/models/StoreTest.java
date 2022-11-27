package convenience_store.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @Test
    void readProduct() {
        Store superStore = new Store();
        int productListSizeBeforeReadingCSV = superStore.getProductsList().size();

        superStore.readProduct("src/main/resources/products.csv");

        int productListSizeAfterReadingCSV = superStore.getProductsList().size();

        assertNotEquals(productListSizeBeforeReadingCSV, productListSizeAfterReadingCSV);
    }
}