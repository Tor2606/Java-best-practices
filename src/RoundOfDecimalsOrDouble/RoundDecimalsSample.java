package RoundOfDecimalsOrDouble;

/**
 * Created by islabukhin on 30.09.16.
 */
public class RoundDecimalsSample {
    public static double roundToTwoPlacesV1(double d) {
        return Math.round(d * 100) / 100.0;
    }

    public static double roundToTwoPlacesV2(double d) {
        return ((long) (d < 0 ? d * 100 - 0.5 : d * 100 + 0.5)) / 100.0;
    }

    public static void main(String[] args) {
        double num = 1.*100000 + 5.*100000 - 9.*100000 + 3.*100000;
        System.out.println("Not round: " + num);
        System.out.println("Round 1: " + roundToTwoPlacesV1(num));
        System.out.println("Round 2: " + roundToTwoPlacesV2(num));
    }
}
