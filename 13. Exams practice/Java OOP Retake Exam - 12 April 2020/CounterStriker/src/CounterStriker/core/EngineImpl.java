package CounterStriker.core;

import CounterStriker.common.Command;

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

        if (result.equals(Command.Exit.name())) {
          break;
        }

      } catch (IOException | IllegalArgumentException | NullPointerException e) {
        result = e.getMessage();
      }

      System.out.println(result);
    }
  }

  private String processInput() throws IOException {
    String input = this.reader.readLine();
    String[] tokens = input.split("\\s");

    Command command = Command.valueOf(tokens[0]);
    String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

    String result = null;

    switch (command) {
      case AddPlayer:
        result = this.controller.addPlayer(data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5]);
        break;
      case Exit:
        result = Command.Exit.name();
        break;
      case StartGame:
        result = this.controller.startGame();
        break;
      case Report:
        result = this.controller.report();
        break;
      case AddGun:
        result = this.controller.addGun(data[1], data[2], Integer.parseInt(data[3]));
        break;
    }

    return result;
  }

  private String addGun(String[] data) {
    //TODO
    return null;
  }

  private String report() {
    //TODO
    return null;
  }

  private String addPlayer(String[] data) {
    //TODO
    return null;
  }

  private String start() {
    //TODO
    return null;
  }
}
