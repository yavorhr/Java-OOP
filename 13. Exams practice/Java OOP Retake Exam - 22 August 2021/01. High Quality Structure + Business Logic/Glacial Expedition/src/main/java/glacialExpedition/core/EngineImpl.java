package glacialExpedition.core;

import glacialExpedition.common.Command;

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

    result = switch (command) {
      case AddExplorer -> this.controller.addExplorer(data[0], data[1]);
      case AddState -> this.controller.addState(data);
      case RetireExplorer -> this.controller.retireExplorer(data[0]);
      case ExploreState -> this.controller.exploreState(data[0]);
      case FinalResult -> this.controller.finalResult();
      case Exit -> Command.Exit.name();
    };

    return result;
  }

  private String[] dataLength(String[] data) {
    return data.length > 0 ? data : new String[0];
  }
}
