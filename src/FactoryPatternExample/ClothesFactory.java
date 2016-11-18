package FactoryPatternExample;

public class ClothesFactory {
    public static Clothes creaateClothes(String clothesName){
        if("Hat".equals(clothesName)){
            return new Hat();
        }else if("Shirt".equals(clothesName)){
            return new Shirt();
        }else{
            System.out.println("There is no such clothes!");
        }
        return null;
    }
}
