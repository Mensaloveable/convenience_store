package convenience_store.models;

import convenience_store.enums.Gender;
import convenience_store.enums.Qualification;
import convenience_store.enums.Role;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class Manager extends Staff{
    private Role role = Role.MANAGER;

    public Manager(String firstName, String lastName, Integer age, String phoneNumber, Gender gender, Role role, Qualification qualification) {
        super(firstName, lastName, age, phoneNumber, gender, role, qualification);

    }

    @Override
    public String toString() {
        return "Manager{" + super.toString() +
                "role=" + role +
                "}";
    }
}
