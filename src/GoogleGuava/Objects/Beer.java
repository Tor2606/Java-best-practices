package GoogleGuava.Objects;

import com.google.common.base.Objects;

import java.util.List;

public class Beer {
    private String brand;
    private String type;
    private int alcoholPercentage;
    private List<String> ingridients;

    @Override
    public int hashCode() {
        return Objects.hashCode(brand, type, alcoholPercentage, ingridients);
    }

    @Override
    public boolean equals(final Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || getClass()!= obj.getClass()){
            return false;
        }
        final Beer other = (Beer) obj;
        return Objects.equal(this.brand, other.brand)&&Objects.equal(this.type, other.type)
                &&Objects.equal(this.alcoholPercentage, other.alcoholPercentage);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("brand", brand).add("type", type)
                .add("alcoholPercentage", alcoholPercentage).toString();
    }
}
