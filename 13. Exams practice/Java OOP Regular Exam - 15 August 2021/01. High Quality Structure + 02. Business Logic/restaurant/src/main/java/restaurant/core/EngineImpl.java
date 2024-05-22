package restaurant.core;

import restaurant.common.enums.Commands;
import restaurant.core.interfaces.Controller;
import restaurant.core.interfaces.Engine;
import restaurant.io.ConsoleReader;
import restaurant.io.ConsoleWriter;

import java.io.IOException;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private ConsoleReader reader;
    private ConsoleWriter writer;
    private Controller controller;

    public EngineImpl(ConsoleReader reader, ConsoleWriter writer, Controller controller) {
        this.reader = reader;
        this.writer = writer;
        this.controller = controller;
    }

    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Commands.END.name())) {
                    break;
                }

            } catch (IOException | IllegalArgumentException | NullPointerException e) {
                result = e.getMessage();
            }
            this.writer.writeLine(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Commands command = Commands.valueOf(tokens[0]);
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        String result = switch (command) {
            case addHealthyFood -> this.controller.addHealthyFood(
                    data[0], Double.parseDouble(data[1]), data[2]
            );
            case addBeverage -> this.controller.addBeverage(
                    data[0], Integer.parseInt(data[1]), data[2], data[3]
            );
            case addTable -> this.controller.addTable(
                    data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2])
            );
            case reserve -> this.controller.reserve(Integer.parseInt(data[0]));
            case orderHealthyFood -> this.controller.orderHealthyFood(Integer.parseInt(data[0]), data[1]);
            case orderBeverage -> this.controller.orderBeverage(Integer.parseInt(data[0]), data[1], data[2]);
            case closedBill -> this.controller.closedBill(Integer.parseInt(data[0]));
            case totalMoney -> this.controller.totalMoney();
            case END -> Commands.END.name();
        };

        return result.trim();
    }

}
