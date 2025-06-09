import java.util.*;

public class MatrixIslandsWithDiagonals {

    static int[][] directions = {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1},           {0, 1},
        {1, -1},  {1, 0},  {1, 1}
    };

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows=sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols=sc.nextInt();

        int[][] grid=new int[rows][cols];

        System.out.println("Enter matrix values (0 or 1):");
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                grid[i][j]=sc.nextInt();
            }
        }

        int count=countIslands(grid, rows, cols);
        System.out.println("Number of islands: " + count);
    }

    private static int countIslands(int[][] grid, int rows, int cols) {
        boolean[][] visited=new boolean[rows][cols];
        int count=0;

        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if (grid[i][j]== 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j, rows, cols);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] grid, boolean[][] visited, int x, int y, int rows, int cols) {
        visited[x][y]=true;

        for (int[] dir : directions) {
            int nx=x + dir[0];
            int ny=y + dir[1];

            if (isValid(nx, ny, rows, cols) && grid[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(grid, visited, nx, ny, rows, cols);
            }
        }
    }

    private static boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
