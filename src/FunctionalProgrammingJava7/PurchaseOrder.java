package FunctionalProgrammingJava7;

import JAXB_SAX_DOM_Performance.Person;

import java.util.Date;

public class PurchaseOrder {
    private Person person;
    private Date date;
    public PurchaseOrder(Person person) {
        this.person = person;
        this.date = new Date();
    }

    public Person getPerson() {
        return person;
    }

    public Date getDate() {
        return this.date;
    }
}
