import java.util.List;
import java.util.ArrayList;
public class KthSmallestElementBST {
    public void inorderTraversal(TreeNode root,List<Integer> lst){
        if(root==null){
            return;
        }
        inorderTraversal(root.left,lst);
        lst.add(root.val);
        inorderTraversal(root.right,lst);
        return;
    }
    public int kthSmallestElement(TreeNode root, int k){
        List<Integer> lst=new ArrayList<>();
        inorderTraversal(root,lst);
        return lst.get(k-1);
    }
}
