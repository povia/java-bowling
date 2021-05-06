package bowling.domain.frame;

import bowling.domain.frame.state.State;
import bowling.domain.frame.state.running.Ready;
import bowling.domain.turn.Pins;

public class NormalFrame extends Frame {
  private static final int NEXT_FRAME_COUNT = 1;

  State state;
  Frame nextFrame;
  int round;

  public NormalFrame(int round) {
    state = Ready.of();
  }

  @Override
  public Frame bowl(Pins pins) {
    state = state.bowl(pins);
    if(state.isFinished()) {
      nextFrame = Frame.of(round+NEXT_FRAME_COUNT);
      return nextFrame;
    }
    return this;
  }

  @Override
  public boolean checkFinished() {
    return state.isFinished();
  }

  public int round() {
    return round;
  }

  @Override
  public int getScore() {
    state.score();

    return 0;
  }

  @Override
  public int calculateAdditionalScore(Score beforeScore) {
    return 0;
  }

  @Override
  public Result createResult() {
    return null;
  }
}
