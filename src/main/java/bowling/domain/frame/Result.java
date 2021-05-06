package bowling.domain.frame;

public class Result {
  private final int score;
  private final String view;
  private final int additionalScore;

  private Result(int score, String view){
    this.score = score;
    this.view = view;
    additionalScore = 0;
  }

  private Result(int score, String view, int additionalScore){
    this.score = score;
    this.view = view;
    this.additionalScore = additionalScore;
  }

  public Result addResult(int score, String view){
    return new Result(score, view);
  }

  public Result addAdditionalScore(int additionalScore){
    return new Result(score, view, additionalScore);
  }
}
