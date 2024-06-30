package magicGame.core;

import magicGame.common.Command;

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

    String result =
            switch (command) {
              case AddMagician -> this.addMagician(data);
              case AddMagic -> this.addMagic(data);
              case StartGame -> this.start();
              case Report -> this.report();
              case Exit -> Command.Exit.name();
              default -> null;
            };

    return result;
  }

  private String addMagician(String[] data) {
    return this.controller.addMagician(data[0],
            data[1],
            Integer.parseInt(data[2]),
            Integer.parseInt(data[3]),
            data[4]);
  }

  private String addMagic(String[] data) {
    return this.controller.addMagic(
            data[0],
            data[1],
            Integer.parseInt(data[2]));
  }

  private String start() {
    return controller.startGame();
  }

  private String report() {
    return this.controller.report();
  }
}
