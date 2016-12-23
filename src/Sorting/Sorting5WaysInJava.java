package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Sorting5WaysInJava {
    private static List VEGETABLES = newArrayList("apple", "cocumbers", "blackberry");

    public static void main(String[] args) {
        sortPrint();
        reverseSort();
        comparatorCompare();
        Sorting5WaysInJava sorting5WaysInJava = new Sorting5WaysInJava();
        ArrayList<Element> list = sorting5WaysInJava.getList();
        Collections.sort(list);
        System.out.println(list);
    }

    private ArrayList<Element> getList(){
        return newArrayList(new Element(2,"C elem" ),new Element(1, "B elem"));
    }

    private static void reverseSort() {
        Collections.sort(VEGETABLES, Collections.reverseOrder());
        System.out.println("Reverse:" + VEGETABLES);
    }

    private static void sortPrint() {
        Collections.sort(VEGETABLES);
        System.out.println(VEGETABLES);
    }

    private static class StringComparator implements Comparator{
        public int compare(Object o1, Object o2){
            String so1 = (String) o1;
            String so2 = (String) o2;
            return so1.compareTo(so2);
        }
    }

    private static void comparatorCompare(){
        Collections.sort(VEGETABLES, new StringComparator());
        System.out.println("Comparator comp:" + VEGETABLES);
    }

    private class Element implements Comparable<Element>{
        private int num;
        private String name;

        public Element(int num, String name) {
            this.num = num;
            this.name = name;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Element o) {
            return this.getName().compareTo(o.getName());
        }

        @Override
        public String toString() {
            return "Element{" +
                    "num=" + num +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
