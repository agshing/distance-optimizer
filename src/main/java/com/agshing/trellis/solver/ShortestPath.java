package com.agshing.trellis.solver;

import com.agshing.trellis.solver.helper.Graph;

public interface ShortestPath {
    Double calculateShortestPathFromSource(String from, String to);

    Graph getGraph();
}
