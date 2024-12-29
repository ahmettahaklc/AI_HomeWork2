package org.example.Algorithms;

public class Algorithm extends StateManager implements SearchMethod{

    public static void generateChildren(int[][] a) {

        // Locate the blank space (0) in the current state
        int column = 0;
        int line = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i][j] == 0) {
                    line = i;
                    column = j;
                }
            }
        }

        // Move the blank up if possible, check uniqueness
        if (line > 0) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line - 1][column];
            fringe[line - 1][column] = 0;

            // Check if this state is unique; if so, add it to the queue.
            if (isUnique(fringe)) {
                queue.add(fringe);
            }
        }

        // Move the blank down if possible, check uniqueness
        if (line < 2) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line + 1][column];
            fringe[line + 1][column] = 0;
            if (isUnique(fringe)) {
                queue.add(fringe);
            }
        }

        // Move the blank left if possible, check uniqueness
        if (column > 0) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line][column - 1];
            fringe[line][column - 1] = 0;
            if (isUnique(fringe)) {
                queue.add(fringe);
            }
        }

        // Move the blank right if possible, check uniqueness
        if (column < 2) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line][column + 1];
            fringe[line][column + 1] = 0;
            if (isUnique(fringe)) {
                queue.add(fringe);
            }
        }
    }

    @Override
    public void search(int[][] initialState) {

    }
}
