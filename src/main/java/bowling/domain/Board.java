package bowling.domain;

import bowling.domain.frame.Frame;
import bowling.domain.frame.PlayerBoard;

import java.util.ArrayList;
import java.util.List;

public class Board {
  private static final int ROUND_ADDING_NUMBER = 1;

  private final List<PlayerBoard> playerBoards;

  public Board() {
    playerBoards = new ArrayList<>();
  }

  public int size() {
    return playerBoards.size();
  }

  public List<PlayerBoard> rounds() {
    return playerBoards;
  }

  public void addRound(Player player) {
    PlayerBoard playerBoard = new PlayerBoard(player);
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
