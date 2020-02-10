/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

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
    
    public ArrayList<Person> getPeople() {
        return new ArrayList<>(people);
    }
    
    
}
