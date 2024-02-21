import controllers.*;
import enums.ReportLevel;
import interfaces.*;

import java.util.*;

public class Main {
  public static void main(String[] args) {


//    Layout simpleLayout = new SimpleLayout();
//
//    Appender consoleAppender = new ConsoleAppender(simpleLayout);
//    Logger logger = new MessageLogger(consoleAppender);
//
//    logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
//    logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");

    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());

    AppenderFactory appenderFactory = new AppenderWorkshop();
    LayoutFactory layoutFactory = new LayoutWorkshop();

    Logger logger = new MessageLogger();

    while (n-- > 0) {
      String[] tokens = scanner.nextLine().split("\\s+");

      ReportLevel reportLevel = tokens.length == 3
              ? ReportLevel.valueOf(tokens[2].toUpperCase())
              : ReportLevel.INFO;

      Appender appender = appenderFactory.produce(tokens[0], layoutFactory.produce(tokens[1]));
      logger.addAppender(appender);
    }

    String input = scanner.nextLine();

  }
}


