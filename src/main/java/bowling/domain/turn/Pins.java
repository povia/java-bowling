package bowling.domain.turn;

import bowling.domain.frame.Score;
import bowling.error.InvalidFallenPinsException;

import java.util.Objects;

public class Pins {
  private static final String WALL_SYMBOL = "|";
  private static final String SPARE_SYMBOL = "/";
  private static final String GUTTER_SYMBOL = "-";

  private static final int MIN_PINS = 0;
  private static final int MAX_PINS = 10;

  private final int pins;

  public Pins(int pins) {
    checkPins(pins);
    this.pins = pins;
  }

  public void checkPins(int pins) {
    if (pins < MIN_PINS || pins > MAX_PINS) {
      throw new InvalidFallenPinsException();
    }
  }

  public int pins() {
    return pins;
  }

  public boolean checkAddable(Pins pins) {
    int totalFallenPins = this.pins + pins.pins;

    checkPins(totalFallenPins);
    return true;
  }

  public Pins addPins(Pins pins){
    checkAddable(pins);
    return new Pins(this.pins + pins.pins);
  }

  public Score calculateLeftScore(Score score){
    return score.bowl(pins);
  }

  public boolean isStrike() {
    return pins == MAX_PINS;
  }

  public boolean isSpare(Pins pins){
    return this.pins + pins.pins == MAX_PINS;
  }

  public boolean isMiss(Pins pins){
    return this.pins + pins.pins < MAX_PINS;
  }

  private String show(){
    if(pins == MIN_PINS){
      return GUTTER_SYMBOL;
    }
    return String.valueOf(pins);
  }

  public String show(Pins secondPins) {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder
      .append(show())
      .append(WALL_SYMBOL);

    if (isSpare(secondPins)) {
      stringBuilder
        .append(SPARE_SYMBOL);
      return stringBuilder.toString();
    }
    stringBuilder.append(secondPins.show());
    return stringBuilder.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pins pins1 = (Pins) o;
    return pins == pins1.pins;
  }

  @Override
  public int hashCode() {
    return Objects.hash(pins);
  }

  @Override
  public String toString() {
    return "FallenPins{" +
      "pins=" + pins +
      '}';
  }

}
