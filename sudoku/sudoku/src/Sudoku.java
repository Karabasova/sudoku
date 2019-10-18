import java.util.stream.IntStream;

public class Sudoku implements SudokuRules {

    private int[][] board;

    Sudoku(int[][] board) {
        this.board = board;
    }

    void board() {
        if (board.length < 2) {
            throw new IllegalArgumentException("Array is empty!");
        }

        IntStream.range(0, 9).forEach(i -> System.arraycopy(board[i], 0, this.board[i], 0, 9));
    }

    public boolean validateRow(int row, int num) {
        return IntStream.range(0, 9).anyMatch(i -> board[row][i] == num);
    }

    public boolean validateColumn(int col, int num) {
        return IntStream.range(0, 9).anyMatch(i -> board[i][col] == num);
    }

    public boolean validate3x3(int row, int col, int num) {
        int r = row - row % 3;
        int c = col - col % 3;
        return IntStream.range(r, r + 3).anyMatch(i -> IntStream.range(c, c + 3).anyMatch(j -> board[i][j] == num));
    }

    public boolean checkAll(int row, int col, int num) {
        return !validateRow(row, num)
                && !validateColumn(col, num)
                && !validate3x3(row, col, num);
    }

    boolean solve() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) {
                    continue;
                }

                for (int num = 1; num <= 9; num++) {
                    if (!checkAll(i, j, num)) {
                        continue;
                    }

                    board[i][j] = num;
                    if (!solve()) {
                        board[i][j] = 0;
                        continue;
                    }
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    private String draw() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                result.append(" ").append(board[i][j]);
            }
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return this.draw();
    }
}
