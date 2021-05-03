package bowling.domain.state.finished;

import bowling.domain.GameScore;
import bowling.domain.state.State;
import bowling.domain.turn.Pins;
import bowling.error.CannotThrowBallException;

public class Spare extends State {
  private static final String SPARE_SYMBOL = "%d|/";

  private final Pins firstShot;
  private final Pins secondShot;

  public Spare(Pins first, Pins second) {
    this.firstShot = first;
    this.secondShot = second;
  }

  @Override
  public boolean isFinished() {
    return true;
  }

  @Override
  public GameScore score() {
    return GameScore.ofSpare();
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
    return String.format(SPARE_SYMBOL, firstShot.pins());
  }
}
