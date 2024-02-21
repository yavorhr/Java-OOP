import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {

        //get reflection class
        Class<Reflection> aClass = Reflection.class;

        //print class type
        System.out.println(aClass);

        //print superClass of
        System.out.println(aClass.getSuperclass());

        //get all interfaces
        Class<?>[] interfaces = aClass.getInterfaces();

        //print interfaces
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }

        // make instance using reflection
        Reflection ref = aClass.getDeclaredConstructor().newInstance();

        //print ref.toString()
        System.out.println(ref.toString());
    }
}

