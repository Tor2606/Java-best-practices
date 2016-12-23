package GoogleGuava.Ordering;

import com.google.common.collect.Ordering;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class OrderingSample {
    public static void main(String[] args) {
        List<InnerPerson> list = newArrayList(new InnerPerson("n1", 12), new InnerPerson("n1", 28),new InnerPerson("n1", 19),new InnerPerson(null , 99), new InnerPerson("p4", 11));
        Collections.sort(list);
        System.out.println(list);
    }

    private static class InnerPerson implements Comparable<InnerPerson>{
        private String name;
        private int age;

        public InnerPerson(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        private static Ordering<InnerPerson> ORDER_BY_NAME = new Ordering<InnerPerson>() {
            @Override
            public int compare(@Nullable InnerPerson innerPerson, @Nullable InnerPerson t1) {
                return Ordering.natural().nullsLast().compare(innerPerson.getName(), t1.getName());
            }
        };

        private static Ordering<InnerPerson> ORDER_BY_AGE = new Ordering<InnerPerson>() {
            @Override
            public int compare(@Nullable InnerPerson innerPerson, @Nullable InnerPerson t1) {
                return Ordering.natural().reverse().compare(innerPerson.getAge(), t1.getAge());
            }
        };

        @Override
        public int compareTo(InnerPerson o) {
            return ORDER_BY_NAME.compound(ORDER_BY_AGE).compare(this, o);
        }

        @Override
        public String toString() {
            return "InnerPerson{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
