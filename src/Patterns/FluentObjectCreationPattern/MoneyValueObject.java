package Patterns.FluentObjectCreationPattern;

import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;

public class MoneyValueObject {
    private Long value;
    private String countryOfOrigin;
    private Currency currency;
    private String type;
    private String reverse;
    private String obverse;
    private List<String> colors;
    private Date year;

    private MoneyValueObject() {
    }

    public static class Builder {
        private MoneyValueObject temp = new MoneyValueObject();

        public Builder value(Long val) {
            temp.value = val;
            return this;
        }

        public Builder countryOfOrigin(String countryOfOrigin) {
            temp.countryOfOrigin = countryOfOrigin;
            return this;
        }

        public Builder currency(Currency c) {
            temp.currency = c;
            return this;
        }

        public Builder type(String t) {
            temp.type = t;
            return this;
        }

        public Builder reverse(String r) {
            temp.reverse = r;
            return this;
        }

        public Builder obverse(String o) {
            temp.obverse = o;
            return this;
        }

        public Builder addColor(String c) {
            if (temp.colors == null) {
                temp.colors = new ArrayList<String>();
            }
            temp.colors.add(c);
            return this;
        }

        public MoneyValueObject build(){
            if(Strings.isNullOrEmpty(temp.type) || temp.currency ==null){
                throw new IllegalArgumentException("Coin currency and type required");
            }
            return temp;
        }
    }
}
