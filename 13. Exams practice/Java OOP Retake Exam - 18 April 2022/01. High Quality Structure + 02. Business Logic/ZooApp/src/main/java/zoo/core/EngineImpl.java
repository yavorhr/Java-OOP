package zoo.core;

import zoo.common.Command;

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
            case AddArea -> addArea(data);
            case BuyFood -> buyFood(data);
            case FoodForArea -> foodForArea(data);
            case AddAnimal -> addAnimal(data);
            case FeedAnimal -> feedAnimal(data);
            case CalculateKg -> calculateKg(data);
            case GetStatistics -> getStatistics();
            case Exit -> Command.Exit.name();
        };
        return result;
    }
    private String addArea(String[] data) {
        //TODO
        return null;
    }

    private String buyFood(String[] data) {
        //TODO
        return null;
    }

    private String foodForArea(String[] data) {
        //TODO
        return null;
    }

    private String addAnimal(String[] data) {
        //TODO
        return null;
    }

    private String feedAnimal(String[] data) {
        //TODO
        return null;
    }

    private String calculateKg(String[] data) {
        //TODO
        return null;
    }

    private String getStatistics() {
        //TODO
        return null;
    }
}