package controllers;

import interfaces.Appender;
import interfaces.AppenderFactory;
import interfaces.Layout;

public class AppenderWorkshop implements AppenderFactory {

  @Override
  public Appender produce(String appenderType, Layout layout) {

    return switch (appenderType) {
      case "ConsoleAppender" -> new ConsoleAppender(layout);
      default -> throw new IllegalStateException("Not a valid type of appender for " + appenderType + " param");
    };
  }

}
