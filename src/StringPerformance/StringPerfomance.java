package StringPerformance;

import org.perf4j.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by islabukhin on 13.09.16.
 */
public class StringPerfomance {

    private static final String SOURCE = "In the first case we compile the pattern and perform the search in two distinct steps. This approach is appropriate when we have to search multiple source texts for the same pattern. By compiling the pattern once we can maximize performance results due to the fact that the preprocessing is usually a heavy operation. On the other hand, for once of searches, the second approach provides a more convenient API.";

    public static List<Integer> findAll(String pattern, String source) {
        List<Integer> idx = new ArrayList<Integer>();
        int id = -1;
        int shift = pattern.length();
        int scnIdx = -shift;
        while (scnIdx != -1 || id == -1) {
            idx.add(scnIdx);
            id = scnIdx + shift;
            scnIdx = source.indexOf(pattern, id);
        }
        idx.remove(0);

        return idx;
    }

    public static List<Integer> findAllWithMatcher(String pattern, String source) {
        List<Integer> idx = new ArrayList<Integer>();
        Pattern ptrn = Pattern.compile(pattern);
        Matcher mtch = ptrn.matcher(source);
        while (mtch.find())
            idx.add(mtch.start());

        return idx;
    }

    public static void main(String[] args) {
        String pattern = "the";
        int iterations = 100;
        StopWatch stopWatchFindAll = new StopWatch();
        stopWatchFindAll.start();
        List<Integer> result = null;
        for (int i = 0; i < iterations; i++) {
            result = findAll(pattern, SOURCE);
            result = null;
        }
        stopWatchFindAll.stop();

        StopWatch stopWatchFindAllWithMatcher = new StopWatch();
        stopWatchFindAllWithMatcher.start();
        List<Integer> resultWithMatchers = null;
        for (int i = 0; i < iterations; i++) {
            resultWithMatchers = findAllWithMatcher(pattern, SOURCE);
            resultWithMatchers = null;
        }
        stopWatchFindAllWithMatcher.stop();
        System.out.println("FindAll : " + stopWatchFindAll.getElapsedTime());
        System.out.println("Find all with matchers : " + stopWatchFindAllWithMatcher.getElapsedTime());
    }

    /*for small and medium sizes findAll is better. When working with big texts it's better
    to use Backward Nondeterministic Dawg Matching algorithm*/


}
