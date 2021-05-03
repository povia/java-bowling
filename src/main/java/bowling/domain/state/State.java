package bowling.domain.state;

import bowling.domain.GameScore;
import bowling.domain.turn.Pins;

public abstract class State {
  public abstract boolean isFinished();
  public abstract GameScore score();
  public abstract GameScore bonusScore(GameScore score);
  public abstract State bowl(Pins pins);
  public abstract String view();
}
