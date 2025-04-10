public class RotateMatrix {
    public static void rotateMat(int[][] mat, int m, int n,int k){
        int xi=(mat[0].length-m)/2;
        int yi=(mat.length-n)/2;
        if(k>0){
            int[] xdir=new int[2*(m+n)-4];
            int[] ydir=new int[2*(m+n)-4];
            for(int i=0;i<xdir.length;i++){
                if(i<m-1){
                    xdir[i]=1;
                    ydir[i]=0;
                }
                else if(i>=m-1 && i < m+n-2){
                    xdir[i]=0;
                    ydir[i]=-1;
                }
                else if(i>=m+n-2 && i< 2*m+n-3){
                    xdir[i]=-1;
                    ydir[i]=0;
                }
                else{
                    xdir[i]=0;
                    ydir[i]=1;
                }
            }
        }

    }
}
