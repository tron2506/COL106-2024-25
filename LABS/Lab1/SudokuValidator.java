public class SudokuValidator {
    public boolean checkBox(char[][] board, int x , int y, int value){
        int count=0;
        for(int i=x;i<x+3;i++){
            for(int j=y;j<y+3;j++){
                if(Integer.valueOf(String.valueOf(board[i][j]))==value) count++;
                if(count>1) return false;
            }
        }
        return true;
    }
    public boolean checkRowAndColumn(char[][] board, int x, int y, int value){
        int count=0;
        for(int i=0;i<9;i++){
            if(Integer.valueOf(String.valueOf(board[i][y]))==value){count++;}
            if(count>1) return false;
        }
        count=0;
        for(int j=0;j<9;j++){
            if(Integer.valueOf(String.valueOf(board[x][j]))==value){count++;}
            if(count>1) return false;
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(Character.isDigit(board[i][j])){
                    if(checkRowAndColumn(board,i,j,Integer.valueOf(String.valueOf(board[i][j])))){
                        int x=(i/3)*3;
                        int y=(j/3)*3;
                        if(checkBox(board,x,y,Integer.valueOf(String.valueOf(board[i][j])))){
                            continue;
                        }
                        else{return false;}
                    }
                    else{return false;}
                }
            }
        }
        return true;
    }
}
