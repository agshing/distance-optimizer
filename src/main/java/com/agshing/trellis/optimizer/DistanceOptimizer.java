package com.agshing.trellis.optimizer;

import com.agshing.trellis.solver.ShortestPath;

/*
 * The class is responsible for calculating shortest distance by specified algorithm
 */
public class DistanceOptimizer implements IDistanceOptimizer {
    private ShortestPath solver;

    public DistanceOptimizer(ShortestPath algorithm){
        this.solver = algorithm;
    }

    /**
     * This method is used to add connection between nodes
     * @param from source node
     * @oaram to destination node
     * @oaram distance between nodes
     * @oaram isBidirectional shows if connection must be bidirectional
     */
    @Override
    public void addConnection(String from, String to, Double distance, boolean isBidirectional) {
        solver.addConnection(from, to, distance, isBidirectional);
    }

    /**
     * This method is used to calculate shortest distance between nodes by specified algorithm
     * @param start source node
     * @oaram end destination node
     * @return shortest distance between source and destination
     */
    @Override
    public Double computeShortestDistance(String start, String end) {
        return solver.calculateShortestPathFromSource(start, end);
    }
}
