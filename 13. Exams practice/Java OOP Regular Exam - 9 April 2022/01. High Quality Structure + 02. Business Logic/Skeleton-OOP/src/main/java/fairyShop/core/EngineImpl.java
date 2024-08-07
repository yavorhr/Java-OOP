package fairyShop.core;

import fairyShop.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
  private Controller controller;
  private BufferedReader reader;

  public EngineImpl() {
    this.controller = new ControllerImpl();
    this.reader = new BufferedReader(new InputStreamReader(System.in));
  }

  @Override
  public void run() {
    while (true) {
      String result = null;
      try {
        result = processInput();

        if (result.equals("Exit")) {
          break;
        }
      } catch (NullPointerException | IllegalArgumentException | IOException e) {
        result = e.getMessage();
      }

      System.out.println(result);
    }
  }

  private String processInput() throws IOException {
    String input = this.reader.readLine();
    String[] tokens = input.split("\\s+");

    Command command = Command.valueOf(tokens[0]);
    String result = null;
    String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

    result = switch (command) {
      case AddHelper -> addHelper(data);
      case AddPresent -> addPresent(data);
      case AddInstrumentToHelper -> addInstrumentToHelper(data);
      case CraftPresent -> craftPresent(data);
      case Report -> report();
      case Exit -> Command.Exit.name();
    };
    return result;
  }

  private String addHelper(String[] data) {
    return this.controller.addHelper(data[0], data[1]);
  }

  private String addPresent(String[] data) {
    return this.controller.addPresent(data[0],
            Integer.parseInt(data[1]));
  }

  private String addInstrumentToHelper(String[] data) {
    return this.controller.addInstrumentToHelper(data[0],
            Integer.parseInt(data[1]));
  }

  private String report() {
    return this.controller.report();

  }

  private String craftPresent(String[] data) {
    return this.controller.craftPresent(data[0]);
  }
}
