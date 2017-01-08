package Sorting.DualPivotSorting;

public class DualPivotSortingSample {
    public static void main(String[] args) {
        int[] array = new int[]{1,5,32,56,323,1,234,123424,333,6756756,2,2,2};
        sort(array);
        for (int el: array) {
            System.out.print(el + " ");
        }
    }

    public static void sort(int[] input) {
        sort(input, 0, input.length - 1);
    }

    private static void sort(int[] input, int lowIndex, int highIndex) {
        if (highIndex <= lowIndex) return;

        int pivot1 = input[lowIndex];
        int pivot2 = input[highIndex];

        if (pivot1 > pivot2) {
            swap(input, lowIndex, highIndex);
            pivot1 = input[lowIndex];
            pivot2 = input[highIndex];
            //sort(input, lowIndex, highIndex);
        } else if (pivot1 == pivot2) {
            while ((pivot1 == pivot2 && lowIndex < highIndex)) {
                lowIndex++;
                pivot1 = input[lowIndex];
            }
        }

        int i = lowIndex + 1;
        int lt = lowIndex + 1;
        int gt = highIndex - 1;

        while (i <= gt) {
            if (less(input[i], pivot1)) {
                swap(input, i++, lt++);
            } else if (less(pivot2, input[i])) {
                swap(input, i, gt--);
            } else {
                i++;
            }
        }
        swap(input, lowIndex, --lt);
        swap(input, highIndex, ++gt);

        sort(input, lowIndex, lt - 1);
        sort(input, lt + 1, gt - 1);
        sort(input, gt + 1, highIndex);
    }

    private static boolean less(int a, int b) {
        return a < b;
    }

    private static void swap(int[] input, int lowIndex, int highIndex) {
        int tmp = input[lowIndex];
        input[lowIndex] = input[highIndex];
        input[highIndex] = tmp;
    }
}
