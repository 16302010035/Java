package SORT;

public class BucketSort {
    public static void main(String[] args) {
        int[] a = { 1, 5, 4, 2, 7, 8, 5, 15, 17, 12 };
        bucketSort(a);
        for (int var : a) {
            System.out.println(var);
        }
    }

    public static void bucketSort(int[] a) {
        int[] bucket = new int[20];
        for (int i = 0; i < 20; i++) {
            bucket[i] = 0;
        }
        for (int var : a) {
            bucket[var]++;
        }
        int index = 0;
        for (int i = 0; i < 20; i++) {
            while (bucket[i] > 0) {
                a[index++] = i;
                bucket[i]--;
            }
        }
    }
}