import java.util.Random;

public class Gothammaze {
    private int size;
    private int[][] maze;
    private int[][][] mazeLayouts;
    private int currentLayout;

    public Gothammaze(int size) {
        this.size = size;
        this.mazeLayouts = new int[8][size][size]; // Increase the size to 5 to accommodate layouts 1 to 5
        generateLayout1();
        generateLayout2();
        generateLayout3();
        generateLayout4();
        generateLayout5();
        generateLayout6();
        this.currentLayout = 0; // Start with layout 1
    }

    public int[][] generateMaze() {
        int[][] maze = mazeLayouts[currentLayout];
        currentLayout = (currentLayout + 1) % mazeLayouts.length; // Cycle to the next layout
        return maze;
    }

    public int getCurrentLayout() {
        return currentLayout + 1; // Return the current layout number (1-based index)
    }

    public int getTotalLayouts() {
        return mazeLayouts.length; // Return the total number of layouts
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
                {0, 2, 2, 0, 1, 0, 0, 1, 0, 0},
                {0, 2, 2, 1, 1, 1, 1, 1, 1, 1},
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

    private void generateLayout4() {
        // Define the maze layout 4 with a car that blocks a path every two turns
        int[][] layout4A = {
                {1, 1, 1, 1, 1, 1, 2, 2, 2, 2},
                {0, 0, 1, 0, 0, 1, 2, 2, 2, 2},
                {0, 0, 1, 0, 0, 1, 1, 1, 2, 2},
                {0, 0, 1, 1, 1, 1, 0, 1, 2, 2},
                {0, 0, 1, 0, 0, 0, 0, 1, 2, 2},
                {0, 0, 1, 0, 0, 0, 0, 1, 2, 2},
                {0, 0, 1, 0, 0, 0, 0, 3, 2, 2},
                {0, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}
        };
        mazeLayouts[3] = layout4A;
    }

    private void generateLayout5() {
        int[][] layout4B = {
                {1, 1, 1, 1, 1, 1, 2, 2, 2, 2},
                {0, 0, 1, 0, 0, 1, 2, 2, 2, 2},
                {0, 0, 1, 0, 0, 1, 1, 1, 2, 2},
                {0, 0, 1, 1, 1, 1, 0, 1, 2, 2},
                {0, 0, 1, 0, 0, 0, 0, 1, 2, 2},
                {0, 0, 3, 0, 0, 0, 0, 1, 2, 2},
                {0, 0, 1, 0, 0, 0, 0, 1, 2, 2},
                {0, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}
        };
        mazeLayouts[4] = layout4B;
    }

    private void generateLayout6() {
        int[][] layout6 = {
                {1, 1, 1, 0, 1, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 2, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 2, 1, 0, 1, 1},
                {0, 1, 1, 1, 1, 2, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 2, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 2, 2, 1, 1, 0},
                {0, 1, 0, 0, 1, 1, 2, 0, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 0}
        };
        mazeLayouts[5] = layout6;
    }
}
