package bowling.domain.state.finished;

import bowling.domain.GameScore;
import bowling.domain.state.State;
import bowling.domain.turn.Pins;
import bowling.error.CannotThrowBallException;

public class Miss extends State {
  private static final String MISS_SYMBOL = "%d|%d";

  private final Pins firstShot;
  private final Pins secondShot;

  public Miss(Pins firstShot, Pins secondShot) {
    this.firstShot = firstShot;
    this.secondShot = secondShot;
  }

  @Override
  public boolean isFinished() {
    return true;
  }

  public GameScore score() {
    int totalPoint = firstShot.pins() + secondShot.pins();

    return GameScore.ofMiss(totalPoint);
  }

  @Override
  public GameScore bonusScore(GameScore score) {
    return null;
  }

  @Override
  public State bowl(Pins pins) {
    throw new CannotThrowBallException();
  }

  @Override
  public String view() {
    return String.format(MISS_SYMBOL, firstShot.pins(), secondShot.pins());
  }
}
