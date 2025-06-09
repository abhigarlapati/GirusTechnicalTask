import java.util.*;
class SudokuValidator 
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[][] board=new int[9][9];

        System.out.println("Enter the Sudoku board (9x9) row-wise:");
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                board[i][j]=sc.nextInt();
            }
        }

        System.out.print("Enter number of custom zones: ");
        int zoneCount=sc.nextInt();
        List<int[][]> customZones=new ArrayList<>();

        for (int z=0;z<zoneCount;z++) {
            System.out.println("Enter 9 coordinates for zone " + (z + 1) + " (row and column pairs):");
            int[][] zone=new int[9][2];
            for (int i=0;i<9;i++) {
                zone[i][0]=sc.nextInt(); // row
                zone[i][1]=sc.nextInt(); // col
            }
            customZones.add(zone);
        }

        if (isValidSudoku(board, customZones)) {
            System.out.println("Valid Sudoku board.");
        } else {
            System.out.println("Invalid Sudoku board.");
        }
    }

    public static boolean isValidSudoku(int[][] board, List<int[][]> zones) {
        for (int i=0;i<9;i++) {
            if (!isUnique(board[i])) return false;

            int[] col=new int[9];
            for (int j=0;j<9;j++) {
                col[j]=board[j][i];
            }
            if (!isUnique(col)) return false;
        }

        for (int row=0;row<9;row+=3) {
            for (int col=0;col<9;col+=3) {
                int[] box=new int[9];
                int idx=0;
                for (int i=0;i<3;i++) {
                    for (int j=0;j<3;j++) {
                        box[idx++]=board[row+i][col+j];
                    }
                }
                if (!isUnique(box)) return false;
            }
        }

        for (int[][] zone : zones) {
            int[] nums=new int[9];
            for (int i=0;i<9;i++) {
                int r=zone[i][0], c=zone[i][1];
                if (r < 0 || r >= 9 || c < 0 || c >= 9) return false;
                nums[i]=board[r][c];
            }
            if (!isUnique(nums)) return false;
        }

        return true;
    }

    private static boolean isUnique(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            if (num < 1 || num > 9 || !set.add(num)) {
                return false;
            }
        }
        return true;
    }
}
    
