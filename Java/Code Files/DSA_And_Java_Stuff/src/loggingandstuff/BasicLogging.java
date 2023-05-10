package loggingandstuff;

import java.util.logging.*;

public class BasicLogging {
    // Loggers should be named after the class where they reside in
    private final static Logger LOGGER = Logger.getLogger(BasicLogging.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.INFO,"This is fine information\n");
        // The below is not printed because the default Logger cuts off at INFO
        LOGGER.log(Level.FINE,"This is information");
        /*
        ConsoleHandler and LogManager
            * The steps to set custom logging level is to create a new logger lol
            * The steps are as follows
                * Reset the Logger
                * Set the level of Logger
                * Create a new ConsoleHandler
                * Set the level of ConsoleHandler
                * Add the ConsoleHandler to Logger object
         */
        LogManager.getLogManager().reset(); // Reset the logger
        LOGGER.setLevel(Level.FINE); // Set level of logger
        ConsoleHandler ch = new ConsoleHandler(); // Create a ConsoleHandler
        ch.setLevel(Level.FINE); // Set ConsoleHandler's level
        LOGGER.addHandler(ch); // Add it to Logger object

        // Now this will be visible
        LOGGER.log(Level.FINE,"This is fine information\n");

        /* Using a FileHandler
            * The default output is in XML (To use Json, we will need to use Log4J)
            * We can also store logs in the String format by using SimpleFormatter()
         */
        // XML logs
        try{
            // File will be created automatically
            FileHandler f_xml = new FileHandler("src/loggingandstuff/xml_logs.xml", true); // Append = true
            f_xml.setLevel(Level.SEVERE); // Only Severe logs will be present
            LOGGER.addHandler(f_xml);
        }catch (Exception e){
            LOGGER.log(Level.SEVERE,"Some problem with XML log. \n",e); // e is Exception
            System.exit(1);
        }
        LOGGER.log(Level.SEVERE,"This is super duper important");

        // String Logs
        try{
            // File will be created automatically
            FileHandler f_str = new FileHandler("src/loggingandstuff/str_logs.txt", true); // Append = true
            f_str.setFormatter(new SimpleFormatter()); // For string format
            f_str.setLevel(Level.INFO);
            LOGGER.addHandler(f_str);
        }catch (Exception e){
            LOGGER.log(Level.SEVERE,"Some problem with String file",e);
            System.exit(1);
        }
        LOGGER.log(Level.INFO,"This is some additional information\n");

    }
}
