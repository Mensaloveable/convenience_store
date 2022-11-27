package convenience_store.models;

import convenience_store.enums.Gender;
import convenience_store.enums.Qualification;
import convenience_store.enums.Role;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Cashier extends Staff{
    public Cashier(String firstName, String lastName, Integer age, String phoneNumber, Gender gender, Role role, Qualification qualification) {
        super(firstName, lastName, age, phoneNumber, gender, role, qualification);
    }

    @Override
    public String toString() {
        return "\nCashier{" + super.toString() + '}';
    }
}
