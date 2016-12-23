package Patterns.ObserverPattern;

public class ObserverMain {
    public static void main(String[] args) {
        Person person1 = new Person("John");
        Person person2 = new Person("Ara");

        Product samsung = new Product("Samsung", "Mobile", "Not available");

        samsung.registerObserver(person1);
        samsung.registerObserver(person2);

        samsung.setAvailability("Available");
    }
}
