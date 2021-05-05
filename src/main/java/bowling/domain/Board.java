package bowling.domain;

import bowling.domain.frame.Frame;
import bowling.domain.frame.PlayerBoard;

import java.util.ArrayList;
import java.util.List;

public class Board {
  private static final int FIRST_ROUND = 1;
  private static final int ROUND_ADDING_NUMBER = 1;

  private final List<PlayerBoard> playerBoards;
  private int roundNumber;

  public Board() {
    playerBoards = new ArrayList<>();
    roundNumber = FIRST_ROUND;
  }

  public void makeFirstFrame(PlayerBoard playerBoard) {
    playerBoard.add(Frame.of(roundNumber));
  }

  public void addingFrame() {
    roundNumber += ROUND_ADDING_NUMBER;
    playerBoards.stream().forEach(playerBoard -> playerBoard.add(playerBoard.tail().makeNextRound()));
  }

  public int size() {
    return playerBoards.size();
  }

  public List<PlayerBoard> rounds() {
    return playerBoards;
  }

  public int runningFrame() {
    return roundNumber;
  }

  public void addRound(Player player) {
    PlayerBoard playerBoard = new PlayerBoard(player);
    makeFirstFrame(playerBoard);
    playerBoards.add(playerBoard);
  }

  public boolean checkCurrentFrameDone() {
    long frameFinishedRounds = playerBoards.stream().filter(playerBoard -> playerBoard.checkCurrentRoundFinished()).count();
    long roundsSize = size();
    return frameFinishedRounds == roundsSize;
  }

  public boolean checkFinished() {
    long finishedCount = playerBoards.stream()
      .filter(playerBoard -> playerBoard.checkFinished())
      .count();
    long fullSize = playerBoards.size();
    return finishedCount == fullSize;
  }
}
