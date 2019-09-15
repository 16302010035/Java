package SORT;

import java.util.ArrayList;

import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        // List<Integer> items = new ArrayList<>();
        // items.add(3);
        // items.add(1);
        // items.add(2);
        // items.add(8);
        // items.add(4);
        // items.add(7);
        // items.add(5);
        // quickSort(items);
        // for (Integer item : items) {
        // System.out.println(item);
        // }
        int[] a = { 1, 4, 3, 2, 65, 7, 65, 4, 3, 5, 6, 8, 9, 0, 4, 7, 54, 34, 87, 23, 67, 987 };
        sort(a);
        for (int var : a) {
            System.out.println(var);
        }
    }

    public static void quickSort(List<Integer> items) {
        if (items.size() > 1) {
            List<Integer> smaller = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();

            Integer chosenItem = items.get(items.size() / 2);

            for (Integer item : items) {
                if (item < chosenItem)
                    smaller.add(item);
                else if (item > chosenItem)
                    larger.add(item);
                else
                    same.add(item);
            }

            quickSort(smaller);
            quickSort(larger);

            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
        }

    }

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int left, int right) {
        if (right - left > 10) {
            int pivot = median3(a, left, right);
            int i = left;
            int j = right - 1;
            while (true) {
                while (a[++i] < pivot) {
                }

                while (a[--j] > pivot) {
                }
                if (i < j) {
                    swap(a, i, j);
                } else
                    break;
            }

            swap(a, i, right - 1);

            sort(a, left, i - 1);
            sort(a, i + 1, right);
        } else {
            insertSort(a);
        }
    }

    private static void insertSort(int[] a) {
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
    }

    private static int median3(int[] a, int left, int right) {
        int center = (left + right) / 2;
        if (a[left] > a[center]) {
            swap(a, left, center);
        }
        if (a[left] > a[right]) {
            swap(a, left, right);
        }

        if (a[center] > a[right]) {
            swap(a, center, right);
        }

        swap(a, center, right - 1);
        return a[right - 1];
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
