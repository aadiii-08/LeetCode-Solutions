// recursion + memo

// class Solution {
//     int m, n;
//     int[][][] t;

//     public boolean hasValidPath(char[][] grid) {
//         m = grid.length;
//         n = grid[0].length;
//         if ((m + n - 1) % 2 == 1)
//             return false;
//         if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
//             return false;

//         t = new int[101][101][201];
//         for (int i = 0; i < 101; i++) {
//             for (int j = 0; j < 101; j++) {
//                 Arrays.fill(t[i][j], -1);
//             }
//         }

//         return solve(0, 0, 0, grid);
//     }

//     boolean solve(int i, int j, int count, char[][] grid) {
//         count += (grid[i][j] == '(') ? 1 : -1;

//         if (count < 0)
//             return false;

//         if (t[i][j][count] != -1) {
//             return t[i][j][count] == 1;
//         }

//         if (i == m - 1 && j == n - 1){
//             t[i][j][count] = (count == 0) ? 1 : 0;
//             return count == 0;
//         }

//         // for down
//         if (i + 1 < m) {
//             if (solve(i + 1, j, count, grid)) {
//                 t[i][j][count] = 1;
//                 return true;
//             }
//         }

//         // for right
//         if (j + 1 < n) {
//             if (solve(i, j + 1, count, grid)) {
//                 t[i][j][count] = 1;
//                 return true;
//             }
//         }

//         t[i][j][count] = 0;
//         return false;
//     }
// }


//bottom up
class Solution {
    int m, n;
    boolean[][][] t;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if ((m + n - 1) % 2 == 1)
            return false;

        if (grid[0][0] != '(' || grid[m - 1][n - 1] != ')') {
            return false;
        }

        t = new boolean[m][n][201];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                for (int openCount = 0; openCount <= i + j + 1; openCount++) {
                    if (i == m - 1 && j == n - 1) {
                        t[i][j][openCount] = (openCount == 0);
                        continue;
                    }

                    t[i][j][openCount] = false;

                    // move down
                    if (i + 1 < m) {
                        int newOpCount = (grid[i + 1][j] == '(') ? openCount + 1 : openCount - 1;
                        if (newOpCount >= 0 && t[i + 1][j][newOpCount]) {
                            t[i][j][openCount] = true;
                        }
                    }

                    // move right
                    if (j + 1 < n) {
                        int newOpCount = (grid[i][j + 1] == '(') ? openCount + 1 : openCount - 1;
                        if (newOpCount >= 0 && t[i][j + 1][newOpCount]) {
                            t[i][j][openCount] = true;
                        }
                    }
                }
            }
        }

        return t[0][0][1];
    }
}