package bowling.domain.frame.state;

import bowling.domain.frame.Score;
import bowling.domain.turn.Pins;

public interface State {
  State bowl(Pins pins);
  boolean isFinished();
  String show();
  Score score();
  Score calculateLeftScores(Score leftScore);
}
