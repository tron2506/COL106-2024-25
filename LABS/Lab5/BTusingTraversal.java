// package col_106.LABS.Lab5;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(){}
    public TreeNode(int value){this.val=value;}
    public TreeNode(int value, TreeNode lef, TreeNode rig){this.val=value;this.left=lef;this.right=rig;}
}
class Solution {

    public static void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }
    }
    public int[] sliceArray(int start, int end, int[] array){
        // Handle edge cases
        if (start < 0) start = 0;
        if (end > array.length) end = array.length;
        if (start >= end || array.length == 0) return new int[0];

        // Create a new array for the slice
        int[] slicedArray = new int[end - start];
        for (int i = start; i < end; i++) {
            slicedArray[i - start] = array[i];
        }
        return slicedArray;
    }

    public int findIndex(int[] array, int val){
        for(int i=0;i<array.length;i++){
            if(array[i]==val){return i;}
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(inorder==null || inorder.length==0){return null;}
        TreeNode root=new TreeNode(preorder[0]);

        int index=findIndex(inorder,root.val);

        root.left=buildTree(sliceArray(1,1+index,preorder),sliceArray(0,index,inorder));
        root.right=buildTree(sliceArray(1+index,preorder.length+1,preorder),sliceArray(index+1,inorder.length+1,inorder));

        return root;

    }
}

public class BTusingTraversal {
    public static void main(String args[]){
        int[] preorder={3,9,20,15,7};
        int[] inorder={9,3,15,20,7};
        Solution newsol=new Solution();
        Solution.printInorder(newsol.buildTree(preorder,inorder));
    }
}
