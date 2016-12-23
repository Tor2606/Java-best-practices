package JavaObjectRessurection;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class ResurrectionSample {

    static final List ZOMBIES = newArrayList();

    static class Zombies{
        private int num;
        public Zombies(int num){
            this.num = num;
        }

        @Override
        protected void finalize(){
            System.out.println("Resurrect " + num);
            ZOMBIES.add(this);
        }

        @Override
        public String toString() {
            return "Zombies{" +
                    "num=" + num +
                    '}';
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 3; i++) ZOMBIES.add(new Zombies(i));
        for (int j = 0; j<5 ; j++){
            System.out.println("Zombies: " + ZOMBIES);
            ZOMBIES.clear();
            System.gc();
            Thread.sleep(100);
        }
    }
}
