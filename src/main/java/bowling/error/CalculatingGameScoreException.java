package bowling.error;

public class CalculatingGameScoreException extends RuntimeException {
  private static final String DEFAULT_MESSAGE = "게임 점수를 계산할 수 없습니다.";

  public CalculatingGameScoreException(){
    this(DEFAULT_MESSAGE);
  }

  public CalculatingGameScoreException(String message){
    super(message);
  }
}
