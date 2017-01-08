package Patterns.Prototype.AmoebaExample;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class AmoebaRunner {
    public static void main(String[] args) {
        Unicellular amoeba = new Amoeba();
        List<Unicellular> list = newArrayList(amoeba);
        list.add(amoeba.reproduce());
        list.add(amoeba.reproduce());

        list.forEach(System.out::println);
    }
}
