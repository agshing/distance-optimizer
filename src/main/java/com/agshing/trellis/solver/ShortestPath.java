package com.agshing.trellis.solver;

public interface ShortestPath {
    Double calculateShortestPathFromSource(String from, String to);
    void addConnection(String from, String to, Double distance, boolean isBidirectional);
}
