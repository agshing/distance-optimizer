package com.agshing.trellis.optimizer;

import com.agshing.trellis.solver.ShortestPath;

public class DistanceOptimizer implements IDistanceOptimizer {
    private ShortestPath solver;

    public DistanceOptimizer(ShortestPath algorithm){
        this.solver = algorithm;
    }

    public void addConnection(String from, String to, Double distance, boolean isBidirectional) {
        solver.addConnection(from, to, distance, isBidirectional);
    }

    public Double computeShortestDistance(String start, String end) {
        return solver.calculateShortestPathFromSource(start, end);
    }
}
