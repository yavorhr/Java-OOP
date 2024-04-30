package climbers.models.mountain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MountainImpl implements Mountain {
  private String name;
  private Collection<String> peaks;

  public MountainImpl(String name) {
    this.name = name;
    this.peaks = new ArrayList<>();
  }

  @Override
  public Collection<String> getPeaksList() {
    return Collections.unmodifiableCollection(this.peaks);
  }

  @Override
  public String getName() {
    return this.name;
  }
}
