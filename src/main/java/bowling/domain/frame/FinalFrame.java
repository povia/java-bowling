package bowling.domain.frame;

import bowling.domain.GameScore;
import bowling.domain.state.State;
import bowling.domain.state.running.Ready;
import bowling.domain.turn.Pins;

import java.util.LinkedList;

public class FinalFrame extends Frame {

  private LinkedList<State> states;

  public FinalFrame(){
    states = new LinkedList<>();
    states.add(new Ready());
  }


  @Override
  // TODO
  public Frame shot(Pins pins) {
    checkThrowable(pins);
//    ballReleases.add(new BallRelease(pins));
//    return ballReleases;
    return null;
  }

  @Override
  // TODO
  protected void checkThrowable(Pins pins) {
    currentState().isFinished();
//    super.checkThrowable(pins);
  }

  @Override
  // TODO
  public Frame makeNextRound() {
    return null;
  }

  @Override
  // TODO
  public boolean checkFinished() {
//    GameScore score =
//
//    return ballReleases.size() >= MAX_THROWABLE_BALLS || fallenPinsStatus() >= MAX_FALLEN_PINS;
    return false;
  }

  public GameScore calcScore() {
    GameScore score = states.getFirst().score();
    for (int i = 1; i < states.size(); i++) {
      score = states.get(i).bonusScore(score);
    }
    return score;
  }

  private State currentState(){
    return states.getLast();
  }
  // TODO
//  private int calculateFirstAndSecondShot(List<BallRelease> ballReleases) {
//    return ballReleases.get(0).fallenPins().pins() + ballReleases.get(1).fallenPins().pins();
//  }
}
