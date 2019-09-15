package SORT;

public class InsertSort {
    public static void main(String[] args) {
        int[] a = { 1, 6, 4, 23, 5, 7, 2 };
        insertSort(a);
    }

    public static void insertSort(int[] a) {
        int length = a.length;
        int j;
        for (int i = 1; i < length; i++) {
            int temp = a[i];
            for (j = i - 1; j >= 0; j--) {
                if (a[j] > temp)
                    a[j + 1] = a[j];
                else
                    break;
            }
            a[j + 1] = temp;
        }
        printArray(a);
    }

    private static void printArray(int[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            System.out.println(a[i]);
        }
    }
}
