package uw.edu.css553.logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.FormattedMessage;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.spi.ExtendedLogger;
import org.apache.logging.log4j.spi.ExtendedLoggerWrapper;
import uw.edu.css553.report.LogAnalysisApplication;

/**
 * @Author Anirudh Potturi
 * The CustomLogger class is a wrapper that implements the functionalities of a Logger.
 * We define this as a custom logger and can use it to perform logging operations.
 */
public class CustomLogger extends ExtendedLoggerWrapper {

    private final ExtendedLoggerWrapper logger;
    private static final long serialVersionUID = 1L;
    private static final String FQCN = CustomLogger.class.getName();
    LogAnalysisApplication generator = new LogAnalysisApplication();

    /**
     * Constructor
     * @param logger
     * @param name
     * @param messageFactory
     */
    public CustomLogger(ExtendedLogger logger, String name, MessageFactory messageFactory) {
        super((AbstractLogger) logger, logger.getName(), logger.getMessageFactory());
        this.logger = this;
    }

    /**
     * Constructor
     * @param logger
     */
    public CustomLogger(final Logger logger) {
        super((AbstractLogger) logger, logger.getName(), logger.getMessageFactory());
        this.logger = this;
    }

    /**
     * Log method overridden from the actual implementation.
     * @param level
     * @param message
     */
    @Override
    public void log(Level level, Message message) {
    }

    /**
     * This function returns a custom Logger with the name of the calling class.
     * @return The custom Logger for the calling class.
     */
    public static CustomLogger create() {
        final Logger wrapped = LogManager.getLogger();
        return new CustomLogger(wrapped);
    }

    /**
     * This function returns a custom Logger using the fully qualified name of the Class as
     * the Logger name.
     * @param loggerName The Class whose name should be used as the Logger name.
     *            If null it will default to the calling class.
     * @return The custom Logger.
     */
    public static CustomLogger create(final Class<?> loggerName) {
        final Logger wrapped = LogManager.getLogger(loggerName);
        return new CustomLogger(wrapped);
    }

    /**
     * This function logs a message of all levels.
     * @param name
     * @param value
     */
    public void echo(final String name, Object value) {
        Message m = new FormattedMessage("echo: %s(%s)",name,value);
        logger.logIfEnabled(FQCN, Level.ALL, null, m, (Throwable) null);
    }

    public void echo(final String name) {
        Message m = new FormattedMessage("echo: %s",name);
        logger.logIfEnabled(FQCN, Level.ALL, null, m, (Throwable) null);
    }

    /**
     * This function logs a message of INFO - Information level.
     * Messages are informational and highlight the progress of the application at a course-grained level.
     * @param name
     */
    public void info(final String name) {
        Message m = new FormattedMessage("info: %s",name);
        logger.logIfEnabled(FQCN, Level.INFO, null, m, (Throwable) null);
    }

    public void info(final String name, Object value) {
        Message m = new FormattedMessage("info: %s ----- %s",name, value);
        logger.logIfEnabled(FQCN, Level.INFO, null, m, (Throwable) null);
    }

    /**
     * This function logs a message of FATAL - Fatal level.
     * Messages indicate very severe errors in events that may lead to the crashing of an application.
     * @param name
     */
    public void fatal(final String name) {
        Message m = new FormattedMessage("fatal: %s",name);
        logger.logIfEnabled(FQCN, Level.FATAL, null, m, (Throwable) null);
    }

    public void fatal(final String name, Object value) {
        Message m = new FormattedMessage("fatal: %s ----- %s",name, value);
        logger.logIfEnabled(FQCN, Level.FATAL, null, m, (Throwable) null);
    }

    /**
     * This function logs a message of DEBUG - Debug level.
     * Messages indicate fine-grained information in events that can help during debugging.
     * @param name
     */
    public void debug(final String name) {
        Message m = new FormattedMessage("debug: %s",name);
        logger.logIfEnabled(FQCN, Level.DEBUG, null, m, (Throwable) null);
    }

    public void debug(final String name, Object value) {
        Message m = new FormattedMessage("debug: %s ----- %s",name, value);
        logger.logIfEnabled(FQCN, Level.DEBUG, null, m, (Throwable) null);
    }

    /**
     * This function logs a message of WARN - Warn level.
     * Messages indicate harmful situations during operations.
     * @param name
     */
    public void warn(final String name) {
        Message m = new FormattedMessage("warn: %s",name);
        logger.logIfEnabled(FQCN, Level.WARN, null, m, (Throwable) null);
    }

    public void warn(final String name,  Object value) {
        Message m = new FormattedMessage("warn: %s ----- %s",name, value);
        logger.logIfEnabled(FQCN, Level.WARN, null, m, (Throwable) null);
    }

    /**
     * This function logs a message of TRACE - Trace level.
     * Messages indicate finer-grained information from events than DEBUG level.
     * @param name
     */
    public void trace(final String name) {
        Message m = new FormattedMessage("trace: %s",name);
        logger.logIfEnabled(FQCN, Level.TRACE, null, m, (Throwable) null);
    }

    public void trace(final String name, Object value) {
        Message m = new FormattedMessage("trace: %s ----- %s",name, value);
        logger.logIfEnabled(FQCN, Level.TRACE, null, m, (Throwable) null);
    }

    /**
     * This function logs a message of ERROR - Error level.
     * Messages inbdicate events that raise errors but don't necessarily abort processes.
     * @param name
     */
    public void error(final String name) {
        Message m = new FormattedMessage("error: %s",name);
        logger.logIfEnabled(FQCN, Level.ERROR, null, m, (Throwable) null);
    }

    public void error(final String name, Object value) {
        Message m = new FormattedMessage("error: %s ----- %s",name, value);
        logger.logIfEnabled(FQCN, Level.ERROR, null, m, (Throwable) null);
    }

    /**
     * This function indicates the stopping of logging process.
     * @param name
     */
    public void off(final String name) {
        Message m = new FormattedMessage("off: %s",name);
        logger.logIfEnabled(FQCN, Level.OFF, null, m, (Throwable) null);
    }

    public void off(final String name, Object value) {
        Message m = new FormattedMessage("off: %s ----- %s",name, value);
        logger.logIfEnabled(FQCN, Level.OFF, null, m, (Throwable) null);
    }

    /**
     * A runner function to initiate logging analysis.
     */
    public void runner(String fileName)
    {
        generator.runner(fileName);
    }
}
