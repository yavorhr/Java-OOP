package enums;

public enum Season {
  SPRING(2),
  SUMMER(4),
  AUTUMN(1),
  WINTER(3);

  int multiplier;

  Season(int multiplier) {
    this.multiplier = multiplier;
  }

  public int getMultiplier() {
    return this.multiplier;
  }
}
