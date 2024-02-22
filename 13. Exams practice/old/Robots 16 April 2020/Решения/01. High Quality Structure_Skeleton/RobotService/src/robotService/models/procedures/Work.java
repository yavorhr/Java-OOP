package robotService.models.procedures;

import robotService.models.robots.interfaces.Robot;

public class Work extends BaseProcedure {
    @Override
    public void doService(Robot robot, int procedureTime) {
        super.doService(robot, procedureTime);
        //removes 6 energy and adds 12 happiness
        int newEnergy = robot.getEnergy() - 6;
        int newHappiness = robot.getHappiness() + 12;
        robot.setEnergy(newEnergy);
        robot.setHappiness(newHappiness);

    }
}
