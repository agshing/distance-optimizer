package com.agshing.trellis.solver;

import com.agshing.trellis.reader.DataReader;
import com.agshing.trellis.solver.helper.Graph;
import com.agshing.trellis.solver.helper.Node;
import com.agshing.trellis.utils.DataUtils;
import java.util.*;

public class Dijkstra implements ShortestPath {
    private Graph graph;

    public Dijkstra(DataReader reader){
        this.graph = DataUtils.buildGraph(reader);
    }

    @Override
    public Double calculateShortestPathFromSource(String from, String to) {
        Node source = graph.getNodeByName(from);
        Node destination = graph.getNodeByName(to);
        source.setDistance(0d);
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Node, Double> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Double edgeWeigh = adjacencyPair.getValue();

                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeigh, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return destination.getDistance() == Double.MAX_VALUE ? -9999d : destination.getDistance();
    }

    @Override
    public void addConnection(String from, String to, Double distance, boolean isBidirectional) {
        DataUtils.addEdge(graph, from, to, distance, isBidirectional);
    }

    private void calculateMinimumDistance(Node evaluationNode, Double edgeWeigh, Node sourceNode) {
        Double sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    private Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        double lowestDistance = Double.MAX_VALUE;
        for (Node node : unsettledNodes) {
            double nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
}
