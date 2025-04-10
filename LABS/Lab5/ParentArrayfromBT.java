import java.util.*;
import java.util.LinkedList;
public class ParentArrayfromBT {
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

    public int countNodes(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){return 0;}
        int count=0;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.peek();
            if(curr.left!=null){q.add(curr.left);}
            if(curr.right!=null){q.add(curr.right);}
            q.poll();
            count++;
        }
        return count;
    }
    public int[] makeParentArray(TreeNode root){
        if(root==null){return new int[0];}
        int[] parents=new int[countNodes(root)];
        Queue<TreeNode> q=new LinkedList<>();
        parents[0]=-1;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.peek();
            if(curr.left!=null){parents[curr.left.val]=curr.val;  q.add(curr.left);}
            if(curr.right!=null){parents[curr.right.val]=curr.val;  q.add(curr.right);}
            q.poll();
        }
        return parents;
    }
    public static void main(String args[]){
        ParentArrayfromBT ugh=new ParentArrayfromBT();
        int[] parents={-1,0,0,2,2,3,3,4,4,1};
        int[] array=ugh.makeParentArray(ugh.constructBT(parents));
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}
