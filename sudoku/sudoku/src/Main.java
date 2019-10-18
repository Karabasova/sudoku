import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args) {

        String input = ""
                + "100026039"
                + "008700601"
                + "000000200"
                + "400900516"
                + "000000000"
                + "796004008"
                + "009000000"
                + "301002900"
                + "640180003";

        int[][] board = stream(input.split("(?<=\\G.{9})"))
                .map(Main::splitRow)
                .toArray(int[][]::new);

        Sudoku sudoku = new Sudoku(board);
        sudoku.board();

        System.out.println(sudoku);

        System.out.println((sudoku.solve() ? "Valid" : "Invalid") + "\n");

        System.out.println(sudoku);
    }

    private static int[] splitRow(String s) {
        return stream(s.split("(?<=\\G.)")).mapToInt(Integer::parseInt).toArray();
    }
}
