package SORT;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = { 1, 5, 4, 2, 7, 8, 5, 15, 17, 12 };
        bubbleSort(a);
        for (int var : a) {
            System.out.println(var);
        }
    }

    public static void bubbleSort(int[] a) {
        int length = a.length;
        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1])
                    swap(a, j, j + 1);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}