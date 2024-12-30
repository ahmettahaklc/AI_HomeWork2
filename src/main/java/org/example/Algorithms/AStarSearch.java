package org.example.Algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

public class AStarSearch extends Algorithm {

    public static int heuristicFunction(int[][] initialState) {
        int cost = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int value = initialState[i][j];
                if (value != 0) {
                    int TargetRow = value / 3;
                    int TargetColumn = value % 3;
                    cost += Math.abs(TargetRow - i) + Math.abs(TargetColumn - j);
                }
            }
        }
        return cost;
    }

    @Override
    public void search(int[][] initialState) {
        TreeNode rootNode = new TreeNode(initialState, heuristicFunction(initialState));
        rootNode.setPathCost(0);

        PriorityQueue<TreeNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.evaluationValue));
        priorityQueue.add(rootNode);
        int maxFringeSize = 0;

        while (!priorityQueue.isEmpty()) {
            TreeNode currentNode = priorityQueue.poll();
            numberOfStep++;

            maxFringeSize = Math.max(maxFringeSize, priorityQueue.size());

            if (checkingNode(currentNode)) {
                System.out.println("Goal State is founded");
                System.out.println("Maximum size of fringe: " + maxFringeSize);
                System.out.println("Number of nodes expanded for solved problems:" + --numberOfStep);
                StateManager.clear();
                System.out.println();
                return;
            }

            //Generate child state
            Algorithm.generateChildNodes(currentNode);

            while (!queue.isEmpty()) {
                int[][] childState = queue.remove();
                TreeNode childNode = new TreeNode(childState, heuristicFunction(childState));
                childNode.setPathCost(currentNode.getPathCost() + 1);
                childNode.setEvaluationValue(childNode.getPathCost() + childNode.heuristicValue);
                priorityQueue.add(childNode);
            }

        }
        System.out.println("A* Search could not found goal state");
        System.out.println("Maximum size of fringe: " + maxFringeSize);
        System.out.println("Number of nodes expanded for solved problems:" + numberOfStep);
        StateManager.clear();
        System.out.println();
    }
}
