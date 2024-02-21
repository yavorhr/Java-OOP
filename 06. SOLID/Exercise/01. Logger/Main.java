import controllers.SimpleLayout;
import interfaces.*;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Layout simpleLayout = new SimpleLayout();

    Appender consoleAppender = new ConsoleAppender(simpleLayout);
    Logger logger = new MessageLogger(consoleAppender);

    logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
    logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");

  }
}


