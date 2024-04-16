package robotService.factory;


import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import validator.Validator;

public class RobotFactory {
  public static Robot create(String type, String name, String kind, double price) {
    Validator.validateRobotType(type);

    Robot robot = null;

    switch (type) {
      case "MaleRobot" -> robot = new MaleRobot(name, kind, price);
      case "FemaleRobot" -> robot = new FemaleRobot(name, kind, price);
    }

    return robot;
  }
}
