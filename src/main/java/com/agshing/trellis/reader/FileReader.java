package com.agshing.trellis.reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReader implements DataReader {
    private final static Logger logger = Logger.getLogger(FileReader.class.getName());
    private final String filePath;

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> read(){
        return readFile();
    }

    private List<String> readFile(){
        List<String> data = null;
        try {
            final File file = new File(filePath);
            data = Files.readAllLines(file.toPath());
        }catch (IOException iox){
            logger.log(Level.SEVERE, "Could not parse data. Application will stop immediately.", iox);
            System.exit(0);
        }
        return data;
    }
}
