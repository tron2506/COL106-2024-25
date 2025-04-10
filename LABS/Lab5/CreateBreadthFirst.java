import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(){}
    public TreeNode(int value){this.val=value;}
    public TreeNode(int value, TreeNode lef, TreeNode rig){this.val=value;this.left=lef;this.right=rig;}
}
class breadthFirst{
    public void breadth(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            System.out.println("Tree is empty");
            return;
        }
        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            System.out.print(curr.val+" ");

            if(curr.left!=null){q.add(curr.left);}
            if(curr.right!=null){q.add(curr.right);}

        }
    }
}
public class CreateBreadthFirst{
    public static void main(String args[]){
        // Creating a sample binary tree:
        //          1
        //         / \
        //        2   3
        //       / \    \
        //      4   5    6

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Create an instance of breadthFirst and call the breadth method
        breadthFirst bf = new breadthFirst();
        System.out.println("Breadth-First Traversal (Level Order):");
        bf.breadth(root);

        // Test case 2: Single node tree
        TreeNode singleNode = new TreeNode(10);
        System.out.println("\n\nBreadth-First Traversal (Single Node):");
        bf.breadth(singleNode);

        // Test case 3: Empty tree
        System.out.println("\n\nBreadth-First Traversal (Empty Tree):");
        bf.breadth(null);
    }
}