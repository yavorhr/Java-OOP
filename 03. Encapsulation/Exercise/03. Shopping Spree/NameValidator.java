public class NameValidator {

    public static boolean isValid(String name) {
        return name != null && !name.trim().isEmpty();
    }
}
