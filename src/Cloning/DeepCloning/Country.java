package Cloning.DeepCloning;

import Cloning.ShallowCloning.University;

//slowly but deepcloning
public class Country implements Cloneable {

    private University university;

    public Country(University university) {
        this.university = university;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Country(new University(university.getName()));
    }
}
