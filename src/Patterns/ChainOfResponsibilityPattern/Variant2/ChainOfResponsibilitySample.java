package Patterns.ChainOfResponsibilityPattern.Variant2;

import java.util.ArrayList;
import java.util.List;

public class ChainOfResponsibilitySample {

    public static void main(String[] args) {
        List<String> fileList = populateFiles();
        Parser xmlParser = new XmlParserLast();
        Parser jsonParser = new JsonParser(xmlParser);
        Parser txtParser = new TxtParser(jsonParser);

        fileList.forEach(txtParser::parse);
    }

    private static List<String> populateFiles(){
        List<String> fileList = new ArrayList<>();
        fileList.add("someFile.txt");
        fileList.add("otherFile.json");
        fileList.add("xmlFile.xml");
        fileList.add("csvFile.csv");
        fileList.add("csvFile.doc");
        return fileList;
    }

}
