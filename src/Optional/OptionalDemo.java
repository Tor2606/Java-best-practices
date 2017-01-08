package Optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> name = Optional.of("Igor");
        Optional empty = Optional.ofNullable(null);

        if(name.isPresent()){
            System.out.println(name.get());
        }
        try{
            System.out.println(empty.get());
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        name.ifPresent((v)-> System.out.println("Length is " + v.length()));

        System.out.println(empty.orElse("There is no value in empty!"));
        System.out.println(name.orElse("There is some value"));

        System.out.println(empty.orElseGet(()->"Default Value"));
        System.out.println(name.orElseGet(()->"Default Value"));

        try{
            empty.orElseThrow(Exception::new);
        }catch (Throwable e){
            System.out.println(e.getMessage());
        }

        Optional<String> upperName = name.map((value) -> value.toUpperCase());
        System.out.println(upperName.orElse("No value found"));

        upperName= name.flatMap((value)-> Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("No value found"));

        Optional<String> longName = name.filter((value)->value.length()>6);
        System.out.println(longName.orElse("Name is less < 6"));

        Optional<String> anotherName = Optional.of("Sana");

    }
}
