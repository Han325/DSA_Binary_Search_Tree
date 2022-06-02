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

    // search functions
    // searchTree() function
    public void searchTree(int data) {
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
        } else if (data > prevRoot.data ) {
            System.out.println(data + " > " + prevRoot.data + ". Searching for right subtree.");
            searchNode(data, prevRoot.right);
        } else if (prevRoot == null) {
            System.out.println("Cannot find key " + data + " in this tree.");
        }

        return prevRoot;
    }

    // traversal functions
    // preorder


    // inorder
    // postorder


}
