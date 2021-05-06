package bowling.domain.frame.state.finished;

import bowling.domain.frame.Score;
import bowling.domain.frame.state.State;
import bowling.domain.turn.Pins;
import bowling.error.CannotThrowBallException;

public class Strike implements State {
  private static final String STRIKE_SYMBOL = "X";
  private static final int STRIKE_PINS = 10;

  public static State of() {
    return new Strike();
  }

  @Override
  public State bowl(Pins pins) {
    throw new CannotThrowBallException();
  }

  @Override
  public boolean isFinished() {
    return true;
  }

  @Override
  public String show() {
    return STRIKE_SYMBOL;
  }

  @Override
  public Score score() {
    return Score.ofStrike();
  }

  @Override
  public Score calculateLeftScores(Score leftScore) {
    return leftScore.bowl(STRIKE_PINS);
  }

}
