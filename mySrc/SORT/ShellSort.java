package SORT;

public class ShellSort {
    public static void main(String[] args) {
        int[] a = {1,6,4,23,5,7,2};
        shellSort(a);
    }


    public static void shellSort(int[] a){
        int length = a.length;
        int j;
        for (int gap = length / 2; gap > 0; gap = gap / 2){
            for (int i = gap; i < length; i++){
                int temp = a[i];
                for (j = i; j >= gap; j -= gap){
                    if (a[j-gap] > temp) a[j] = a[j-gap];
                    else break;
                }
                a[j] = temp;
            }
        }
        printArray(a);
    }
    public static void printArray(int[] a){
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

}
