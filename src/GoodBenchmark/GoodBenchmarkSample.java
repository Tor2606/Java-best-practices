package GoodBenchmark;

import java.util.concurrent.Callable;

public class GoodBenchmarkSample {
    public static void main(String[] args) {
        Callable callableInt = new Callable(){
            public Long call() throws Exception {
                long result = 0;

                for (int f = 0; f < 32760; f++){
                    result += 444;
                }

                return result;
            }
        };

        Callable callableShort = new Callable(){
            public Long call() throws Exception {
                long result = 0;

                for (short f = 0; f < 32760; f++){
                    result += 444;
                }

                return result;
            }
        };

        /*try {
            Benchmark intBenchmark = new Benchmark(callableInt);

            System.out.println("Result with int ");
            System.out.println(intBenchmark.toString());

            Benchmark shortBenchmark = new Benchmark(callableShort);

            System.out.println("Result short ");
            System.out.println(shortBenchmark.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

}

