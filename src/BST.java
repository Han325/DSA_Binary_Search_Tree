import com.sun.source.tree.Tree;

public class BST {

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    // root node of the BST
    TreeNode root;

    // Constructor for BST
    public BST(){
        root = null;
    }

    /**
     * BST insert function
     */
    public void insert(int data){
        root = insertNode(root, data);
    }

    /**
     * BST Insert Node function
     */
    public TreeNode insertNode(TreeNode prevRoot, int data){
        // Check if root is empty, if empty return root node
        if (prevRoot == null) {
            prevRoot = new TreeNode(data);
            return prevRoot;
        }

        if (data > prevRoot.data){
            prevRoot.right = insertNode(root.right, data);
        } else if (data < prevRoot.data){
            prevRoot.left = insertNode(root.left, data);
        }

        return root;

    }

    public void delete(int data){
        root = insertNode(root, data);
    }

    public TreeNode deleteNode(TreeNode prevRoot, int data){
        // Check if root is empty, if empty return root node
        if (prevRoot == null) {
            return prevRoot;
        }

        if (data > root.data){
            prevRoot.right = deleteNode(prevRoot.right, data);
        } else if (data < root.data){
            prevRoot.left = deleteNode(prevRoot.left, data);
        } else {
            if (prevRoot.left == null){
                return prevRoot.right;
            } else if (prevRoot.right == null){
                return prevRoot.left;
            }

            prevRoot.data = minValue(prevRoot.right);

            prevRoot.right = deleteNode(prevRoot.right, prevRoot.data);

        }


        return prevRoot;

    }

    private int minValue(TreeNode prevRoot){
        int minVal = prevRoot.data;
        while (prevRoot.left != null){
            minVal = prevRoot.left.data;
            prevRoot = prevRoot.left;
        }

        return minVal;
    }





}
