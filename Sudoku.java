public class Sudoku {

    private int[][] board;


    public Sudoku(int[][] board){
        this.board=board;
    }

    public void board(){
        if(board.length < 2){
            throw new IllegalArgumentException("Array is empty!");
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                this.board[i][j] = board[i][j];
            }
        }
    }

    public boolean checkRow(int row,int num){
        for(int i=0;i<9;i++){
                if(board[row][i] == num){
                    return true;
                }
        }
        return false;
    }

    public boolean checkCol(int col,int num){
        for(int i=0;i<9;i++){
            if(board[i][col] == num){
                return true;
            }
        }
        return false;
    }

    public boolean check3x3(int row,int col,int num){
        int r = row-row%3;
        int c = col-col%3;
        for(int i = r;i<r+3;i++){
            for(int j = c;j<c+3;j++){
                if(board[i][j]==num){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkAll(int row,int col,int num){
        return !(checkRow(row, num)  ||  checkCol(col, num)  ||  check3x3(row, col, num));
    }


    public boolean solveSudoku(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == 0){
                    for(int num = 1;num<=9;num++){
                        if(checkAll(i,j,num)){
                            board[i][j] = num;
                            if(solveSudoku()){
                                return true;
                            }else{
                                board[i][j] = 0;
                            }
                        }
                    }return false;
                }
            }
        }
        return true;
    }

    public void printResutl(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(" "+board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
