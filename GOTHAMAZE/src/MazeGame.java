import java.util.Scanner;

public class MazeGame {
    public static void main(String[] args) {
        int size = 10; // Change the maze size as needed
        Gothammaze city = new Gothammaze(size);
        MazeSolver mazeSolver = new MazeSolver();

        while (true) {
            int[][] maze = city.generateMaze();
            mazeSolver.setMaze(maze);

            printMaze(maze, mazeSolver.getPlayerX(), mazeSolver.getPlayerY());

            while (!mazeSolver.isSolved()) {
                mazeSolver.movePlayer();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                printMaze(maze, mazeSolver.getPlayerX(), mazeSolver.getPlayerY());
            }

            System.out.println("You have reached your destination.");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Are you ready for the next difficulty? (y/n): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (!playAgain.equals("y")) {
                break;
            }
            mazeSolver.resetSolver();
        }
    }

    private static void printMaze(int[][] maze, int playerX, int playerY) {
        System.out.println("Welcome to Gotham City!{REACH THE BOTTOM RIGHT}:");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (i == playerX && j == playerY) {
                    System.out.print(" _ꆜ "); // Player's position
                } else if (maze[i][j] == 1) {
                    System.out.print(" __ "); // Empty space for paths
                } else if (maze[i][j] == 2) {
                    System.out.print(" ↟↟ "); // Tree
                } else if (maze[i][j] == 3) {
                    System.out.print("ꔮꔮ"); // Car
                } else {
                    System.out.print(" ██ "); // Colored block for walls
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
