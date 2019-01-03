package com.agshing.trellis.reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * The class is responsible for retrieving list of data representing edges and distances in graph
 */
public class FileReader implements DataReader {
    private final static Logger logger = Logger.getLogger(FileReader.class.getName());
    private final String filePath;

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * This method is used to read data as list of lines
     *
     * @return list of lines that contains graph data
     */
    @Override
    public List<String> read() {
        return readFile();
    }

    private List<String> readFile() {
        List<String> data = null;
        try {
            final File file = new File(filePath);
            data = Files.readAllLines(file.toPath());
        } catch (IOException iox) {
            logger.log(Level.SEVERE, "Could not parse data. Application will stop immediately.", iox);
            System.exit(0);
        }
        return data;
    }
}
