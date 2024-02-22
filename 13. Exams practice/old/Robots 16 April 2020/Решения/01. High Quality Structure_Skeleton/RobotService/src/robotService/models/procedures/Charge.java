package robotService.models.procedures;

import robotService.models.robots.interfaces.Robot;

public class Charge extends BaseProcedure {
    @Override
    public void doService(Robot robot, int procedureTime) {
        super.doService(robot, procedureTime);
        // adds 12 happiness and 10 energy
        int newHappiness = robot.getHappiness() + 12;
        int newEnergy = robot.getEnergy() + 10;
        robot.setHappiness(newHappiness);
        robot.setEnergy(newEnergy);

    }
}
