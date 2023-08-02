import java.util.Scanner;

public class MazeGame {
    public static void main(String[] args) {
        int size = 10; // Change the maze size as needed
        Gothammaze city = new Gothammaze(size);
        MazeSolver mazeSolver = new MazeSolver();

        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            int[][] maze = city.generateMaze(); // Generate a new maze
            mazeSolver.setMaze(maze);

            System.out.println("Welcome to Gotham City!{REACH THE BOTTOM RIGHT}:");
            printMaze(maze, mazeSolver.getPlayerX(), mazeSolver.getPlayerY());

            while (!mazeSolver.isSolved()) {
                mazeSolver.movePlayer();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                printMaze(maze, mazeSolver.getPlayerX(), mazeSolver.getPlayerY());
            }

            if (city.getCurrentLayout() == city.getTotalLayouts() - 1) {
                System.out.println("Congratulations! You have completed all mazes.");
                playAgain = false;
            } else {
                System.out.println("You have reached your destination.");
                boolean validInput = false;
                while (!validInput) {
                    System.out.print("Are you ready for the next difficulty? (y/n): ");
                    String input = scanner.nextLine().trim().toLowerCase();
                    if (input.equals("y")) {
                        mazeSolver.resetSolver();
                        validInput = true;
                    } else if (input.equals("n")) {
                        playAgain = false;
                        validInput = true;
                    } else {
                        System.out.println("Invalid input. Please enter 'y' or 'n'.");
                    }
                }
            }
        }

        System.out.println("Thanks for playing! Goodbye.");
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
                    System.out.print(" ⍋⍋ "); // Tree
                } else if (maze[i][j] == 3) {
                    System.out.print(" ꔮꔮ "); // Car
                } else {
                    System.out.print(" ██ "); // Colored block for walls
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
