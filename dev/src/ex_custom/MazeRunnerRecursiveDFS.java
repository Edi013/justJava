package ex_custom;

public class MazeRunnerRecursiveDFS {

    public static boolean canEscape(char[][] maze, int startRow, int startCol) {
        int rows = maze.length;
        int cols = maze[0].length;

        // invalid starting point
        if (maze[startRow][startCol] != '0') return false;

        boolean[][] visited = new boolean[rows][cols];
        System.out.println("Starting DFS from (" + startRow + ", " + startCol + ")");
        boolean result = dfs(maze, startRow, startCol, visited);
        if (!result) {
            System.out.println("No exit found!");
        }
        return result;
    }

    private static boolean dfs(char[][] maze, int r, int c, boolean[][] visited) {
        int rows = maze.length;
        int cols = maze[0].length;

        // If we've gone out of bounds — that's an exit!
        if (r < 0 || c < 0 || r >= rows || c >= cols) {
            System.out.println("Exit found at (" + r + ", " + c + ")");
            return true;
        }

        // If current cell is wall or already visited, stop exploring
        if (maze[r][c] == '#' || visited[r][c]) {
            return false;
        }

        visited[r][c] = true;
        System.out.println("Visiting (" + r + ", " + c + ")");

        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (dfs(maze, nr, nc, visited)) {
                return true;
            }
        }

        // Backtracking
        System.out.println("Backtracking from (" + r + ", " + c + ")");
        return false;
    }

    public static void main(String[] args) {
        char[][] maze1 = {
                {'#','#','#','#','#'},
                {'#','0','0','0','#'},
                {'#','#','0','#','#'},
                {'#','0','0','0','#'},
                {'#','#','#','#','#'}
        };

        char[][] maze2 = {
                {'#','#','#','#'},
                {'0','0','0','#'},
                {'#','#','0','#'},
                {'#','0','0','#'},
                {'#','0','#','#'},
                {'#','0','0','#'},
                {'#','#','#','#'}
        };

        int startRow1 = 1, startCol1 = 2;
        int startRow2 = 1, startCol2 = 2;

        System.out.println("Maze 1 escape: " + canEscape(maze1, startRow1, startCol1));
        System.out.println("\n---------------------------------\n");
        System.out.println("Maze 2 escape: " + canEscape(maze2, startRow2, startCol2));
    }
}
