package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
        Unit unit = null;

        try {
            //future proof code - можем да добавяме нови герои, без да пишем допълнителен код
            Class<?> clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
            unit = (Unit) clazz.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
        return unit;
    }
}
