import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //по-бърз е от scanner.nextLine();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;
        List<Field> fields = Arrays.asList(richSoilLandClass.getDeclaredFields());

        //за да не печатаме всеки път в while(), копираме резултата от API в StringBuilder();
        StringBuilder output = new StringBuilder();

        String input = reader.readLine();
        while (!input.equals("HARVEST")) {
            String modifier = input;

            fields
                    .stream()
                    .filter(f -> Modifier.toString(f.getModifiers()).equals(modifier)
                            || modifier.equals("all"))
                    .forEach(f -> output.append(String.format("%s %s %s%n",
                            Modifier.toString(f.getModifiers()),
                            f.getType().getSimpleName(),
                            f.getName())));

            input = reader.readLine();
        }
        System.out.print(output);
    }
}
