package fairyShop.models.instrument;

import fairyShop.validator.Validator;

public class InstrumentImpl implements Instrument {
  private static final int DECREASE_UNITS_VALUE = 10;
  private int power;

  public InstrumentImpl(int power) {
    this.setPower(power);
  }

  @Override
  public int getPower() {
    return this.power;
  }

  @Override
  public void use() {
    this.power = Math.max(this.power - DECREASE_UNITS_VALUE, 0);
  }

  @Override
  public boolean isBroken() {
    return this.power == 0;
  }

  private void setPower(int power) {
    Validator.validateInstrumentPower(power);
    this.power = power;
  }
}
