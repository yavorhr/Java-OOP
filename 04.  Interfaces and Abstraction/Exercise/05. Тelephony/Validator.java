import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
  public static boolean validNumber(String number) {
    Pattern pattern = Pattern.compile("^[0-9]+$");
    Matcher matcher = pattern.matcher(number);

    return matcher.find();
  }

  public static boolean invalidUrl(String url) {
    Pattern pattern = Pattern.compile("[0-9]");
    Matcher matcher = pattern.matcher(url);

    return matcher.find();
  }
}
