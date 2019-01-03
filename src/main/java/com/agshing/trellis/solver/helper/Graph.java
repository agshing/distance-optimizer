package com.agshing.trellis.solver.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * The class represents a graph
 */
public class Graph {
    private Map<String, Node> nodesMap = new HashMap<>();

    public void addNode(Node node) {
        nodesMap.put(node.getName(), node);
    }

    public Node getNodeByName(String name){
        return nodesMap.get(name);
    }
}
