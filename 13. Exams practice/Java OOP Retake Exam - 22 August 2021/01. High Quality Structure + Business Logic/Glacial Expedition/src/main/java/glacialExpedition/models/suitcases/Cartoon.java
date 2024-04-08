package glacialExpedition.models.suitcases;

import java.util.Collection;

public class Cartoon implements Suitcase {
  private Collection<String> exhibits;

  public Cartoon() {
  }

  @Override
  public Collection<String> getExhibits() {
    return this.exhibits;
  }
}
