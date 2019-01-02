package com.agshing.trellis.utils;

import com.agshing.trellis.reader.DataReader;
import com.agshing.trellis.solver.helper.Graph;
import com.agshing.trellis.solver.helper.Node;

import java.util.List;

public class DataUtils {
    private static final String DELIMITER = ",";

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
