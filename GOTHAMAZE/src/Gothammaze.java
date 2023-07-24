import java.util.Random;

public class Gothammaze {
    private int size;
    private int[][] maze;
    private int[][][] mazeLayouts;
    private Random random;

    public Gothammaze(int size) {
        this.size = size;
        this.maze = new int[size][size];
        this.random = new Random();

        // Define three different maze layouts
        this.mazeLayouts = new int[3][size][size];
        generateLayout1();
        generateLayout2();
        generateLayout3();
    }

    public int[][] generateMaze() {
        int layoutIndex = random.nextInt(3); // Randomly choose one of the three layouts
        this.maze = mazeLayouts[layoutIndex];
        return maze;
    }

    private void generateLayout1() {
        // Define the maze layout 1
        int[][] layout1 = {
                {1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 1, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        mazeLayouts[0] = layout1;
    }

    private void generateLayout2() {
        // Define the maze layout 2
        int[][] layout2 = {
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1, 0, 0}
        };
        mazeLayouts[1] = layout2;
    }

    private void generateLayout3() {
        // Define the maze layout 3
        int[][] layout3 = {
                {1, 1, 1, 1, 1, 1, 0, 0, 1, 0},
                {1, 0, 0, 1, 0, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 0, 0, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 0, 0, 1, 1, 1},
                {0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                {0, 1, 0, 0, 0, 0, 0, 1, 1, 1},
                {0, 1, 1, 0, 1, 0, 1, 1, 0, 1},
                {0, 0, 1, 1, 1, 0, 1, 0, 0, 0}
        };
        mazeLayouts[2] = layout3;
    }
}
