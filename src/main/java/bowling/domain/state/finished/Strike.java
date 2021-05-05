package bowling.domain.state.finished;

import bowling.domain.state.State;
import bowling.domain.turn.FallenPins;
import bowling.error.CannotThrowBallException;

public class Strike implements State {

  private final FallenPins pins;

  private Strike(FallenPins fallenPins){
    this.pins = fallenPins;
  }

  public static State of(FallenPins fallenPins) {
    return new Strike(fallenPins);
  }

  @Override
  public boolean isFinished() {
    return true;
  }

  @Override
  public State bowl(FallenPins pins) {
    throw new CannotThrowBallException();
  }

  @Override
  public String show() {
    return pins.show();
  }
}