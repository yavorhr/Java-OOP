import java.util.HashMap;
import java.util.Map;

public class SingletonPopulationCounter implements SingletonContainer {
  private Map<String, Integer> populationMap;
  private static SingletonPopulationCounter instance;

  private SingletonPopulationCounter() {
    this.populationMap = new HashMap<>();
  }

  public static SingletonPopulationCounter getInstance() {
    // Lazy Loading
    if (instance != null) {
      return instance;
    }
    return instance = new SingletonPopulationCounter();
  }

  public void increasePopulation(String city, int newPopulation) {
    this.populationMap.putIfAbsent(city, 0);
    this.populationMap.put(city, this.populationMap.get(city) + newPopulation);
  }

  public void decreasePopulation(String city, int newPopulation) {
    this.populationMap.put(city, this.populationMap.get(city) - newPopulation);
  }

  @Override
  public int getPopulation(String city) {
    return this.populationMap.get(city);
  }
}
