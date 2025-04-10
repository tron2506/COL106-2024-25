import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.ArrayList;
public class RightSideView {
    public List<Integer> rightView(TreeNode root){
        if (root == null) return new ArrayList<>();
        List<Integer> lst=new ArrayList<>();

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int lvlsize=q.size();
            TreeNode lastnode=null;
            for(int i=0;i<lvlsize;i++){
                lastnode=q.poll();
                if(lastnode.left!=null){q.add(lastnode.left);}
                if(lastnode.right!=null){q.add(lastnode.right);}
            }
            lst.add(lastnode.val);
        }
        return lst;
    }
    public static void main(String args[]){
        RightSideView obj = new RightSideView();

        // Test Case 1: [1, 2, 3, null, 5, null, 4]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(4);
        System.out.println("Test Case 1: " + obj.rightView(root1));  // Output: [1, 3, 4]

        // Test Case 2: [1]
        TreeNode root2 = new TreeNode(1);
        System.out.println("Test Case 2: " + obj.rightView(root2));  // Output: [1]

        // Test Case 3: []
        TreeNode root3 = null;
        System.out.println("Test Case 3: " + obj.rightView(root3));  // Output: []

        // Test Case 4: [1, 2, 3, 4, null, null, 5]
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.left.left = new TreeNode(4);
        root4.right.right = new TreeNode(5);
        System.out.println("Test Case 4: " + obj.rightView(root4));
    }
}
