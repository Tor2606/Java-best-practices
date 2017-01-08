package Patterns.Prototype.AmoebaExample;

public class Amoeba implements Unicellular {
    @Override
    public Unicellular reproduce() {
        Unicellular result = null;
        try {
            result = (Unicellular) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String toString() {
        return "Amoeba " + this.hashCode();
    }
}
