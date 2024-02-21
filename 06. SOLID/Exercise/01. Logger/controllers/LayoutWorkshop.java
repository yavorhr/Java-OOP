package controllers;

import interfaces.Layout;
import interfaces.LayoutFactory;

public class LayoutWorkshop implements LayoutFactory {

  @Override
  public Layout produce(String type) {

    return switch (type) {
      case "SimpleLayout" -> new SimpleLayout();
      default -> throw new IllegalStateException("Not a valid type of layout for " + type + " param");
    };
  }
}
