import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)   {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        BlackBoxInt blackBoxInt;

        try {
            Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor(int.class);
            constructor.setAccessible(true);
            blackBoxInt = constructor.newInstance(0);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException ex) {
            throw new IllegalArgumentException();
        }

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("_");
            String methodName = tokens[0];
            int param = Integer.parseInt(tokens[1]);

            try {
                Method method = clazz.getDeclaredMethod(methodName, int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, param);
                Field field = clazz.getDeclaredField("innerValue");
                field.setAccessible(true);
                System.out.println(field.get(blackBoxInt));

            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
                throw new IllegalArgumentException(e);
            }

            input = scanner.nextLine();
        }
    }
}
