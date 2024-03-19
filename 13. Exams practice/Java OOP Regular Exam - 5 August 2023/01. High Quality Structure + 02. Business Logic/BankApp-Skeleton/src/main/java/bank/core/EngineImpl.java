package bank.core;

import bank.common.Command;

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

        if (result.equals("End")) {
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
      case AddBank:
        result = this.controller.addBank(data[0], data[1]);
        break;
      case AddLoan:
        result = this.controller.addLoan(data[0]);
        break;
      case ReturnedLoan:
        result = this.controller.returnedLoan(data[0], data[1]);
        break;
      case AddClient:
        result = this.controller.addClient(data[0], data[1], data[2], data[3],Double.parseDouble(data[4]));
        break;
      case FinalCalculation:
        result = this.controller.finalCalculation(data[0]);
        break;
      case Statistics:
        result = this.controller.getStatistics();
        break;
      case End:
        result = Command.End.name();
        break;
    }
    return result;
  }
}

