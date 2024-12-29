package org.example.Algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

public class AStarSearch extends Algorithm {

    public int evaluationValue;
    public int heuristicValue;

    public AStarSearch(int heuristicValue) {
        this.evaluationValue = heuristicValue+1;
    }

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

        while (!priorityQueue.isEmpty()) {
            int[][] currentState = priorityQueue.poll();
            numberOfStep++;

            if (checkingState(currentState)) {
                System.out.println("Goal State is founded");
                System.out.println("Maximum size of fringe: "+priorityQueue.size());
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
        System.out.println("Maximum size of fringe: "+queue.size());
        System.out.println("Number of nodes expanded for solved problems:" + numberOfStep);
        StateManager.clear();
        System.out.println();
    }
}
