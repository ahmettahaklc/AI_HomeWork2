package org.example.Algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;


public class GreedySearch extends Algorithm {

    //Function to determine the heuristic value
    public static int heuristicFunction(int[][] initialState) {
        int cost = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int value = initialState[i][j];
                if (value !=0) {
                    int TargetRow = value/3;
                    int TargetColumn = value%3;
                    cost += Math.abs(TargetRow - i) + Math.abs(TargetColumn - j);
                }
            }
        }
        return cost;
    }

    @Override
    public void search(int[][] initialState) {
        PriorityQueue<int[][]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(GreedySearch::heuristicFunction));
        priorityQueue.add(initialState);

        int maxFringeSize = 0;

        while (!priorityQueue.isEmpty()) {
            int[][] currentState = priorityQueue.poll();
            numberOfStep++;

            maxFringeSize = Math.max(maxFringeSize, priorityQueue.size());

            if (checkingState(currentState)) {
                System.out.println("Goal State is founded");
                System.out.println("Maximum size of fringe: " + maxFringeSize);
                System.out.println("Number of nodes expanded for solved problems:" + --numberOfStep);
                StateManager.clear();
                System.out.println();
                return;
            }

            //Generate child state
            Algorithm.generateChildren(currentState);

            while (!queue.isEmpty()) {
                int[][] childState = queue.removeFirst();
                /*
                if (isUnique(childState)) {
                    priorityQueue.add(childState);
                }
                */
                priorityQueue.add(childState);
            }

        }
        System.out.println("Greedy Search could not found goal state");
        System.out.println("Maximum size of fringe: " + maxFringeSize);
        System.out.println("Number of nodes expanded for solved problems:" + numberOfStep);
        StateManager.clear();
        System.out.println();
    }
}
