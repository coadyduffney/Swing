package model;

/**
 *
 * @author Coady Duffney
 */
public class Person {

    private static int count = 0;
    
    private int id;
    private String name;
    private String occupation;
    private AgeCategory ageCategory;
    private EmploymentCategory employmentCategory;
    private String taxId;
    private boolean canCitizen;
    private Gender gender;
    
    public Person(String name, String occupation, AgeCategory ageCategory, EmploymentCategory employmentCategory,
            String taxId, boolean canCitizen, Gender gender) {
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.employmentCategory = employmentCategory;
        this.taxId = taxId;
        this.canCitizen = canCitizen;
        this.gender = gender;
        this.id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public EmploymentCategory getEmploymentCategory() {
        return employmentCategory;
    }

    public String getTaxId() {
        return taxId;
    }

    public boolean isCanCitizen() {
        return canCitizen;
    }

    public Gender getGender() {
        return gender;
    }
}
