package DFS;

import java.util.Stack;

public class MazeRunnerIterativeDFS {

    public static boolean canEscape(char[][] maze, int startRow, int startCol) {
        int totalRows = maze.length;
        int totalCols = maze[0].length;

        // Check if starting point is valid
        if (maze[startRow][startCol] != '0') {
            System.out.println("Starting point is a wall. Cannot move!");
            return false;
        }

        boolean[][] visited = new boolean[totalRows][totalCols];
        Stack<int[]> stack = new Stack<>();

        System.out.println("Starting iterative DFS from (" + startRow + ", " + startCol + ")");
        stack.push(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int currentRow = current[0];
            int currentCol = current[1];

            System.out.println("Visiting (" + currentRow + ", " + currentCol + ")");

            if (maze[currentRow][currentCol] == '0' &&
                    (currentRow == 0 || currentCol == 0 ||
                            currentRow == totalRows - 1 || currentCol == totalCols - 1)) {

                System.out.println("Exit found at (" + currentRow + ", " + currentCol + ")");
                return true;
            }

            for (int[] direction : directions) {
                int nextRow = currentRow + direction[0];
                int nextCol = currentCol + direction[1];

                if (nextRow >= 0 && nextRow < totalRows &&
                        nextCol >= 0 && nextCol < totalCols &&
                        maze[nextRow][nextCol] == '0' && !visited[nextRow][nextCol]) {

                    visited[nextRow][nextCol] = true;
                    stack.push(new int[]{nextRow, nextCol});
                    System.out.println("  -> Pushing (" + nextRow + ", " + nextCol + ") onto stack");
                }
            }
        }

        System.out.println("No exit found!");
        return false;
    }

    public static void main(String[] args) {
        char[][] maze1 = {
                {'#', '#', '#', '#', '#'},
                {'#', '0', '0', '0', '#'},
                {'#', '#', '0', '#', '#'},
                {'#', '0', '0', '0', '#'},
                {'#', '#', '#', '#', '#'}
        };

        char[][] maze2 = {
                {'#', '#', '#', '#'},
                {'#', '0', '0', '#'},
                {'#', '#', '0', '#'},
                {'#', '0', '0', '#'},
                {'#', '0', '#', '#'},
                {'#', '0', '0', '#'},
                {'#', '#', '0', '#'}
        };

        int startRow1 = 1, startCol1 = 1;
        int startRow2 = 1, startCol2 = 2;

        System.out.println("Maze 1 escape: " + canEscape(maze1, startRow1, startCol1));
        System.out.println("\n---------------------------------\n");
        System.out.println("Maze 2 escape: " + canEscape(maze2, startRow2, startCol2));
    }
}
