package com.agshing.trellis.config;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigManager{
    private static final Logger logger = Logger.getLogger(ConfigManager.class.getName());
    public static String READER;
    public static String SOLVER;
    public static String FILE_PATH;

    static {
        logger.info("Parsing app property file...");
        Properties appProps = new Properties();
        try {
            appProps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("app.properties"));
            READER = appProps.getProperty("reader");
            SOLVER = appProps.getProperty("solver");
            FILE_PATH = appProps.getProperty("file-path");
            logger.info("App property file was parsed successfully.");
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error occurred while reading parameters from app property file. \n" +
                    "System will try to work with default parameters", ex);
            setDefaultParams();
        }
    }

    private static void setDefaultParams() {
        READER = "file-reader";
        SOLVER = "dijkstra";
        FILE_PATH = "sample-data.txt";
    }
}
