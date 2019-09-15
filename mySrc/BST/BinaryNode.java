package BST;

public class BinaryNode {
    int element;
    BinaryNode left, right;
    BinaryNode(int element){
        this(element, null, null);
    }

    BinaryNode(int element, BinaryNode left, BinaryNode right){
        this.element = element;
        this.left = left;
        this.right = right;
    }
}
