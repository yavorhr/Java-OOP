package fairyShop.models.helper;

import fairyShop.models.instrument.Instrument;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class BaseHelper implements Helper {
  private String name;
  private int energy;
  private Collection<Instrument> instruments;

  protected BaseHelper(String name, int energy) {
    this.name = name;
    this.energy = energy;
    this.instruments = new ArrayList<>();
  }

  @Override
  public void addInstrument(Instrument instrument) {
    this.instruments.add(instrument);
  }

  @Override
  public boolean canWork() {
    return this.energy > 0;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getEnergy() {
    return this.energy;
  }

  @Override
  public Collection<Instrument> getInstruments() {
    return Collections.unmodifiableCollection(this.instruments);
  }
}
