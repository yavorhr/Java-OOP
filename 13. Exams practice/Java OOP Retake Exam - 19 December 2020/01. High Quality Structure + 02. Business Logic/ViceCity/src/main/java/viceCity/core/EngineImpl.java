package viceCity.core;

import viceCity.common.Command;
import viceCity.core.interfaces.Controller;
import viceCity.core.interfaces.Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
  private Controller controller;
  private BufferedReader reader;

  public EngineImpl(Controller controller) {
    this.controller = controller;
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

    switch (command) {
      case AddPlayer -> this.controller.addPlayer(data[0]);
      case AddGun -> this.controller.addGun(data[0], data[1]);
      case AddGunToPlayer -> this.controller.addGunToPlayer(data[0])
      case Fight -> this.controller.fight();
      case Exit -> result = Command.Exit.name();
    }

    return result;
  }
}
