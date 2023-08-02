import java.util.Random;

public class Gothammaze {
    private int size;
    private int[][] maze;
    private int[][][] mazeLayouts;
    private int currentLayout;

    public Gothammaze(int size) {
        this.size = size;
        this.mazeLayouts = new int[3][size][size];
        generateLayout1();
        generateLayout2();
        generateLayout3();
        this.currentLayout = 0; // Start with the first layout
    }

    public int[][] generateMaze() {
        int[][] maze = mazeLayouts[currentLayout];
        currentLayout = (currentLayout + 1) % 3; // Cycle to the next layout
        return maze;
    }
    //1 is free 0 is wall
    private void generateLayout1() {
        // Define the maze layout 1
        int[][] layout1 = {
                {1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 1, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 2, 0, 1, 0, 0},
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
