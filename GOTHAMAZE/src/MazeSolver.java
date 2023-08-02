import java.util.Scanner;

public class MazeSolver {
    private int[][] maze;
    private int[][] solution;
    private int size;
    private int playerX;
    private int playerY;
    private boolean solved;

    public void setMaze(int[][] maze) {
        this.maze = maze;
        this.size = maze.length;
        this.solution = new int[size][size];
        this.playerX = 0;
        this.playerY = 0;
        this.solved = false;
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public boolean isSolved() {
        return solved;
    }

    public void movePlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your next move (w/a/s/d) (up/left/down/right):");
        String move = scanner.nextLine().trim().toLowerCase();

        switch (move) {
            case "w":
                if (isValidMove(playerX - 1, playerY)) {
                    playerX--;
                }
                break;
            case "s":
                if (isValidMove(playerX + 1, playerY)) {
                    playerX++;
                }
                break;
            case "a":
                if (isValidMove(playerX, playerY - 1)) {
                    playerY--;
                }
                break;
            case "d":
                if (isValidMove(playerX, playerY + 1)) {
                    playerY++;
                }
                break;
            default:
                System.out.println("Invalid move. Please enter u/d/l/r for up/down/left/right.");
        }

        // Check if the player reached the ending position
        if (playerX == size - 2 && playerY == size - 1) {
            solved = true;
        }
    }

    private boolean isValidMove(int x, int y) {
        return (x >= 0 && x < size && y >= 0 && y < size && maze[x][y] == 1);
    }

    public void resetSolver() {
        this.solution = new int[size][size];
        this.playerX = 0;
        this.playerY = 0;
        this.solved = false;
    }
    

}
