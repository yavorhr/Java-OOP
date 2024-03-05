public class Main {
  public static void main(String[] args) {

    SingletonPopulationCounter first = SingletonPopulationCounter.getInstance();
    SingletonPopulationCounter second = SingletonPopulationCounter.getInstance();

    first.increasePopulation("Sofia", 500);
    second.increasePopulation("Sofia", 600);

    System.out.println(second.getPopulation("Sofia"));
  }
}
