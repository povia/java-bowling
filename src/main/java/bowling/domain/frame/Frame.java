package bowling.domain.frame;

import bowling.domain.turn.Pins;
import bowling.error.CannotMakeFrameException;
import bowling.error.CannotThrowBallException;

import java.util.ArrayList;
import java.util.List;

public abstract class Frame {
  protected static final int MAX_THROWABLE_BALLS = 2;
  protected static final int MAX_FALLEN_PINS = 10;
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

  public abstract Frame shot(Pins pins);

  protected abstract void checkThrowable(Pins pins);

  public abstract Frame makeNextRound();

  public abstract boolean checkFinished();

}
