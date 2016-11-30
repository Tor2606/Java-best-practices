package Cloning.DeepCloning;

import Cloning.ShallowCloning.University;

//slowly, manual, but deep cloning
public class DeepCloningSample {
    public static void main(String[] args) throws CloneNotSupportedException {
        University university = new University("kpi");
        Country country = new Country(university);
        Country countryClone = (Country) country.clone();
        System.out.println(country);
        System.out.println(countryClone);
        System.out.println(country.getUniversity().getName());
        System.out.println(countryClone.getUniversity().getName());
        System.out.println("Univ names:" + (country.getUniversity().getName()==countryClone.getUniversity().getName()));
        System.out.println(country.getUniversity());
        System.out.println(countryClone.getUniversity());

    }
}
