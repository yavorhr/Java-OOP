package fairyShop.models.helper;

import fairyShop.models.instrument.Instrument;
import fairyShop.validator.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class BaseHelper implements Helper {
  private String name;
  private int energy;
  private Collection<Instrument> instruments;

  protected BaseHelper(String name, int energy) {
    this.setName(name);
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

  protected void decreaseEnergy(int value) {
    this.energy = Math.max(this.energy - value, 0);
  }



  protected void setName(String name) {
    Validator.validateHelperName(name);
    this.name = name;
  }
}
