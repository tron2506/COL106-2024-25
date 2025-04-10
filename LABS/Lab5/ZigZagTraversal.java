import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class ZigZagTraversal {
    public List<List<Integer>> zigzag(TreeNode root){
        // Queue<TreeNode> q=new LinkedList<>();
        if (root == null) return new ArrayList<>();
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        s1.add(root);
        List<List<Integer>> lst=new ArrayList<>();
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty()){
                List<Integer> temp=new ArrayList<>();
                while(!s1.isEmpty()){
                    // System.out.print(s1.peek().val+" ");
                    temp.add(s1.peek().val);
                    if(s1.peek().left!=null){s2.push(s1.peek().left);}
                    if(s1.peek().right!=null){s2.push(s1.peek().right);}
                    s1.pop();
                }
                lst.add(temp);
            }
            if(!s2.isEmpty()){
                List<Integer> temp=new ArrayList<>();
                while(!s2.isEmpty()){
                    // System.out.print(s2.peek().val+" ");
                    temp.add(s2.peek().val);
                    if(s2.peek().right!=null){s1.push(s2.peek().right);}
                    if(s2.peek().left!=null){s1.push(s2.peek().left);}
                    s2.pop();
                }
                lst.add(temp);
            }
        }

        return lst;
        // while(!q.isEmpty() || !s.isEmpty()){
        //     if(!q.isEmpty()){
        //         curr=q.poll();
        //     }
        // }

    }
}
