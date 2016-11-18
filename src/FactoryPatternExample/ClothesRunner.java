package FactoryPatternExample;

public class ClothesRunner {
    public static void main(String[] args) {
        Clothes clothes = ClothesFactory.creaateClothes("Hat");
        clothes.print();
    }
}
