public class GameOfLifeBonus {
    
    public static int checkState(int[][] mat,int x,int y){
        int state=0;
        int[] dx={-1,0,1,-1,1,-1,0,1};
        int[] dy={-1,-1,-1,0,0,1,1,1};
        int livenbrs=0;
        for(int i=0;i<8;i++){
            int ni=x+dx[i];
            int nj=y+dy[i];
            if((ni>=0 && ni < mat.length) && (nj>=0 && nj< mat[0].length) && mat[ni][nj]==1) livenbrs++;
        }
        if(mat[x][y]==1 && (livenbrs==2 || livenbrs==3) ){
            state=1;
        }
        else if(mat[x][y]==0 && livenbrs==3){
            state=1;
        }

        return state;
    }

    public static void gameOfLifeBonus(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(checkState(mat,i,j)+ " ");
            }
            System.out.print("\n");
        }
    }
    public static void main(String args[]){
        int[][] mat={
            {0,1,0},
            {1,0,1},
            {0,1,0}
        };
        gameOfLifeBonus(mat);
    }
}
