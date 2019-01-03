package com.agshing.trellis.utils;

import com.agshing.trellis.reader.DataReader;
import com.agshing.trellis.solver.helper.Graph;
import com.agshing.trellis.solver.helper.Node;

import java.util.List;

/*
 * The class is responsible for utility operations - parsing and combining data
 */
public class DataUtils {
    /**
     * Dedicated delimiter for data splitting
     */
    private static final String DELIMITER = ",";

    /**
     * This method is used to parse graph data line by line
     *
     * @param dataReader list of String
     * @return graph representation of read data
     */
    public static Graph buildGraph(DataReader dataReader){
        Graph graph = new Graph();
        List<String> data = dataReader.read();
        for(String s : data){
            String[] metaData = s.split(DELIMITER);
            String from = metaData[0];
            String to = metaData[1];
            double distance = Integer.parseInt(metaData[2]);
            boolean isBidirectional = metaData[3].equals("y");
            addEdge(graph, from, to, distance, isBidirectional);
        }
        return graph;
    }

    /**
     * This method is used to add connection between nodes
     *
     * @param graph graph representation
     * @param from first node
     * @param to second node
     * @param distance value between nodes
     * @param isBidirectional shows if connection must be bidirectional
     */
    public static void addEdge(Graph graph, String from, String to, Double distance, boolean isBidirectional){
        Node nodeFrom = graph.getNodeByName(from);
        if(nodeFrom == null){
            nodeFrom = new Node(from);
            graph.addNode(nodeFrom);
        }
        Node nodeTo = graph.getNodeByName(to);
        if(nodeTo == null){
            nodeTo = new Node(to);
            graph.addNode(nodeTo);
        }
        if(isBidirectional){
            nodeFrom.addDestination(nodeTo, distance);
            nodeTo.addDestination(nodeFrom, distance);
        }else{
            nodeFrom.addDestination(nodeTo, distance);
        }
    }
}
