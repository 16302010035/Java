package SORT;

import java.util.ArrayList;

public class RadixSort {
    public static void main(String[] args) {
        String[] array = {"abcdefa", "adcdeeb", "adcaefc", "aaaaaad", "bbbbbbe"};
        countingRadixSort(array, 7);
        for (String s : array) {
            System.out.println(s);
        }
    }

    public static void radixSortA(String[] array, int stringLen){
        final int size = 256;
        ArrayList<String>[] buckets = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int pos = stringLen - 1; pos >= 0; pos--){
            for (String s : array) {
                buckets[s.charAt(pos)].add(s);
            }

            int index = 0;
            for (ArrayList<String> bucket : buckets) {
                for (String s : bucket) {
                    array[index++] = s;
                }

                bucket.clear();
            }
        }

    }

    public static void countingRadixSort(String[] arr, int stringLen){
        final int BUCKETS = 256;
        int stringNums = arr.length;

        String[] in = arr;
        String[] out = new String[stringNums];
        for (int pos = stringLen - 1; pos >= 0; pos--){
            int[] count = new int[BUCKETS];
            for (String s : in) {
                count[s.charAt(pos) + 1]++;
            }

            for (int i = 1; i < BUCKETS; i++){
                count[i] = count[i-1] + count[i];
            }
            for (String s: in) {
                out[count[s.charAt(pos)]++] = s;
            }
            String[] temp = in;
            in = out;
            out = temp;
        }
        if (stringLen % 2 == 1){
            for (int i = 0; i < stringNums; i++) {
                out[i] = in[i];
            }
        }
    }
}