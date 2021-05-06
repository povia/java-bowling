package bowling.domain.frame.state.finished;

import bowling.domain.frame.Score;
import bowling.domain.frame.state.State;
import bowling.domain.turn.Pins;
import bowling.error.CannotThrowBallException;

public class Miss implements State {

  private final Pins firstPins;
  private final Pins secondPins;

  private Miss(Pins firstPins, Pins secondPins){
    this.firstPins = firstPins;
    this.secondPins = secondPins;
  }

  @Override
  public State bowl(Pins pins) {
    throw new CannotThrowBallException();
  }

  @Override
  public boolean isFinished() {
    return true;
  }

  @Override
  public String show() {
    return firstPins.show(secondPins);
  }

  @Override
  public Score score() {
    return Score.ofMiss(firstPins.addPins(secondPins));
  }

  @Override
  public Score calculateLeftScores(Score leftScore) {
    leftScore = firstPins.calculateLeftScore(leftScore);

    if(leftScore.canCalculateScore()){
      return leftScore;
    }

    leftScore = secondPins.calculateLeftScore(leftScore);
    return leftScore;
  }

  public static Miss of(Pins firstPins, Pins secondPins){
    return new Miss(firstPins, secondPins);
  }
}
