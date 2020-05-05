package bowling.domain.frame;

import bowling.domain.FrameResults;
import bowling.domain.Round;
import bowling.domain.Score;
import bowling.exception.CannotBowlException;

public interface FrameNode {
  int NO_BONUS_BOWL = 0;
  int MAX_BONUS_BOWL = 2;

  static FrameNode of(Round round) {
    if (round.isFinal()) {
      return new FinalFrameNode();
    }

    return NormalFrameNode.of(round);
  }

  void addFrameResult(FrameResults frameResults);

  FrameNode getNextFrame();

  FrameNode roll(int pinCount) throws CannotBowlException;

  Score calculateBonusScore(int bonusBowlCount);

  Score calculateScore();

  boolean isFinished();

  boolean isFinalFrame();
}