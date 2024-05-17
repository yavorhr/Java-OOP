package football.core;

import football.common.Command;

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
      } catch (NullPointerException | IllegalArgumentException | IllegalStateException | IOException e) {
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
      case AddField -> addField(data);
      case DeliverySupplement -> deliverySupplement(data);
      case SupplementForField -> supplementForField(data);
      case AddPlayer -> addPlayer(data);
      case DragPlayer -> dragPlayer(data);
      case CalculateStrength -> calculateStrength(data);
      case GetStatistics -> getStatistics();
      case Exit -> Command.Exit.name();
    };
    return result;
  }

  private String addField(String[] data) {
    return this.controller.addField(data[0], data[1]);
  }

  private String deliverySupplement(String[] data) {
    return this.controller.deliverySupplement(data[0]);
  }

  private String supplementForField(String[] data) {
    return this.controller.supplementForField(data[0], data[1]);
  }

  private String addPlayer(String[] data) {
    return this.controller.addPlayer(data[0], data[1], data[2],data[3], Integer.parseInt(data[4]));
  }

  private String dragPlayer(String[] data) {
    return this.controller.dragPlayer(data[0]);
  }

  private String calculateStrength(String[] data) {
    return this.controller.calculateStrength(data[0]);
  }

  private String getStatistics() {
    return this.controller.getStatistics();
  }
}
