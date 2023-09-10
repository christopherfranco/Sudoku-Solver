public class main {
    public class SudokuSolver {
        public static void main(String[] args) {
            int[][] puzzle = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                    { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                    { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                    { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                    { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                    { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                    { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                    { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                    { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
            solve(puzzle);
            printSolution(puzzle);
        }

        public static boolean solve(int[][] puzzle) {
            int row = -1, col = -1;
            boolean isEmpty = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (puzzle[i][j] == 0) {
                        row = i;
                        col = j;
                        isEmpty = false;
                        break;
                    }
                }
                if (!isEmpty) {
                    break;
                }
            }
            if (isEmpty) {
                return true;
            }
            for (int num = 1; num <= 9; num++) {
                if (isSafe(puzzle, row, col, num)) {
                    puzzle[row][col] = num;
                    if (solve(puzzle)) {
                        return true;
                    } else {
                        puzzle[row][col] = 0;
                    }
                }
            }
            return false;
        }

        public static boolean isSafe(int[][] puzzle, int row, int col, int num) {
            for (int d = 0; d < 9; d++) {
                if (puzzle[row][d] == num) {
                    return false;
                }
                if (puzzle[d][col] == num) {
                    return false;
                }
                int boxRow = row - row % 3 + d / 3;
                int boxCol = col - col % 3 + d % 3;
                if (puzzle[boxRow][boxCol] == num) {
                    return false;
                }
            }
            return true;
        }

        public static void printSolution(int[][] puzzle) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(puzzle[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

}
