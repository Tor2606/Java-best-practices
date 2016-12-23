package GoogleGuava.String;

import com.google.common.base.Splitter;

import static com.google.common.collect.Lists.newArrayList;

public class SplitterSample {
    public static void main(String[] args) {
        Iterable<String> tokens = Splitter.on(',').split("one, two, three");
        newArrayList(tokens).forEach(s->System.out.println(s));

        Splitter splitter = Splitter.on(',').omitEmptyStrings().trimResults();
        newArrayList(splitter.split("one, ,two, three")).forEach(s-> System.out.println(s));
    }
}
