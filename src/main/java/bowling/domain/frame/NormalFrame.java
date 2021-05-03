package bowling.domain.frame;

import bowling.domain.state.State;
import bowling.domain.state.running.Ready;
import bowling.domain.turn.Pins;

public class NormalFrame extends Frame {
  private static final int ADDING_ROUND_NUMBER = 1;

  private Frame nextFrame;
  private State state;
  private int round;

  protected NormalFrame(int round) {
    state = new Ready();
    this.round = round;
  }

  @Override
  public Frame shot(Pins pins) {
    if(state.isFinished()){
      return Frame.of(round+ADDING_ROUND_NUMBER);
    }

    return this;
  }

  @Override
  // TODO
  protected void checkThrowable(Pins pins) {
//    super.checkThrowable(pins);
  }

  @Override
  // TODO
  public Frame makeNextRound() {
    return null;
  }

  @Override
  public boolean checkFinished() {
    return state.isFinished();
  }

  public Frame nextFrame(){
    return nextFrame;
  }

}
