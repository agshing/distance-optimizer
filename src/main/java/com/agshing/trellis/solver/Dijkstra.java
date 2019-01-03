package com.agshing.trellis.solver;

import com.agshing.trellis.reader.DataReader;
import com.agshing.trellis.solver.helper.Graph;
import com.agshing.trellis.solver.helper.Node;
import com.agshing.trellis.utils.DataUtils;
import java.util.*;

/*
 * The class is responsible for calculating shortest distance using Dijkstra algorithm
 */
public class Dijkstra implements ShortestPath {
    private Graph graph;

    public Dijkstra(DataReader reader){
        this.graph = DataUtils.buildGraph(reader);
    }

    /**
     * This method is used to calculate shortest distance between nodes via Dijkstra algorithm
     * @param from source node
     * @oaram to destination node
     * @return shortest distance between source and destination
     */
    @Override
    public Double calculateShortestPathFromSource(String from, String to) {
        Node source = graph.getNodeByName(from);
        Node destination = graph.getNodeByName(to);
        source.setDistance(0d);
        Set<Node> settledNodes = new HashSet<>();
        PriorityQueue<Node> unsettledNodes = new PriorityQueue<>(Comparator.comparing(Node::getDistance));
        unsettledNodes.add(source);
        while (unsettledNodes.size() != 0) {
            Node currentNode = unsettledNodes.poll();
            for (Map.Entry<Node, Double> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Double distance = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, distance, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return destination.getDistance() == Double.MAX_VALUE ? -9999d : destination.getDistance();
    }

    /**
     * This method is used to ad connection between nodes
     * @param from source node
     * @oaram to destination node
     * @oaram distance between nodes
     * @oaram isBidirectional shows if connection must be bidirectional
     */
    @Override
    public void addConnection(String from, String to, Double distance, boolean isBidirectional) {
        DataUtils.addEdge(graph, from, to, distance, isBidirectional);
    }

    private void calculateMinimumDistance(Node evaluationNode, Double distance, Node sourceNode) {
        Double sourceDistance = sourceNode.getDistance();
        if (sourceDistance + distance < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + distance);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}
