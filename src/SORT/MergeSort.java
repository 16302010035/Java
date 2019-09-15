package SORT;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = { 1, 4, 3, 2, 65, 7, 65, 4, 3, 5, 6, 8, 9, 0, 4, 7, 54, 34, 87, 23, 67, 987 };
        mergeSort(a);
        for (int var : a) {
            System.out.println(var);
        }
    }

    public static void mergeSort(int[] a) {
        int[] tempArray = new int[a.length];
        mergeSort(a, tempArray, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int[] tempArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tempArray, left, center);
            mergeSort(a, tempArray, center + 1, right);

            merge(a, tempArray, left, center, right);
        }
    }

    private static void merge(int[] a, int[] tempArray, int left, int leftEnd, int right) {
        int i = left;
        int k = i;
        int j = leftEnd + 1;
        int num = right - left + 1;
        while (i <= leftEnd && j <= right) {
            if (a[i] < a[j]) {
                tempArray[k++] = a[i++];
            } else {
                tempArray[k++] = a[j++];
            }
        }

        while (i <= leftEnd) {
            tempArray[k++] = a[i++];
        }
        while (j <= right) {
            tempArray[k++] = a[j++];
        }
        for (int n = 0; n < num; n++, right--) {
            a[right] = tempArray[right];
        }
    }
}