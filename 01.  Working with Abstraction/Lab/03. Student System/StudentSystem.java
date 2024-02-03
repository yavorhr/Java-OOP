import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
  private Map<String, Student> repo;

  public StudentSystem() {
    this.repo = new HashMap<>();
  }

  public void create(Student student) {
    if (!repo.containsKey(student.getName())) {
      repo.put(student.getName(), student);
    }
  }

  public String show(String name) {
    String result = "";
    try {
      if (this.repo.containsKey(name)) {
        Student student = this.repo.get(name);
        result = student.toString();
      }
    } catch (NullPointerException e) {
      result = (String.format("Student %s is not existing\n", name));
    }
    return result;
  }

}