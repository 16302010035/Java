package SORT;

public class SelectSort {
    public static void main(String[] args) {
        int[] a = {1,6,4,23,5,7,2};
        selectSort(a);
    }

    public static void selectSort(int[] a){
        int length = a.length;
        int min, minIndex;
        for (int i = 0; i < length; i++){
            min = a[i];
            minIndex = i;
            for (int j = i; j < length; j++){
                if (a[j] < min){
                    min = a[j];
                    minIndex = j;
                }
            }
            swap(a,i,minIndex);
        }
        printArray(a);
    }

    private static void swap(int[] a,int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void printArray(int[] a){
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
}
