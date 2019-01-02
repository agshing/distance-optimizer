package com.agshing.trellis.solver.helper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Set<Node> nodes = new HashSet<>();
    private Map<String, Node> nodesMap = new HashMap<>();
    private boolean hasNegativeDistance;

    public void addNode(Node node) {
        nodesMap.put(node.getName(), node);
        nodes.add(node);
        if(node.getDistance() < 0d){
            hasNegativeDistance = true;
        }
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public Node getNodeByName(String name){
        return nodesMap.get(name);
    }

    public boolean hasNegativeDistance() {
        return hasNegativeDistance;
    }
}
