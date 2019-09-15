package HASH;

import java.util.Arrays;

public class QuadraticProbingHashTable<AnyType> {
    private int currentSize;
    private HashEntry<AnyType>[] array;
    private static final int DEFAULT_TABLE_SIZE = 11;

    public QuadraticProbingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int size){
        array = new HashEntry[size];
        makeEmpty();
    }

    public void insert(AnyType x){
        int position = findPos(x);
        if (isActive(position)){
            return;
        }
        array[position] = new HashEntry<>(x, true);
        currentSize++;
        if (currentSize > array.length / 2)
            rehash();
    }

    public void remove(AnyType x){
        int position = findPos(x);
        if (isActive(position)){
            currentSize--;
            array[position].isActive = false;
        }
    }

    private boolean isActive(int position){
        return array[position] != null && array[position].isActive;
    }

    private int myHash(AnyType x){
        int hashVal = x.hashCode();
        hashVal %= array.length;
        if (hashVal < 0){
            hashVal += array.length;
        }
        return hashVal;
    }

    private int findPos(AnyType x){
        int currentPos = myHash(x);
        int offset = 0;
        //错误的代码，导致offest加多了。
        while (array[currentPos] != null && !x.equals(array[currentPos])){
            offset++;
            offset *= offset;
            currentPos += offset;
            if (currentPos > array.length){
                currentPos -= array.length;
            }
        }
        return currentPos + offset;
    }


    private void makeEmpty(){
        Arrays.fill(array, null);
        currentSize = 0;
    }

    private void rehash(){
        HashEntry<AnyType>[] oldArray = array;
        array = new HashEntry[array.length * 2];
        currentSize = 0;
        for (HashEntry<AnyType> entry : oldArray) {
            if (entry != null && entry.isActive){
                insert(entry.element);
            }
        }
    }

}
