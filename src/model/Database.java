package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Coady Duffney
 */
public class Database {
    private ArrayList<Person> people;
    
    public Database() {
        people = new ArrayList<Person>();
    }
    
    public void addPerson(Person person) {
        people.add(person);
    }
    
    public List<Person> getPeople() {
        return people;
    }
    
    
}
