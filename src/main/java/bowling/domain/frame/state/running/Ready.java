package bowling.domain.frame.state.running;

import bowling.domain.frame.Score;
import bowling.domain.frame.state.State;
import bowling.domain.frame.state.finished.Strike;
import bowling.domain.turn.Pins;
import bowling.error.CannotCalculateException;

public class Ready implements State {
  private static final String EMPTY_SYMBOL = "";
  private static final int MAX_PINS = 10;

  public static State of() {
    return new Ready();
  }

  @Override
  public State bowl(Pins pins) {
    if(pins.isStrike()){
      return Strike.of();
    }
    return FirstBowl.of(pins);
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public String show() {
    return EMPTY_SYMBOL;
  }

  @Override
  public Score score() {
    throw new CannotCalculateException();
  }

  @Override
  public Score calculateLeftScores(Score leftScore) {
    return null;
  }
}
