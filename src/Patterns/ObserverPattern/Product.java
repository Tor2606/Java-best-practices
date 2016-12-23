package Patterns.ObserverPattern;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import static com.google.common.collect.Lists.newArrayList;

public class Product extends Observable {

    private ArrayList<Observer> observers = newArrayList();
    private String productName;
    private String productType;
    String availability;

    public Product(String productName, String productType, String availability){
        super();
        this.productName = productName;
        this.productType = productType;
        this.availability = availability;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        if(!(this.availability.equalsIgnoreCase(availability)))
        {
            this.availability = availability;
            setChanged();
            notifyObservers(this, availability);
        }
    }

    private void notifyObservers(Observable observable, String availability) {
        System.out.println("Notifying subscribers!");
        observers.forEach(o->o.update(observable, this.availability));
    }

    public void registerObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
}
