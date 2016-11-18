package TextCompare;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;

public class TextCompareComponent extends CustomComponent {
    private Layout mainLayout = new VerticalLayout();
    private ArrayList<String> longestCommonSubsequenceList;
    private static final String INSERT_COLOR = "#99FFCC";
    private static final String DELETE_COLOR = "#CB6D6D";

    public static void main(String[] args) {
        System.out.println(new TextCompareComponent("some 1 text", "some 2 tert").getLongestCommonSubsequenceList());

    }

    public TextCompareComponent(String text1, String text2) {
        text1 = normalizeText(text1);
        text2 = normalizeText(text2);
        this.longestCommonSubsequenceList = longestCommonSequence(text1, text2);
        String result = markTextDifferences(text1, text2, longestCommonSubsequenceList, INSERT_COLOR, DELETE_COLOR);
        Label label = new Label(result, Label.CONTENT_XHTML);
        mainLayout.addComponent(label);
        setCompositionRoot(mainLayout);
    }

    private ArrayList<String> longestCommonSequence(String text1, String text2) {
        String[] text1Words = text1.split(" ");
        String[] text2Words = text2.split(" ");

        int text1WordCount = text1Words.length;
        int text2WordCount = text2Words.length;

        int[][] solutionMatrix = new int[text1WordCount + 1][text2WordCount + 1];

        for (int i = text1WordCount - 1; i >= 0; i--) {
            for (int j = text2WordCount - 1; j >= 0; j--) {
                if (text1Words[i].equals(text2Words[j])) {
                    solutionMatrix[i][j] = solutionMatrix[i + 1][j + 1] + 1;
                } else {
                    solutionMatrix[i][j] = Math.max(solutionMatrix[i + 1][j], solutionMatrix[i][j + 1]);
                }
            }
        }
        int i = 0, j = 0;
        ArrayList<String> lcsResultList = new ArrayList<String>();

        while (i < text1WordCount && j < text2WordCount) {
            if (text1Words[i].equals(text2Words[j])) {
                lcsResultList.add(text2Words[j]);
                i++;
                j++;
            } else if (solutionMatrix[i + 1][j] >= solutionMatrix[i][j + 1]) {
                i++;
            } else {
                j++;
            }
        }
        return lcsResultList;
    }

    private String normalizeText(String text) {

        text = text.trim();
        text = text.replace("\n", " ");
        text = text.replace("\t", " ");

        while (text.contains("  ")) {
            text = text.replace("  ", " ");
        }
        return text;
    }

    private String markTextDifferences(String text1, String text2,
                                       ArrayList<String> lcsList, String insertColor, String deleteColor) {

        StringBuffer stringBuffer = new StringBuffer();

        if (text1 != null && lcsList != null) {

            String[] text1Words = text1.split(" ");
            String[] text2Words = text2.split(" ");
            int i = 0, j = 0, word1LastIndex = 0, word2LastIndex = 0;

            for (int k = 0; k < lcsList.size(); k++) {
                for (i = word1LastIndex, j = word2LastIndex;
                     i < text1Words.length && j < text2Words.length; ) {
                    if (text1Words[i].equals(lcsList.get(k)) &&
                            text2Words[j].equals(lcsList.get(k))) {
                        stringBuffer.append("<SPAN>" + lcsList.get(k) + " </SPAN>");
                        word1LastIndex = i + 1;
                        word2LastIndex = j + 1;
                        i = text1Words.length;
                        j = text2Words.length;
                    } else if (!text1Words[i].equals(lcsList.get(k))) {
                        for (; i < text1Words.length &&
                                !text1Words[i].equals(lcsList.get(k)); i++) {
                            stringBuffer.append("<SPAN style='BACKGROUND-COLOR:" +
                                    deleteColor + "'>" + text1Words[i] + " </SPAN>");
                        }
                    } else if (!text2Words[j].equals(lcsList.get(k))) {
                        for (; j < text2Words.length &&
                                !text2Words[j].equals(lcsList.get(k)); j++) {
                            stringBuffer.append("<SPAN style='BACKGROUND-COLOR:" +
                                    insertColor + "'>" + text2Words[j] + " </SPAN>");
                        }
                    }
                }
            }
            for (; word1LastIndex < text1Words.length; word1LastIndex++) {
                stringBuffer.append("<SPAN style='BACKGROUND-COLOR:" +
                        deleteColor + "'>" + text1Words[word1LastIndex] + " </SPAN>");
            }
            for (; word2LastIndex < text2Words.length; word2LastIndex++) {
                stringBuffer.append("<SPAN style='BACKGROUND-COLOR:" +
                        insertColor + "'>" + text2Words[word2LastIndex] + " </SPAN>");
            }
        }
        return stringBuffer.toString();
    }

    public ArrayList<String> getLongestCommonSubsequenceList() {
        return longestCommonSubsequenceList;
    }
}
