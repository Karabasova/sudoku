public interface SudokuRules {
    boolean validateRow(int col, int row);

    boolean validateColumn(int col, int num);

    boolean validate3x3(int row, int col, int num);

    boolean checkAll(int row, int col, int num);
}
