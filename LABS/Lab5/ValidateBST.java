import java.util.List;
import java.util.ArrayList;
public class ValidateBST {
    public void inorderTraversal(TreeNode root,List<Integer> lst){
        if(root==null){
            return;
        }
        inorderTraversal(root.left,lst);
        lst.add(root.val);
        inorderTraversal(root.right,lst);
        return;
    }
    public boolean isValidBST1(TreeNode root){
        List<Integer> inorderlst=new ArrayList<>();
        inorderTraversal(root,inorderlst);
        for(int i=0,j=1;i<inorderlst.size()-1 && j<inorderlst.size();i++,j++){
            if(inorderlst.get(i)>=inorderlst.get(j)){return false;}
        }
        return true;
    }
    public boolean isValidBST2(TreeNode root,int left, int right){
        if(root==null){return true;}
        if(left>=root.val || right<=root.val ){return false;}

        return(isValidBST2(root.left,left,root.val) && isValidBST2(root.right,root.val,right));
    }
    public static void main(String[] args) {
        ValidateBST obj = new ValidateBST();

        // Test Case 1: [2, 1, 3] - Expected output: true
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("Test Case 1: " + obj.isValidBST(root1));  // Output: true

        // Test Case 2: [5, 1, 4, null, null, 3, 6] - Expected output: false
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Test Case 2: " + obj.isValidBST(root2));  // Output: false

        // Test Case 3: [1, null, 2, null, 3] - Expected output: true
        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(2);
        root3.right.right = new TreeNode(3);
        System.out.println("Test Case 3: " + obj.isValidBST(root3));  // Output: true

        // Test Case 4: [10, 5, 15, null, null, 6, 20] - Expected output: false
        TreeNode root4 = new TreeNode(10);
        root4.left = new TreeNode(5);
        root4.right = new TreeNode(15);
        root4.right.left = new TreeNode(6);
        root4.right.right = new TreeNode(20);
        System.out.println("Test Case 4: " + obj.isValidBST(root4));  // Output: false

        // Test Case 5: [] (Empty Tree) - Expected output: true
        TreeNode root5 = null;
        System.out.println("Test Case 5: " + obj.isValidBST(root5));  // Output: true
    }
}
