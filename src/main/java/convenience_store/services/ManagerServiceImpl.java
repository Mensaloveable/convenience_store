package convenience_store.services;

import convenience_store.enums.Role;
import convenience_store.interfaces.ManagerService;
import convenience_store.models.Applicant;
import convenience_store.models.Staff;
import convenience_store.models.Store;

import java.util.function.Predicate;

import static convenience_store.enums.Qualification.HND;
import static convenience_store.enums.Qualification.OND;

public class ManagerServiceImpl implements ManagerService{
    @Override
    public String hireCashier(Store store, Applicant applicant) {

        Predicate<Applicant> agePredicate = app -> app.getAge() >= 18;
        Predicate<Applicant> qualificationPredicate = app -> app.getQualification().equals(OND) || app.getQualification().equals(HND);
        Predicate<Applicant> criteria = agePredicate.and(qualificationPredicate);

        if(criteria.test(applicant)) {
            store.getStaffList().add(new Staff(applicant.getFirstName(), applicant.getLastName(), applicant.getAge(), applicant.getPhoneNumber(),
                    applicant.getGender(), Role.CASHIER, applicant.getQualification()));
            store.getApplicantList().remove(applicant);
            return applicant.getFirstName() + " " + applicant.getLastName() + " is hired";
        }
        return applicant.getFirstName() + " " + applicant.getLastName() + " doesn't meet criteria";
    }
}
