import java.util.Scanner;

public class BST {

    // Node structure
    public static class TreeNode {
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
    public static TreeNode root;

    // Constructor for BST
    public BST() {
        root = null;
    }

    // Insert function
    public static void insert(int data) {
        System.out.println("Processing..... Logs down below: ");
        root = insertNode(root, data);
    }

    //BST Insert Node helper function
    public static TreeNode insertNode(TreeNode prevRoot, int data) {
        // Check if root is empty, if empty return root node
        if (prevRoot == null) {
            System.out.println("There is no existing root. " + "Setting " + data + " as root TreeNode.");
            prevRoot = new TreeNode(data);
            return prevRoot;
        }

        if (data > prevRoot.data) {
            if (prevRoot.right == null){
                System.out.println("Right child of TreeNode " + prevRoot.data + " is null. Setting " + data + " there." );
                prevRoot.right = new TreeNode(data);
            } else {
                System.out.println("Right child of TreeNode " + prevRoot.data + " is not null. Recurring down the tree...");
                insertNode(prevRoot.right, data);
            }

        } else if (data < prevRoot.data) {
            if (prevRoot.left == null){
                System.out.println("Left child of TreeNode " + prevRoot.data + " is null. Setting " + data + " there." );
                prevRoot.left = new TreeNode(data);
            } else {
                System.out.println("Left child of TreeNode " + prevRoot.data + " is not null. Recurring down the tree...");
                insertNode(prevRoot.left, data);
            }
        }

        return root;

    }


    // Search function
    public static void search(int data) {
        if (root == null) {
            System.out.println("There is no tree!");
        } else {
            System.out.println("Searching for key " + data + ".");
            root = searchNode(data, root);
        }
    }

    // searchNode() function
    public static TreeNode searchNode(int data, TreeNode prevRoot) {

        if (prevRoot == null) {
            System.out.println("Cannot find key " + data + " in this tree.");
        } else if (data == prevRoot.data) {
            System.out.println("Found key " + data + ".");
        } else if (data < prevRoot.data) {
            System.out.println(data + " < " + prevRoot.data + ". Searching for left subtree.");
            searchNode(data, prevRoot.left);
        } else if (data > prevRoot.data) {
            System.out.println(data + " > " + prevRoot.data + ". Searching for right subtree.");
            searchNode(data, prevRoot.right);
        }
        return prevRoot;
    }

    // Delete function
    public static void delete(int data) {
        System.out.println("Processing..... Logs down below: ");
        root = deleteNode(root, data);
    }

    public static TreeNode deleteNode(TreeNode prevRoot, int data) {
        // Check if root is empty, if empty return root node
        if (prevRoot == null) {
            System.out.println("Failed to find the TreeNode specified.");
            return null;
        }

        if (data > prevRoot.data) {
            System.out.println("Scanning node.... Current node is " + prevRoot.data);
            System.out.println(data + ">" + prevRoot.data + " Recurring down the tree.");
            prevRoot.right = deleteNode(prevRoot.right, data);
        } else if (data < prevRoot.data) {
            System.out.println("Scanning node.... Current node is " + prevRoot.data);
            System.out.println(data + "<" + prevRoot.data + " Recurring down the tree.");
            prevRoot.left = deleteNode(prevRoot.left, data);
        } else {
            System.out.println("Scanning node.... Current node is " + prevRoot.data);
            if (prevRoot.left == null && prevRoot.right == null){
                System.out.println(prevRoot.data + " is found to be a leaf node. Immediate deletion.");
                prevRoot = null;
                return prevRoot;
            }  else if (prevRoot.left == null) {
                System.out.println(prevRoot.data + " is a node with a right child.");
                System.out.println("Swapping " + data + " with its right child: " + prevRoot.right.data);
                return prevRoot.right;
            } else if (prevRoot.right == null) {
                System.out.println(prevRoot.data + " is a node with a left child.");
                System.out.println("Swapping " + data + " with its left child: " + prevRoot.left.data);
                return prevRoot.left;
            }

            System.out.println(prevRoot.data + " is a node with two children.");
            System.out.println("Finding its in-order successor to replace its position.");
            prevRoot.data = findMinValue(prevRoot.right);

            prevRoot.right = deleteNode(prevRoot.right, prevRoot.data);

        }

        return prevRoot;

    }

    // helper function to find the inorder successor of the tree
    public static int findMinValue(TreeNode prevRoot) {
        int minVal = prevRoot.data;
        while (prevRoot.left != null) {
            minVal = prevRoot.left.data;
            prevRoot = prevRoot.left;
        }

        return minVal;
    }

    // Traversal Functions
    // Preorder Traversal
    public static void preorder() {
        System.out.print("Preorder Traversal: ");
        preorderHelper(root);
        System.out.println(" ");
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
    public static void inorder() {
        System.out.print("Inorder Traversal: ");
        inorderHelper(root);
        System.out.println(" ");
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
    public static void postorder() {
        System.out.print("Postorder Traversal: ");
        postorderHelper(root);
        System.out.println(" ");
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

    public static boolean entryQuit = false;
    public static boolean dataEntryQuit = false;

    public static Scanner input = new Scanner(System.in);

    public static void dataEntry(String selectedOptions) {
        int convertDataInput = 0;

        while (!dataEntryQuit) {
            System.out.println(" ");
            System.out.println("Please key in the data. (type \"exit\" to quit the function.)");
            System.out.print("data: ");



            // collect input, throw error if not integer
            try {
                String dataInput = input.nextLine();
                if (dataInput.equals("exit")){
                    dataEntryQuit = true;
                    startProgram();
                }
                convertDataInput = Integer.parseInt(dataInput);


            } catch (Exception e) {
                System.out.println("Please enter an integer.");
                break;
            }



            if (selectedOptions.equals("1")) {
                insert(convertDataInput);
            } else if (selectedOptions.equals("2")) {
                search(convertDataInput);
            } else if (selectedOptions.equals("3")) {
                delete(convertDataInput);
            }
        }

    }


    public static void main(String[] args) {


        System.out.println("Welcome to Binary Search Tree Visualisation");
        startProgram();
    }

    public static void startProgram(){
        dataEntryQuit = false;
        String userInput = "";
        while (!entryQuit) {
            System.out.println("");
            System.out.println("What functions of the BST do you wish to do?");
            System.out.println("Common Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println(" ");
            System.out.println("Transversal Operations");
            System.out.println("4. Pre-order");
            System.out.println("5. In-order");
            System.out.println("6. Post-order");
            System.out.println(" ");
            System.out.println("Quit the program");
            System.out.println("7. Quit");

            System.out.print("Please enter your choice: ");
            // Collect user input
            userInput = input.nextLine();

            if (userInput.equals("1")) {
                System.out.println("You have selected the insert function.");
                dataEntry("1");
            } else if (userInput.equals("2")) {
                System.out.println("You have selected the search function.");
                dataEntry("2");
            } else if (userInput.equals("3")) {
                System.out.println("You have selected the delete function.");
                dataEntry("3");
            } else if (userInput.equals("4")) {
                System.out.println("You have selected the pre-order transversal function.");
                preorder();
            } else if (userInput.equals("5")) {
                System.out.println("You have selected the in-order transversal function.");
                inorder();
            } else if (userInput.equals("6")) {
                System.out.println("You have selected the end-order transversal function.");
                postorder();
            } else if (userInput.equals("7")) {
                System.out.println("Thanks for using the program, wish to see you again.");
                entryQuit = true;
                break;
            } else {
                System.out.println("Please key in the correct menu option.");
            }


        }
    }

}
