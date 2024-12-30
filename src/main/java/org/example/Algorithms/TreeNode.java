package org.example.Algorithms;

public class TreeNode {

    public int pathCost;
    public int evaluationValue;
    public int heuristicValue;
    int[][] nodeValue;

    public TreeNode(int[][] nodeValue, int heuristicValue) {
        this.heuristicValue = heuristicValue;
        this.evaluationValue = this.pathCost + heuristicValue;
        this.nodeValue = nodeValue;
    }

    public int getEvaluationValue() {
        return evaluationValue;
    }

    public int getHeuristicValue() {
        return heuristicValue;
    }

    public int getPathCost() {
        return pathCost;
    }

    public int[][] getNodeValue() {
        return nodeValue;
    }

    public void setPathCost(int pathCost) {
        this.pathCost = pathCost;
    }

    public void setNodeValue(int[][] nodeValue) {
        this.nodeValue = nodeValue;
    }

    public void setEvaluationValue(int evaluationValue) {
        this.evaluationValue = evaluationValue;
    }

    public void setHeuristicValue(int heuristicValue) {
        this.heuristicValue = heuristicValue;
    }

}
