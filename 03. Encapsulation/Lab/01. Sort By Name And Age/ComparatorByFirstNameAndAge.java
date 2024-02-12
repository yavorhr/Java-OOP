import java.util.Comparator;

public class ComparatorByFirstNameAndAge implements Comparator<Person> {

  @Override
  public int compare(Person firstPerson, Person secondPerson) {
    int result = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

    if (result != 0) {
      return result;
    } else {
      return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
    }

  }
}
