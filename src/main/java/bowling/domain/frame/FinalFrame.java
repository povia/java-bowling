package bowling.domain.frame;

import bowling.domain.frame.state.State;
import bowling.domain.turn.Pins;

import java.util.LinkedList;
import java.util.List;

public class FinalFrame extends Frame {
  LinkedList<State> states;

  protected FinalFrame() {
    states = new LinkedList<>();
  }

  @Override
  public Frame bowl(Pins pins) {
    return null;
  }

  @Override
  public boolean checkFinished() {
    return false;
  }

  @Override
  public int round() {
    return 10;
  }

  @Override
  public int getScore() {

    for(int i = 1; i< states.size(); i++){

    }
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
