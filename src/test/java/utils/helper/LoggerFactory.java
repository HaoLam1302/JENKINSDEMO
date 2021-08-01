package utils.helper;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LoggerFactory {
	@SuppressWarnings("rawtypes")
    public static Log getLog(Class clazz) {
        Logger logger = LogManager.getLogger(clazz.getName());
        Log log = new Log(logger.getName());
        log.setParent(logger.getParent());
        log.setRepository(logger.getLoggerRepository());
        return log;
    }
}
