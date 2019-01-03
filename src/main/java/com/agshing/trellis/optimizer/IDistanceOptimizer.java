package com.agshing.trellis.optimizer;

public interface IDistanceOptimizer {
    void addConnection(String from, String to, Double distance, boolean isBidirectional);

    Double computeShortestDistance(String start, String end);
}
