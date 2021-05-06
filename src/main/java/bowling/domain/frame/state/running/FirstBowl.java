package bowling.domain.frame.state.running;

import bowling.domain.frame.Score;
import bowling.domain.frame.state.State;
import bowling.domain.frame.state.finished.Miss;
import bowling.domain.frame.state.finished.Spare;
import bowling.domain.turn.Pins;
import bowling.error.CannotCalculateException;

public class FirstBowl implements State {
  private Pins pins;

  private FirstBowl(Pins pins){
    this.pins = pins;
  }

  public static State of(Pins pins) {
    return new FirstBowl(pins);
  }

  @Override
  public State bowl(Pins addingPins){
    if(pins.isSpare(addingPins)){
      return Spare.of(pins, addingPins);
    }

    return Miss.of(pins, addingPins);
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public String show() {
    return String.valueOf(pins.pins());
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
