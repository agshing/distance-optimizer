package com.agshing.trellis.optimizer;

import com.agshing.trellis.reader.FileReader;
import com.agshing.trellis.solver.Dijkstra;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static java.text.MessageFormat.format;
import static org.junit.Assert.assertEquals;

public class DistanceOptimizerTest {
    private String defaultFilePath = format("src{0}test{0}resources{0}sample-data.txt", File.separator);
    private IDistanceOptimizer optimizer;

    @Before
    public void setUp() {
        optimizer = new DistanceOptimizer(new Dijkstra(new FileReader(defaultFilePath)));
    }

    @Test
    public void testShortDistanceAG() {
        assertEquals(9d, optimizer.computeShortestDistance("a", "g"), 0.00001d);
    }

    @Test
    public void testShortDistanceGH() {
        assertEquals(12d, optimizer.computeShortestDistance("g", "h"), 0.00001d);
    }

    @Test
    public void testShortDistanceZA() {
        assertEquals(-9999d, optimizer.computeShortestDistance("z", "a"), 0.00001d);
    }

    @Test
    public void testShortDistanceBE() {
        assertEquals(6d, optimizer.computeShortestDistance("b", "e"), 0.00001d);
    }

    @Test
    public void testShortDistanceAK() {
        assertEquals(4d, optimizer.computeShortestDistance("a", "k"), 0.00001d);
    }

    @Test
    public void testShortDistanceAI() {
        assertEquals(9d, optimizer.computeShortestDistance("a", "i"), 0.00001d);
    }

    @Test
    public void testShortDistanceIA() {
        assertEquals(9d, optimizer.computeShortestDistance("i", "a"), 0.00001d);
    }

}


