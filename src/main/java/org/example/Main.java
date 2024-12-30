package org.example;

import org.example.Algorithms.AStarSearch;
import org.example.Algorithms.GreedySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int size = 0;
        LinkedList<int[][]> initialStates = new LinkedList<>();
        boolean found = false;

        for (int i = 0; i < 10; i++) {
            int index = 0;
            int[][] initial_state = new int[3][3];
            List<Integer> numbers = new ArrayList<>();

            for (int j = 0; j < 9; j++) {
                numbers.add(j);
            }
            Collections.shuffle(numbers);

            // Fill initial state matrix with shuffled numbers
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < 3; j++) {
                    initial_state[k][j] = numbers.get(index);
                    index++;
                }
            }
            initialStates.add(initial_state);
        }

        System.out.println("Initial States are created");

        GreedySearch greedySearch = new GreedySearch();
        AStarSearch  aStarSearch = new AStarSearch();
        // Run all search algorithms for each initial state
        for (int i = 0; i < 10; i++) {

            System.out.println("Greedy Search algorithm is started");
            greedySearch.search(initialStates.get(i));

            System.out.println("A* Search algorithm is started");
            aStarSearch.search(initialStates.get(i));

            System.out.println("------------------------------------------");
            System.out.println();

        }
    }
}