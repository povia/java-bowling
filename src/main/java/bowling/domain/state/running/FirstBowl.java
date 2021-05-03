package bowling.domain.state.running;

import bowling.domain.GameScore;
import bowling.domain.state.State;
import bowling.domain.state.finished.Miss;
import bowling.domain.state.finished.Spare;
import bowling.domain.turn.Pins;

public class FirstBowl extends State{
  private Pins firstShot;

  FirstBowl(Pins pins) {
    this.firstShot = pins;
  }

  public State bowl(int countOfPin) {
    Pins pins = new Pins(countOfPin);
    if (firstShot.isSpare(pins)) {
      return new Spare(firstShot, pins);
    }

    return new Miss(firstShot, pins);
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  public GameScore score() {
    return null;
  }

  @Override
  public GameScore bonusScore(GameScore score) {
    score = firstShot.addScore(score);
    return score;
  }

  @Override
  public State bowl(Pins pins) {
    firstShot.checkAddable(pins);
    return null;
  }

  @Override
  public String view() {
    return String.valueOf(firstShot.pins());
  }
}
