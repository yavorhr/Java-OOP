import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    MyList addCollection = new AddCollection();
    MyList addRemoveCollection = new AddRemoveCollection();
    MyList myList = new MyListImpl();

    String[] elementsToAdd = scanner.nextLine().split(" ");

    addToCollection(addCollection, elementsToAdd);
    addToCollection(addRemoveCollection, elementsToAdd);
    addToCollection(myList, elementsToAdd);

    int n = scanner.nextInt();

    printRemoved(addRemoveCollection, n);
    System.out.println();
    printRemoved(myList,  n);
  }

  private static void addToCollection(MyList addCollection, String[] elementsToAdd) {
    Arrays.stream(elementsToAdd).forEach(e -> System.out.print(addCollection.add(e) + " "));
    System.out.println();
  }

  private static void printRemoved(MyList collection, int n) {
    while (n-- > 0) {
      System.out.print(collection.remove() + " ");
    }
  }

}

