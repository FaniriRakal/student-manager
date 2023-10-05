package student.manager.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogUtil {

    private static final Logger logger = Logger.getLogger(LogUtil.class.getName());

    public static void logRequest(String request, String service) {
        logger.log(Level.INFO, "service: " + service + ",request: " + request);
    }

    public static void logResponse(String service, String response) {
        logger.log(Level.INFO, "service: " + service + ", response: " + response);
    }

    public static void logError(String service, String error) {
        logger.log(Level.SEVERE, "service: " + service + ",error: " + error);
    }

}
