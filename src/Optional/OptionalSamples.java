package Optional;

import Patterns.ObserverPattern.Person;

import java.util.Optional;

public class OptionalSamples {
    public static void main(String[] args) {
        Optional<Person> person = Optional.of(new Person("Name"));
        try{
            Optional<Person> nullPers = Optional.of(null);
        }catch (Exception e){
            System.out.println("Can't pass null to Optional.of()");
        }
        Optional<Person> nullable = Optional.ofNullable(null);
        Optional<Person> person2 = Optional.ofNullable(new Person("Name2"));
        Optional<Person> empty = Optional.empty();
        person.ifPresent(p -> System.out.println(p.getPersonName()));
        nullable.ifPresent(p -> System.out.println(p.getPersonName()));
        empty.ifPresent(p -> System.out.println(p.getPersonName()));
        if(nullable.isPresent()) System.out.println("Present");
        Person personNew = nullable.orElse(person2.get());//.orElseThrow(new Exception())
        System.out.println(personNew.getPersonName());

        Person personCom = new Person("Complex_name");
        personCom.setFather(person.get());
        Optional<Person> personComplex = Optional.of(personCom);
        String someValue = personComplex.map(Person::getFather).map(Person::getPersonName).orElse("Empty");
        System.out.println("Father: " + someValue);
    }
}
