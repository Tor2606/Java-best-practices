package Collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueSample {
    public static void main(String[] args) {
        Queue<Element> queue = new PriorityQueue<>();
        queue.add(new Element(22, "c"));
        queue.add(new Element(23, "a"));
        queue.add(new Element(24, "b"));

        //use compare
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    private static class Element implements Comparable<Element> {
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
