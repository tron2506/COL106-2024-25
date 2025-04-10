import java.util.*;
import java.util.LinkedList;
public class ParentArrayBT{
    public TreeNode constructBT(int[] parents){
        int n=parents.length;
        // if(n==0){
        //     return null;
        // }
        TreeNode[] nodes=new TreeNode[n];
        TreeNode root=null;
        for(int i=0;i<n;i++){
            nodes[i]=new TreeNode(i);
        }
        for(int i=0;i<n;i++){
            if(parents[i]==-1){
                root=nodes[i];
            }
            else{
                TreeNode parent=nodes[parents[i]];
                if(parent.left==null){parent.left=nodes[i];}
                else{parent.right=nodes[i];}
            }
        }
        return root;
    }
    public void levelTraversal(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            System.out.print(q.peek().val+" ");
            if(q.peek().left!=null){q.add(q.peek().left);}
            if(q.peek().right!=null){q.add(q.peek().right);}
            q.poll();
        }
    }
    public static void main(String args[]){
        int[] parents={-1,0,0,2,2,3,3,4,4,1};
        ParentArrayBT ugh=new ParentArrayBT();
        ugh.levelTraversal(ugh.constructBT(parents));
    }
}