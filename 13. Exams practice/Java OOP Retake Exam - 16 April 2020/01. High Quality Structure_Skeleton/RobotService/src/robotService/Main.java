package robotService;

import robotService.core.EngineImpl;
import robotService.core.interfaces.Engine;
import robotService.models.garages.interfaces.Garage;
import robotService.models.garages.interfaces.GarageImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
