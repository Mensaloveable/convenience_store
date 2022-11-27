package convenience_store.services;

import convenience_store.enums.Gender;
import convenience_store.enums.Qualification;
import convenience_store.enums.Role;
import convenience_store.interfaces.ManagerService;
import convenience_store.models.Applicant;
import convenience_store.models.Manager;
import convenience_store.models.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class ManagerServiceImplTest {

    @Test
    void testingHireCashier() {
        Store superStore = new Store();
        Manager ayo = new Manager("Ayo", "Ola", 60, "09187654321", Gender.FEMALE, Role.MANAGER, Qualification.BSC);
        ManagerService managerAyo = new ManagerServiceImpl();

        Applicant boye =  new Applicant("Boye", "John", 23, Gender.MALE,"09187654321", Qualification.HND);
        Applicant ben =  new Applicant("Ben", "Mosh", 16, Gender.MALE,"09187654321", Qualification.HND);

        Assertions.assertEquals("Boye John is hired", managerAyo.hireCashier(superStore, boye));
        Assertions.assertEquals("Ben Mosh doesn't meet criteria", managerAyo.hireCashier(superStore, ben));

    }
}