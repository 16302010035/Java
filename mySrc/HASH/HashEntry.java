package HASH;

public class HashEntry<AnyType> {
    AnyType element;
    boolean isActive;

    public HashEntry(AnyType element){
        this(element, true);
    }

    public HashEntry(AnyType element, boolean isActive){
        this.element = element;
        this.isActive = isActive;
    }

}
