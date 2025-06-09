import java.util.*;

public class Knights {
    static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter number of rows and columns: ");
        int m=sc.nextInt(), n=sc.nextInt();
        int[][] grid=new int[m][n];

        System.out.println("Enter the grid (0 = empty, 1 = wall):");
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                grid[i][j]=sc.nextInt();
            }
        }

        int result=shortestPathWithTeleport(grid);
        if (result==-1) {
            System.out.println("No path available.");
        } else {
            System.out.println("Minimum steps: " + result);
        }
    }

    public static int shortestPathWithTeleport(int[][] grid) {
        int m=grid.length, n=grid[0].length;

        if (grid[0][0]== 1|| grid[m-1][n-1]== 1) return -1;

        int[][] distFromStart=bfs(grid, 0, 0);
        int[][] distFromEnd=bfs(grid, m-1, n-1);

        if (distFromStart[m-1][n-1] != Integer.MAX_VALUE) {
            return distFromStart[m-1][n-1];
        }

        int min=Integer.MAX_VALUE;

        List<int[]> empties=new ArrayList<>();
        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++)
                if (grid[i][j] == 0) empties.add(new int[]{i, j});

        for (int[] a : empties) {
            for (int[] b : empties) {
                if (Arrays.equals(a, b)) continue;
                int ax=a[0], ay=a[1];
                int bx=b[0], by=b[1];

                if (distFromStart[ax][ay] != Integer.MAX_VALUE &&
                    distFromEnd[bx][by] != Integer.MAX_VALUE) {

                    min=Math.min(min, distFromStart[ax][ay] + 1 + distFromEnd[bx][by]);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static int[][] bfs(int[][] grid, int startX, int startY) {
        int m=grid.length, n=grid[0].length;
        int[][] dist=new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        dist[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] curr=queue.poll();
            int x=curr[0], y=curr[1];
            for (int[] dir : directions) {
                int nx =x + dir[0], ny =y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n &&
                    grid[nx][ny] == 0 && dist[nx][ny] == Integer.MAX_VALUE) {
                    dist[nx][ny]=dist[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return dist;
    }
}
