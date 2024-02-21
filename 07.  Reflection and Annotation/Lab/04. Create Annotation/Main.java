import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws ClassNotFoundException {

    Class<?> reflectionClass = Class.forName("Reflection");

    Annotation[] annotations = reflectionClass.getAnnotations();

    for (Annotation a: annotations) {
      System.out.println(a);
    }
  }
}









