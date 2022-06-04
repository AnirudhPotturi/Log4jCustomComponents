package uw.edu.css553;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uw.edu.css553.logger.CustomLogger;

/**
 * @Author Anirudh Potturi
 * A dummy application to test the custom logger.
 */
public class DemoApplication {
    public static void main(String[] args)  {
        final Logger wrapped = LogManager.getLogger();
        CustomLogger logger = new CustomLogger(wrapped);

        /**
         * Sample log statements.
         */
        logger.echo("Checkpoint placed!", 6);
        logger.warn("releasePRIDLock: unlocking lock caught an exception");

        /**
         * Using 'off' function indicating that logging operations will be stopped before analysis.
         */
        logger.off("Turning off logging operations at this point!!");
        logger.runner("app.log");
    }




}