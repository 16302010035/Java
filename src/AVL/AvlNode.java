package AVL;


public class AvlNode {
    int element;
    AvlNode left, right;
    int height;

    AvlNode(int element){
        this(element, null, null);
    }

    AvlNode(int element, AvlNode left, AvlNode right){
        this.element = element;
        this.left = left;
        this.right = right;
        this.height = 0;
    }
}
