import com.sun.source.tree.Tree;

public class BST {

    // Node structure
    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // root node of the BST
    TreeNode root;

    // Constructor for BST
    public BST() {
        root = null;
    }

    // Insert function
    public void insert(int data) {
        root = insertNode(root, data);
    }

    //BST Insert Node helper function
    public TreeNode insertNode(TreeNode prevRoot, int data) {
        // Check if root is empty, if empty return root node
        if (prevRoot == null) {
            prevRoot = new TreeNode(data);
            return prevRoot;
        }

        if (data > prevRoot.data) {
            prevRoot.right = insertNode(root.right, data);
        } else if (data < prevRoot.data) {
            prevRoot.left = insertNode(root.left, data);
        }

        return root;

    }


    // Search function
    public void search(int data) {
        if (root == null) {
            System.out.println("There is no tree!");
        } else {
            System.out.println("Searching for key " + data + ".");
            root = searchNode(data, root);
        }
    }

    // searchNode() function
    public TreeNode searchNode(int data, TreeNode prevRoot) {
        if (data == prevRoot.data) {
            System.out.println("Found key " + data + ".");
        } else if (data < prevRoot.data) {
            System.out.println(data + " < " + prevRoot.data + ". Searching for left subtree.");
            searchNode(data, prevRoot.left);
        } else if (data > prevRoot.data) {
            System.out.println(data + " > " + prevRoot.data + ". Searching for right subtree.");
            searchNode(data, prevRoot.right);
        } else if (prevRoot == null) {
            System.out.println("Cannot find key " + data + " in this tree.");
        }

        return prevRoot;
    }

    // Delete function
    public void delete(int data) {
        root = insertNode(root, data);
    }

    public TreeNode deleteNode(TreeNode prevRoot, int data) {
        // Check if root is empty, if empty return root node
        if (prevRoot == null) {
            return prevRoot;
        }

        if (data > root.data) {
            prevRoot.right = deleteNode(prevRoot.right, data);
        } else if (data < root.data) {
            prevRoot.left = deleteNode(prevRoot.left, data);
        } else {
            if (prevRoot.left == null) {
                return prevRoot.right;
            } else if (prevRoot.right == null) {
                return prevRoot.left;
            }

            prevRoot.data = minValue(prevRoot.right);

            prevRoot.right = deleteNode(prevRoot.right, prevRoot.data);

        }


        return prevRoot;

    }

    // helper function to find the inorder successor of the tree
    private int minValue(TreeNode prevRoot) {
        int minVal = prevRoot.data;
        while (prevRoot.left != null) {
            minVal = prevRoot.left.data;
            prevRoot = prevRoot.left;
        }

        return minVal;
    }

    // Traversal Functions
    // Preorder Traversal
    public void preorder() {
        System.out.println("Preorder Traversal:\n");
        preorderHelper(root);
    }
    // recursive helper function (preorder)
    public static void preorderHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preorderHelper(node.left);
        preorderHelper(node.right);
    }

    // Inorder Traversal
    public void inorder() {
        System.out.println("Inorder Traversal:\n");
        inorderHelper(root);
    }
    // recursive helper function (inorder)
    public static void inorderHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderHelper(node.left);
        System.out.print(node.data + " ");
        inorderHelper(node.right);
    }

    // Postorder Traversal
    public void postorder() {
        System.out.println("Postorder Traversal:\n");
        postorderHelper(root);
    }
    // recursive helper function (postorder)
    public static void postorderHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        postorderHelper(node.left);
        postorderHelper(node.right);
        System.out.print(node.data + " ");
    }

}
