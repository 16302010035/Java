package BST;

public class BinarySearchTree {
    private BinaryNode root;

    BinarySearchTree(){
        this.root = null;
    }

    public void makeEmpty(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public boolean contains(int item){
        return contains(item, root);
    }

    private boolean contains(int item, BinaryNode root){
        if (root == null) return false;
        int compare = item - root.element;
        if (compare > 0) return contains(item, root.right);
        else if (compare < 0) return contains(item, root.left);
        else return true;
    }

    public int findMin(){
        return findMin(root).element;
    }

    private BinaryNode findMin(BinaryNode root){
        if (root.left == null) return root;
        else return findMin(root.left);
    }

    public int findMax(){
        return findMax(root).element;
    }

    private BinaryNode findMax(BinaryNode root){
        while (root.right != null){
            root = root.right;
        }

        return root;
    }

    public void insert(int element){
        root = insert(element, root);
    }

    private BinaryNode insert(int element, BinaryNode root){
        if (root == null) return new BinaryNode(element);

        int compare = element - root.element;
        if (compare > 0){
            root.right = insert(element, root.right);
        }else if (compare < 0){
            root.left = insert(element, root.left);
        }else{ }
        return root;
    }

    public void remove(int element){
        root = remove(element, root);
    }

    private BinaryNode remove(int element, BinaryNode root){
        if (root == null) return null;

        int compare = element - root.element;
        if (compare > 0){
            root = remove(element, root.right);
        }else if (compare < 0){
            root = remove(element, root.left);
        }else {
            if (root.left == null && root.right == null){
                return null;
            }else {
                if (root.left != null && root.right != null){
                    root.element = findMax(root.left).element;
                    root.left = remove(root.element, root.left);
                }else {
                    root = (root.left == null)? root.right : root.left;
                }
            }
        }
        return root;
    }
}
