import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Browsable, Callable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();

        for (String url : this.urls) {
            if (Validator.invalidUrl(url)) {
                sb.append("Invalid URL!\n");

            } else {
                sb.append(String.format("Browsing: %s!\n", url));
            }
        }

        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();

        for (String number : this.numbers) {
            if (Validator.validNumber(number)) {
                sb.append(String.format("Calling... %s\n", number));
            } else {
                sb.append("Invalid number!\n");
            }
        }
        return sb.toString();
    }
}
