package Patterns.ObserverPattern;

import java.util.Observable;
import java.util.Observer;

public class Person implements Observer {

    String personName;

    private Person father;

    public Person(String personName) {
        this.personName = personName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Hello" + personName + ", Product is now " + arg + " in store");
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }
}
