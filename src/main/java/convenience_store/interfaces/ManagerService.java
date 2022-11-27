package convenience_store.interfaces;

import convenience_store.models.Applicant;
import convenience_store.models.Store;

public interface ManagerService {
    String hireCashier(Store store, Applicant applicant);
}
