package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtils {

    private static Logger logger;
    private LoggerUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void logInfo(String message, String className){
        logger = LogManager.getLogger(className);
        logger.info(message);
    }
}
