package bowling.domain.state.running;

import bowling.domain.GameScore;
import bowling.domain.state.State;
import bowling.domain.turn.Pins;
import bowling.error.CalculatingGameScoreException;

public class Ready extends State {
  private static final String EMPTY_SYMBOL = "";

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public GameScore score() {
    throw new CalculatingGameScoreException();
  }

  @Override
  public GameScore bonusScore(GameScore score) {
    throw new CalculatingGameScoreException();
  }

  @Override
  public State bowl(Pins pins) {
    return null;
  }

  @Override
  public String view() {
    return EMPTY_SYMBOL;
  }
}
