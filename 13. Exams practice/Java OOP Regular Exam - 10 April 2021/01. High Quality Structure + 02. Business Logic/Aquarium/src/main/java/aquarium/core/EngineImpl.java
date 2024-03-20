package aquarium.core;

import aquarium.common.Command;

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

    switch (command) {
      case AddAquarium:
        result = this.controller.addAquarium(data[0], data[1]);
        break;
      case AddDecoration:
        result = this.controller.addDecoration(data[0]);
        break;
      case InsertDecoration:
        result = this.controller.insertDecoration(data[0], data[1]);
        break;
      case AddFish:
        result = this.controller.addFish(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]));
        break;
      case FeedFish:
        result = this.controller.feedFish(data[0]);
        break;
      case CalculateValue:
        result = this.controller.calculateValue(data[0]);
        break;
      case Report:
        result = this.controller.report();
        break;
      case Exit:
        result = Command.Exit.name();
        break;
    }
    return result;
  }

  private String addAquarium(String[] data) {
    //TODO
    return null;
  }

  private String addDecoration(String[] data) {
    //TODO
    return null;
  }

  private String insertDecoration(String[] data) {
    //TODO
    return null;
  }

  private String addFish(String[] data) {
    //{aquariumName} {fishType} {fishName} {fishSpecies} {price}
    //TODO
    return null;
  }

  private String feedFish(String[] data) {
    //TODO
    return null;
  }

  private String calculateValue(String[] data) {
    //TODO
    return null;
  }

  private String report() {
    return null;
  }
}

