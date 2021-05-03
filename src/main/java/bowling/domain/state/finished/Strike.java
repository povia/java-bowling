package bowling.domain.state.finished;

import bowling.domain.GameScore;
import bowling.domain.state.State;
import bowling.domain.turn.Pins;
import bowling.error.CannotThrowBallException;

public class Strike extends State {
  private static final String STRIKE_SYMBOL = "X";

  @Override
  public boolean isFinished() {
    return true;
  }

  public GameScore score() {
    return GameScore.ofStrike();
  }

  @Override
  public GameScore bonusScore(GameScore score) {
    return null;
  }

  @Override
  public State bowl(Pins pins) {
    throw new CannotThrowBallException();
  }

  public String view(){
    return STRIKE_SYMBOL;
  }
}
