package glacialExpedition.models.states;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StateImpl implements State {
  private String name;
  private Collection<String> exhibits;

  public StateImpl(String name, List<String> exhibits) {
    this.name = name;
    this.exhibits = exhibits;
  }

  @Override
  public Collection<String> getExhibits() {
    return this.exhibits;
  }

  @Override
  public String getName() {
    return this.name;
  }
}
