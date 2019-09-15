package HASH;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;

public class SeparateChainingHashTable {
    private static final int DEFAULT_TABLE_SIZE = 101;
    private List<Employee>[] theList;
    private int currentSize;

    public SeparateChainingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }
    public SeparateChainingHashTable(int size){
        theList = new LinkedList[size];
        for (List list : theList) {
            list = new LinkedList();
        }
    }

    public void makeEmpty(){
        for (List list : theList) {
            list.clear();
        }
        currentSize = 0;
    }

    public boolean contains(Employee x){
        List whichList = theList[myHash(x)];
        return whichList.contains(x);
    }

    public void insert(Employee x){
        List whichList = theList[myHash(x)];
        if (!whichList.contains(x)){
            whichList.add(x);
        }
        if (++currentSize > theList.length)
            reHash();
    }

    public void remove(Employee x){
        List<Employee> whichList = theList[myHash(x)];
        if (whichList.contains(x)){
            whichList.remove(x);
            currentSize--;
        }
    }

    private int myHash(Employee x){
        int hashVal = x.hashCode();
        hashVal %= theList.length;
        if (hashVal < 0){
            hashVal += theList.length;
        }
        return hashVal;
    }

    private void reHash(){
        List<Employee>[] oldList = theList;
        theList = new LinkedList[theList.length * 2];
        for (List<Employee> list : theList) {
            list = new LinkedList();
        }
        currentSize = 0;
        for (List<Employee> old : oldList) {
            for (Employee employee : old) {
                insert(employee);
            }
        }
    }
}
