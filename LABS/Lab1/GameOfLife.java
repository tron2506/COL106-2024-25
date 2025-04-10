public class GameOfLife {
    public static int[][] gameOfSimulation(int[][] matrix){
        int rows=matrix.length;
        int columns=matrix[0].length;
        int[][] newgen=new int[rows][columns];
        int[][] newmat=new int[rows+2][columns+2];
        for(int i=1;i<rows+1;i++){
            for(int j=1;j<columns+1;j++){
                newmat[i][j]=matrix[i-1][j-1];
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                int life=0;
                for(int a=i-1;a<i+2;a++){
                    for(int b=j-1;b<j+2;b++){
                        if(a==i&&b==j){
                            continue;
                        }
                        if(newmat[a][b]==1) life++;
                    }
                }
                if(matrix[i][j]==1){
                    if(life==2 || life==3) {newgen[i][j]=1;}
                }
                else{
                    if(life==3){newgen[i][j]=1;}
                }
            }
        }
        return newgen;
    }
}
