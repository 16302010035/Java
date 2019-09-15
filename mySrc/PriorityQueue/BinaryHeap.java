package PriorityQueue;

public class BinaryHeap {
    private int currentSize;
    private int[] array;
    private static final int DEFAULT_CAPACITY = 10;

    BinaryHeap(int size){
        this.array = new int[size];
        this.currentSize = 0;
    }

    BinaryHeap(){
        this(DEFAULT_CAPACITY);
    }

    BinaryHeap(int[] items){
        currentSize = items.length;
        array = new int[currentSize * 2 + 1];
        for (int i = 1; i < currentSize + 1; i++){
            array[i] = items[i-1];
        }
        buildHeap();
    }

    public void insert(int x){
        if (currentSize > array.length - 1){
            enlargeArray(2*array.length + 1);
        }
        int hole = ++currentSize;
        for (array[0] = x; array[hole/2] < array[hole]; hole = hole / 2){
            array[hole] = array[hole/2];
        }
        array[hole] = x;
    }


    public int deleteMin() throws Exception {
        if (currentSize == 0) throw new Exception();
        int min = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return min;
    }

    private void percolateDown(int hole){
        int child;
        int temp = array[hole];
        while (hole * 2 <= currentSize){
            child = hole * 2;
            if (child < currentSize && array[child] > array[child+1])
                child++;
            if (temp > array[child])
                array[hole] = array[child];
            else break;
            hole = child;
        }
        array[hole] = temp;
    }

    private int findMin(){
        return array[1];
    }

    private void enlargeArray(int newSize){
        int[] oldArray = array;
        array = new int[newSize];
        for (int i = 0; i < currentSize + 1; i++){
            array[i] = oldArray[i];
        }
    }

    private void buildHeap(){
        for (int i = currentSize / 2; i > 0; i--){
            percolateDown(i);
        }
    }
}
