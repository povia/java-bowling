package bowling.domain.frame;

import bowling.domain.turn.Pins;

import java.util.List;

public class FinalFrame extends Frame {

  protected FinalFrame(int round) {
    super(round);
  }

  @Override
  protected void checkThrowable(Pins pins) {
    if (fallenPins.size() <= MAX_THROWABLE_BALLS && fallenPinsStatus() == MAX_FALLEN_PINS) {
      return;
    }
    super.checkThrowable(pins);
  }

  @Override
  public boolean checkFinished() {
    if (super.isStrike() || super.isSpare()) {
      return false;
    }

    return fallenPins.size() >= MAX_THROWABLE_BALLS || fallenPinsStatus() >= MAX_FALLEN_PINS;
  }

  @Override
  public boolean isStrike() {
    if (fallenPins.size() >= STRIKE_SIZE) {
      return head().isStrike();
    }
    return false;
  }

  @Override
  public boolean isSpare() {
    if (fallenPins.size() >= MAX_THROWABLE_BALLS) {
      return calculateFirstAndSecondShot(fallenPins) == MAX_FALLEN_PINS;
    }
    return super.isSpare();
  }

  private int calculateFirstAndSecondShot(List<Pins> fallenPins) {
    return fallenPins.get(0).pins() + fallenPins.get(1).pins();
  }
}
