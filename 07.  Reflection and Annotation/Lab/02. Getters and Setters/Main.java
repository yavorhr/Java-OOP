import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {

    public static class MethodComparatorByName implements Comparator<Method> {

        @Override
        public int compare(Method f, Method s) {
            return f.getName().compareTo(s.getName());
        }
    }

    public static void main(String[] args) throws
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException, ClassNotFoundException {

        Class<?> reflection = Class.forName("Reflection");
        Method[] declaredMethods = reflection.getDeclaredMethods();

        Set<Method> getters = new TreeSet<>(new MethodComparatorByName());
        Set<Method> setters = new TreeSet<>(new MethodComparatorByName());

        for (Method method : declaredMethods) {
            if (startsWith(method, "get")
                    && !checkIfParams(method.getParameterCount())
                    && !chekReturnType(method.getReturnType())) {
                getters.add(method);
            } else if (startsWith(method, "set")
                    && checkIfParams(method.getParameterCount())
                    && chekReturnType(method.getReturnType())) {
                setters.add(method);
            }
        }

        System.out.println(getters.
                stream().
                map(g -> String.format("%s will return class %s",
                        g.getName(),
                        g.getReturnType().getName().replace("class", "")))
                .collect(Collectors.joining(System.lineSeparator())));

        System.out.println(setters.
                stream().
                map(s -> String.format("%s will set field of class %s",
                        s.getName(),
                        s.getParameterTypes()[0].getName().replace("class", "")))
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private static boolean chekReturnType(Class<?> returnType) {
        return returnType == void.class;
    }

    private static boolean checkIfParams(int parameterCount) {
        return parameterCount > 0;
    }

    private static boolean startsWith(Method method, String getOrSet) {
        return method.getName().startsWith(getOrSet);
    }


}

