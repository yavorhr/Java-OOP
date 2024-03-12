package robotService.models.garages.interfaces;

import robotService.models.robots.interfaces.Robot;

import java.util.LinkedHashMap;
import java.util.Map;

import static robotService.common.ExceptionMessages.*;

public class GarageImpl implements Garage {
    private static final int CAPACITY = 10;
    private Map<String, Robot> robots;

    public GarageImpl() {
        this.robots = new LinkedHashMap<>();
    }

    @Override
    public Map<String, Robot> getRobots() {
        return this.robots;
    }

    @Override
    public void manufacture(Robot robot) {
        if (this.robots.size() == CAPACITY) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        String robotName = robot.getName();
        if (this.robots.containsKey(robotName)) {
            throw new IllegalArgumentException(String.format(EXISTING_ROBOT, robot.getName()));
        }
        this.robots.put(robot.getName(), robot);
    }


    @Override
    public void sell(String robotName, String ownerName) {
        if (!this.robots.containsKey(robotName)) {
            throw new IllegalArgumentException(String.format(NON_EXISTING_ROBOT, robotName));
        }
        Robot robot = this.robots.get(robotName);
        robot.setOwner(ownerName);
        robot.setBought(true);
        this.robots.remove(robotName);
    }
}
