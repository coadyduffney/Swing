package controller;

import java.util.List;
import model.AgeCategory;
import model.Database;
import model.EmploymentCategory;
import model.Gender;
import model.Person;
import view.FormEvent;

/**
 *
 * @author Coady Duffney
 */
public class Controller {
    Database db = new Database();
    
    public List<Person> getPeople() {
        return db.getPeople();
    }
    
    
    public void addPerson(FormEvent ev) {
        String name = ev.getName();
        String occupation = ev.getOccupation();
        int ageCatId = ev.getAgeCategory();
        String empCat = ev.getEmploymentCategory();
        boolean isCan = ev.isCanCitizen();
        String taxId = ev.getTaxId();
        String gender = ev.getGender();
        
        AgeCategory ageCategory = null;
        switch(ageCatId) {
            case 0:
                ageCategory = AgeCategory.CHILD;
                break;
            case 1:
                ageCategory = AgeCategory.ADULT;
                break;
            case 2:
                ageCategory = AgeCategory.SENIOR;
                break;                
        }
        
        EmploymentCategory employmentCategory;
        if (empCat.equals("employed")) {
            employmentCategory = EmploymentCategory.EMPLOYED;
        } else if (empCat.equals("self-employed")) {
            employmentCategory = EmploymentCategory.SELF_EMPLOYED;
        } else if (empCat.equals("unemployed")) {
            employmentCategory = EmploymentCategory.UNEMPLOYED;
        } else {
            employmentCategory = EmploymentCategory.OTHER;
            System.out.println("empCat");
        }
        
        Gender genderCat;
        if (gender.equals("male")) {
            genderCat = Gender.MALE;
        } else {
            genderCat = Gender.FEMALE;
        }
        
        Person person = new Person(name, occupation, ageCategory, employmentCategory, taxId, isCan, genderCat);
        db.addPerson(person);
    }
}
