// package col_106.LinkedLists;
import java.util.Stack;
// import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int datapara){
        this.data=datapara;
    }
}
public class InOrderWithoutRecursion {
    public static List<Integer> inorder(TreeNode root){
        Stack<TreeNode> st=new Stack<>();
        List<Integer> lst=new ArrayList<>();
        if(root==null){
            return lst;
        }
        st.push(root);
        while(!st.isEmpty()){

            while(st.peek().left!=null){
                st.push(st.peek().left);
            }

            while(!st.isEmpty() && st.peek().right==null){
                lst.add(st.pop().data);
            }

            if(!st.isEmpty()){
                lst.add(st.peek().data);
                st.push(st.pop().right);
            }
        }

        return lst;
    }
    public static void main(String[] args) {
        // Constructing a BST
        TreeNode root = new TreeNode(10);
root.right = new TreeNode(20);
root.right.left = new TreeNode(15);
root.right.right = new TreeNode(25);


        for(int item:inorder(root)){
            System.out.println(item);
        }
    }
}
