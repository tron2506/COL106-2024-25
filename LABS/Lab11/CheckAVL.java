class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    int height;
    public TreeNode(int ele){
        this.val=ele;
    }
    public void setHeight(int h){
        this.height=h;
    }
}
public class CheckAVL {
    public static int setHeight1(TreeNode Node){
        if(Node==null){
            return 0;
        }
        Node.setHeight(1+Math.max(setHeight1(Node.left),setHeight1(Node.right)));
        return Node.height;
    }
    public static boolean checkSearch(TreeNode root,Long left, Long right){
        if(root==null){
            return true;
        }
        if(root.val<=right && root.val>=left){
            return checkSearch(root.right,(long)root.val,right) && checkSearch(root.left,left,(long)root.val);
        }
        else{
            return false;
        }
    }
    public static boolean checkAVL(TreeNode root){
        setHeight1(root);
        return checkSearch(root,Long.MIN_VALUE,Long.MAX_VALUE) && checkAVL1(root);
    }
    public static boolean checkBalance(TreeNode root){
        if(root==null){
            return true;
        }
        int l= root.left==null ? 0 : root.left.height;
        int r= root.right==null ? 0 : root.right.height;
        if(l-r>=-1 && l-r<=1){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean checkAVL1(TreeNode root){
        if(root==null){
            return true;
        }
        if(checkBalance(root)){
            return checkAVL1(root.left) && checkAVL(root.right);
        }
        else{
            return false;
        }
    }
    public static void main(String args[]){
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(15);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(7);
        root1.right.left = new TreeNode(12);
        root1.right.right = new TreeNode(20);

        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.left.left = new TreeNode(2);
        root2.left.left.left = new TreeNode(1);

        TreeNode root3 = new TreeNode(10);

        TreeNode root4 = new TreeNode(10);
        root4.left = new TreeNode(5);
        root4.left.left = new TreeNode(2);

        TreeNode root5 = new TreeNode(10);
        root5.right = new TreeNode(15);
        root5.right.right = new TreeNode(20);

        TreeNode root6 = new TreeNode(30);
        root6.left = new TreeNode(20);
        root6.right = new TreeNode(40);
        root6.left.left = new TreeNode(10);
        root6.left.right = new TreeNode(25);
        root6.right.left = new TreeNode(35);
        root6.right.right = new TreeNode(50);
        root6.left.left.left = new TreeNode(5);
        root6.left.left.right = new TreeNode(15);

        System.out.println(checkAVL(root5));
    }
}
