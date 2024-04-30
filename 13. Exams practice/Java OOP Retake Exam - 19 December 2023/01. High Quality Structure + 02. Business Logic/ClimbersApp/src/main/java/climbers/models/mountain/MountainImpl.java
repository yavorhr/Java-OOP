package climbers.models.mountain;

import climbers.validation.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MountainImpl implements Mountain {
  private String name;
  private Collection<String> peaks;

  public MountainImpl(String name) {
    this.setName(name);
    this.peaks = new ArrayList<>();
  }

  @Override
  public Collection<String> getPeaksList() {
    return this.peaks;
  }

  @Override
  public String getName() {
    return this.name;
  }

  private void setName(String name) {
    Validator.validateMountainName(name);
    this.name = name;
  }
}
