package bowling.domain.frame;

import bowling.domain.turn.Pins;
import bowling.error.CannotMakeFrameException;

public abstract class Frame {
  protected static final int LAST_FRAME = 10;

  public static Frame of(int round) {
    if (round < 1 || round > LAST_FRAME) {
      throw new CannotMakeFrameException();
    }

    if (round == LAST_FRAME) {
      return new FinalFrame();
    }

    return new NormalFrame(round);
  }

  public abstract Frame bowl(Pins pins);
  public abstract boolean checkFinished();
  public abstract int round();
  public abstract int getScore();
  public abstract int calculateAdditionalScore(Score beforeScore);
  public abstract Result createResult();
}
