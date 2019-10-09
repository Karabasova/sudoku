import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String input = "100026039008700601000000200400900516000000000796004008009000000301002900640180003";

        //toto tu
        int[][] numbers = Arrays.stream(input.split("(?<=\\G.{9})"))
        .map(s -> (Arrays.stream(s.split("(?<=\\G.{1})")).mapToInt(Integer::parseInt)
        .toArray())).toArray(int[][]::new);

        /*for(int i=0;i<9;i++){
            System.out.println(" ");
            for(int j=0;j<9;j++){
                System.out.print(" "+numbers[i][j]);
            }
        }*/

            int[][] testboard = {
                    {8, 0, 3, 7, 5, 0, 0, 0, 2},
                    {0, 0, 0, 0, 0, 8, 7, 0, 0},
                    {9, 7, 0, 4, 0, 3, 0, 0, 8},
                    {0, 3, 8, 0, 0, 0, 2, 0, 1},
                    {2, 0, 0, 0, 0, 0, 0, 0, 7},
                    {1, 0, 7, 0, 0, 0, 0, 7, 0},
                    {3, 0, 0, 6, 0, 5, 0, 7, 0},
                    {0, 0, 4, 9, 0, 0, 0, 0, 0},
                    {7, 0, 0, 0, 2, 4, 5, 0, 6},
            };

            Sudoku sudoku = new Sudoku(numbers);
            sudoku.board();

            sudoku.printResutl();
           if(sudoku.solveSudoku()){
                System.out.println("good");
                sudoku.printResutl();

            }else{
                System.out.println("bad");
                sudoku.printResutl();
            }
        }
    }
