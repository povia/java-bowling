package bowling.view;

import bowling.domain.frame.Frame;
import bowling.domain.frame.Round;
import bowling.domain.turn.BallRelease;
import bowling.domain.turn.Pins;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
  private static final String SCORE_TITLE = "| NAME | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 10 |";
  private static final String WALL = "|";
  private static final String BLANK = " ";
  private static final String STRIKE = "X";
  private static final String GUTTER = "-";
  private static final String SPARE = "/";

  private static final String EMPTY_ROUND = "    ";
  private static final String NAME_FORMAT = "%6s";
  private static final String NUMBER_FORMAT = "%4s";

  private static final int ZERO = 0;
  private static final int STRIKE_SHOT = 10;
  private static final int MAX_SHOT_PER_FRAME = 2;

  private static String getShotResult(int pinCount) {
    if (pinCount == STRIKE_SHOT) {
      return STRIKE;
    }

    if (pinCount == ZERO) {
      return GUTTER;
    }
    return String.valueOf(pinCount);
  }

  public void printBoard(Round round) {
    System.out.println();
    System.out.println(SCORE_TITLE);

    printName(round.playerName());

    int remainRounds = 10;
    for (Frame frame : round.frames()) {
      printFrame(frame);
      remainRounds--;
    }
    while (remainRounds-- > 0) {
      System.out.print(EMPTY_ROUND);
      System.out.print(WALL);
    }
    System.out.println();
  }

  private void printName(String name) {
    System.out.print(String.format(NAME_FORMAT, name));
    System.out.print(BLANK + WALL);
  }

  private void printFrame(Frame frame) {
    String frameScore = "";

    frameScore = frameToString(frame);

    System.out.print(String.format(NUMBER_FORMAT, frameScore));
    System.out.print(WALL);
  }

  private String frameToString(Frame frame) {
    StringBuilder stringBuilder = new StringBuilder();
    String result;

    result = frame.ballReleases().stream()
      .map(ballRelease -> ballRelease.fallenPins().pins())
      .map(ResultView::getShotResult)
      .collect(Collectors.joining(WALL));

    List<BallRelease> balls = frame.ballReleases();

    if (frame.isSpare()) {
      result = spareToString(balls);
    }

    stringBuilder.append(String.format(NUMBER_FORMAT, result));
    return stringBuilder.toString();
  }

  private String spareToString(List<BallRelease> ballReleases) {
    StringBuilder stringBuilder = new StringBuilder();
    Pins firstShot = ballReleases.get(ZERO).fallenPins();

    stringBuilder.append(firstShot.pins()).append(WALL).append(SPARE);
    if (ballReleases.size() > MAX_SHOT_PER_FRAME) {
      Pins lastPins = ballReleases.get(ballReleases.size() - 1).fallenPins();
      stringBuilder.append(WALL).append(lastPins.pins());
    }

    return stringBuilder.toString();
  }
}
