import java.util.Scanner;

public class MazeGame {
    public static void main(String[] args) {
        int size = 10;
        Gothammaze city = new Gothammaze(size);
        int[][] maze = city.generateMaze();

        MazeSolver mazeSolver = new MazeSolver();
        mazeSolver.setMaze(maze);

        printMaze(maze, mazeSolver.getPlayerX(), mazeSolver.getPlayerY());

        while (!mazeSolver.isSolved()) {
            mazeSolver.movePlayer();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            printMaze(maze, mazeSolver.getPlayerX(), mazeSolver.getPlayerY());
        }

        System.out.println("Congratulations! You've reached the end!.");
    }

    private static void printMaze(int[][] maze, int playerX, int playerY) {
        System.out.println("Maze {REACH THE BOTTOM RIGHT}:");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (i == playerX && j == playerY) {
                    System.out.print("@@"); // Player's position
                } else if (maze[i][j] == 1) {
                    System.out.print("__"); // Empty space for paths
                } else {
                    System.out.print("██"); // Colored block for walls
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
