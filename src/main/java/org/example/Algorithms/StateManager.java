package org.example.Algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class StateManager {

    private static final Set<List<List<Integer>>> seenStates = new HashSet<>();
    protected static final LinkedList<int[][]> queue = new LinkedList<>();
    public static final int[][] goal_state = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
    protected static int numberOfStep=0;

    public static boolean isUnique(int[][] state) {
        // Convert the 2D array to a list of lists for easy hashing and equality checking
        List<List<Integer>> stateAsList = Arrays.stream(state)
                .map(row -> Arrays.stream(row).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());

        // Check if the state is already in the set
        if (seenStates.add(stateAsList)) {
            // If it's unique, add it to both the queue and the set
            queue.add(state);
            return true;
        }
        return false;
    }

    public static boolean checkingState(int[][] currentState) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (goal_state[i][j] != currentState[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void clear() {
        queue.clear();
        seenStates.clear();
        numberOfStep=0;
    }
}
