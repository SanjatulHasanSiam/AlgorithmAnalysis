/**
 * Author : Sanjatul Hasan Siam
 *
 *  A Java program to construct all the unique BSTs for a set of input keys.
 */
import java.util.ArrayList;
import java.util.Scanner;
//  node structure
class Node
{
    int key;
    Node left;
    Node right;

    public Node(int key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}
public class BST {

    //  function for constructing trees
    static ArrayList<Node> constructTrees(ArrayList<Integer>keys, int start, int end)
    {
        ArrayList<Node> tree = new ArrayList<>();
        /*  if start > end   then subtree will be empty so returning NULL
            in the tree */
        if (start > end)
        {
            tree.add(null);
            return tree;
        }

        /*  iterating through all values from start to end  for constructing\
            left and right subtree recursively  */
        for (int i = start; i <= end; i++)
        {
            /*  constructing left subtree   */
            ArrayList<Node> leftSubtree  = constructTrees(keys,start, i - 1);

            /*  constructing right subtree  */
            ArrayList<Node> rightSubtree = constructTrees(keys,i + 1, end);

            /*  now looping through all left and right subtrees and connecting
                them to ith root  below  */
            for (Node right : rightSubtree) {
                for (Node left: leftSubtree) {
                    Node root=new Node(keys.get(i),left,right);
                    tree.add(root);
                }
            }
        }
        return tree;
    }

    // A utility function to do preorder traversal of BST
    static void preorder(Node root)
    {
        if (root != null)
        {
            System.out.print(root.key+" ") ;
            preorder(root.left);
            preorder(root.right);
        }
    }
    // A utility function to do inorder traversal of BST
    static void inorder(Node root)
    {
        if (root != null)
        {

            inorder(root.left);
            System.out.print(root.key+" ") ;
            inorder(root.right);
        }
    }
    static void postorder(Node root)
    {
        if (root != null)
        {

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key+" ") ;
        }
    }


    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("\nEnter  the number of keys : \n");
        int num=scanner.nextInt();
        System.out.println("\n Enter the values : \n");
        ArrayList<Integer> keys = new ArrayList<>();
        for (int i=0;i<num;i++){
            int tmp=scanner.nextInt();
            keys.add(tmp);
        }
        ArrayList<Node> trees = constructTrees(keys, 0, num - 1);

        System.out.println("Number of BST: "+trees.size());

        int no=1;

        for (Node tree : trees) {
            System.out.println("BST NUMBER : "+ no++);
            System.out.print("\tPreOrder: ");
            preorder(tree);
            System.out.println();
            System.out.print("\tInOrder : ");
            inorder(tree);
            System.out.println();
            System.out.print("\tPostOder : ");
            postorder(tree);
            System.out.println();

        }

    }
}


