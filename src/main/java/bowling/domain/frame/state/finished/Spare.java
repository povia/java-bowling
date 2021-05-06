package bowling.domain.frame.state.finished;

import bowling.domain.frame.Score;
import bowling.domain.frame.state.State;
import bowling.domain.turn.Pins;
import bowling.error.CannotThrowBallException;

public class Spare implements State {
  private static final String SPARE_FORMAT = "%d|/";

  private final Pins firstPins;
  private final Pins secondPins;

  private Spare(Pins firstPins, Pins secondPins){
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
    return String.format(SPARE_FORMAT, firstPins.pins());
  }

  @Override
  public Score score() {
    return Score.ofSpare();
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

  public static Spare of(Pins firstPins, Pins secondPins){
    return new Spare(firstPins, secondPins);
  }
}
