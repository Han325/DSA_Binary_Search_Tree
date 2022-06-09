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
        root = deleteNode(root, data);
    }

    public static TreeNode deleteNode(TreeNode currentRoot, int data) {
        // Check if root is empty, if empty return root node
        if (currentRoot == null) {
            System.out.println("Cannot find the TreeNode!");
            return null;
        }

        if (data > currentRoot.data) {
            currentRoot.right = deleteNode(currentRoot.right, data);
        } else if (data < currentRoot.data) {
            currentRoot.left = deleteNode(currentRoot.left, data);
        } else {
            if (currentRoot.left == null) {
                return currentRoot.right;
            } else if (currentRoot.right == null) {
                return currentRoot.left;
            }
            currentRoot.data = findMinValue(currentRoot.right);

            currentRoot.right = deleteNode(currentRoot.right, currentRoot.data);

        }


        return currentRoot;

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
    public static void inorder() {
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
    public static void postorder() {
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
//        while (!entryQuit) {
//            System.out.println("");
//            System.out.println("What functions of the BST do you wish to do?");
//            System.out.println("Common Operations:");
//            System.out.println("1. Insert");
//            System.out.println("2. Search");
//            System.out.println("3. Delete");
//            System.out.println(" ");
//            System.out.println("Transversal Operations");
//            System.out.println("4. Pre-order");
//            System.out.println("5. In-order");
//            System.out.println("6. Post-order");
//            System.out.println(" ");
//            System.out.println("Quit the program");
//            System.out.println("7. Quit");
//
//            // Collect user input
//            userInput = input.nextLine();
//
//            if (userInput.equals("1")) {
//                dataEntry("1");
//            } else if (userInput.equals("2")) {
//                dataEntry("2");
//            } else if (userInput.equals("3")) {
//                dataEntry("3");
//
//            } else if (userInput.equals("4")) {
//
//            } else if (userInput.equals("5")) {
//
//            } else if (userInput.equals("6")) {
//
//            } else if (userInput.equals("7")) {
//                entryQuit = true;
//
//            } else {
//                System.out.println("Please key in the correct menu option.");
//            }
//
//
//        }


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

            System.out.print("Please enter your choice:");
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

            } else if (userInput.equals("5")) {

            } else if (userInput.equals("6")) {

            } else if (userInput.equals("7")) {
                entryQuit = true;

            } else {
                System.out.println("Please key in the correct menu option.");
            }


        }
    }

}
