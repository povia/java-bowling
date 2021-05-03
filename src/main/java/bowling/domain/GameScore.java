package bowling.domain;

import bowling.error.CalculatingGameScoreException;

import java.util.Objects;

public class GameScore {
  private static final int MAX_PINS = 10;
  private static final int STRIKE_ADDITIONAL = 2;
  private static final int SPARE_ADDITIONAL = 1;
  private static final int NO_ADDITIONAL = 0;

  private final int score;
  private final int left;

  public GameScore(int score, int left){
    this.score = score;
    this.left = left;
  }

  public GameScore bowl(int countOfPins){
    return new GameScore(score + countOfPins, left - 1);
  }

  public int getScore() {
    if (!canCalculateScore()) {
      throw new CalculatingGameScoreException();
    }
    return this.score;
  }

  public boolean canCalculateScore() {
    return left == 0;
  }

  public static GameScore ofMiss(int score){
    return new GameScore(score, NO_ADDITIONAL);
  }

  public static GameScore ofStrike(){
    return new GameScore(MAX_PINS, STRIKE_ADDITIONAL);
  }

  public static GameScore ofSpare(){
    return new GameScore(MAX_PINS, SPARE_ADDITIONAL);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GameScore gameScore = (GameScore) o;
    return score == gameScore.score &&
      left == gameScore.left;
  }

  @Override
  public int hashCode() {
    return Objects.hash(score, left);
  }

  @Override
  public String toString() {
    return "GameScore{" +
      "score=" + score +
      ", left=" + left +
      '}';
  }
}
