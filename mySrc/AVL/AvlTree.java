package AVL;

public class AvlTree {
    private AvlNode root;
    private int ALLOWED_IMBALANCE = 1;

    AvlTree(){
        this.root = null;
    }

    private int height(AvlNode t){
        return t == null ? -1:t.height;
    }

    private AvlNode rotateWithLeftChild(AvlNode k2){
        AvlNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private AvlNode rotateWithRightChild(AvlNode k2){
        AvlNode k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private AvlNode DoubleWithLeftChild(AvlNode k3){
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithRightChild(k3);
    }

    private AvlNode DoubleWithRightChild(AvlNode k3){
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }

    private AvlNode balance(AvlNode t){
        if (t == null) return t;
        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE){
            if (height(t.left.left) >= height(t.left.right))
                t = rotateWithLeftChild(t);
            else t = DoubleWithLeftChild(t);
        }else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE){
            if (height(t.right.left) >= height(t.right.right))
                t = rotateWithRightChild(t);
            else t = DoubleWithRightChild(t);
        }

        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    public void insert(int element){
        root = insert(element, root);
    }

    private AvlNode insert(int element, AvlNode t){
        if (t == null) return new AvlNode(element);

        int compare = element - t.element;
        if (compare > 0){
            t.right = insert(element, t.right);
        }else if (compare < 0){
            t.left = insert(element, t.left);
        }else {}

        return balance(t);
    }

    public void remove(int element){
        root = remove(element, root);
    }

    private AvlNode remove(int element, AvlNode t){
        if (t == null) return t;
        int compare = element - t.element;
        if (compare > 0){
            t.right = remove(element, t.right);
        }else if (compare < 0){
            t.left = remove(element, t.left);
        }else {
            if (t.left != null && t.right != null){
                t.element = findMin(t.right).element;
                t.right = remove(t.element, t.right);
            }else
                t = t.right == null? t.left:t.right;
        }
        return balance(t);
    }

    private AvlNode findMin(AvlNode root){
        return root;
    }
}
