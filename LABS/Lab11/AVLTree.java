class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    int height;
    public TreeNode(){}
    public TreeNode(int ele){
        this.val=ele;
    }
    public void setHeight(int h){
        this.height=h;
    }
}
public class AVLTree {
    TreeNode root;
    public AVLTree(){
        root=new TreeNode();
    };
    // a function to get height of a node
    public static int getHeight(TreeNode Node){
        if(Node==null){
            return 0;
        }
        return Node.height;
    }
    public static void updateHeight(TreeNode Node){
        if(Node.left==null && Node.right==null){
            Node.height=1;
        }
        else{
            Node.height=1+Math.max(getHeight(Node.left),getHeight(Node.right));
        }
    }
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

    public boolean search(int ele){
        boolean var=false;
        TreeNode node=root;
        while(!var){
            if(node==null){
                break;
            }
            if(node.val==ele){
                var=true;
                break;
            }
            else if(node.val<ele){
                node=node.right;
            }
            else{
                node=node.left;
            }
        }
        return var;
    }

    public void insert(int ele){
        insertt(ele,root);
    }
    public TreeNode insertt(int ele, TreeNode Node){
        if(Node==null || Node==this.root){
            return new TreeNode(ele);
        }
        if(ele>Node.val){
            Node.right=insertt(ele,Node.right);
        }
        else{
            if(ele==Node.val){
                return Node;
            }
            Node.right=insertt(ele,Node.right);
        }
        //now updating the heights
        getHeight(Node);
        if(checkBalance(Node)){
            return Node;
        }
        else{
            TreeNode z=Node;
            TreeNode y=getHeight(z.left) > getHeight(z.right) ? z.left : z.right;
            TreeNode x=getHeight(y.left) > getHeight(y.right) ? y.left : y.right;
            if((z.val>=y.val && y.val>=x.val) || (x.val>=y.val && y.val>=z.val)){
                // returning the root of the updated rotated subtree
                return singleRotate(z,y);
                
            }
            else{
                return doubleRotate(z,y,x);
            }
        }
    }
    public static TreeNode singleRotate(TreeNode z, TreeNode y){
        if(y==z.left){
            z.left=y.right;
            y.right=z;
        }
        else{
            z.right=y.left;
            y.left=z;
        }
        return y; //returning root of the rotated subtree
    }
    public static TreeNode doubleRotate(TreeNode z, TreeNode y, TreeNode x){
        if(z.left==y){
            singleRotate(y,x);
            singleRotate(z,x);
        }
        else{
            singleRotate(y,x);
            singleRotate(z,x);
        }
        return x; //returning the root of the rotated subtree;
    }
    public void insert(int[] sorted){
        insert(sorted,0,sorted.length-1,root);
    }
    public static TreeNode insert(int[] sorted, int left, int right,TreeNode node){
        if(left>right){
            return null;
        }
        else{
            int mid = left + (right - left) / 2;
            if(node==null){node=new TreeNode();}
            node.val=sorted[mid];
            node.left=insert(sorted,left,mid-1,node.left);
            node.right=insert(sorted,mid+1,right,node.right);
            return node;
        }

    }
    public void delete(int ele){

    }
    public static void main(String args[]){
        int[] arr= {1,2,3,4,5,6,7};
        AVLTree tree=new AVLTree();
        for(int ele: arr){
            tree.insert(ele);
        }
        // tree.insert(arr);
        inorder(tree.root);
        System.out.println(checkAVL(tree.root));
    }

    public static void inorder(TreeNode Node){
        if(Node==null){
            return;
        }
        inorder(Node.left);
        System.out.print(Node.val + " ");
        inorder(Node.right);
    }
}
