package bowling.domain;

import bowling.domain.frame.Frame;
import bowling.domain.frame.PlayerPanel;

import java.util.ArrayList;
import java.util.List;

public class Board {
  private static final int FIRST_ROUND = 1;
  private static final int ROUND_ADDING_NUMBER = 1;

  private final List<PlayerPanel> playerPanels;
  private int roundNumber;

  public Board() {
    playerPanels = new ArrayList<>();
    roundNumber = FIRST_ROUND;
  }

  public void makeFirstFrame(PlayerPanel playerPanel) {
    playerPanel.add(Frame.of(roundNumber));
  }

  public void addingFrame() {
    roundNumber += ROUND_ADDING_NUMBER;
    playerPanels.stream().forEach(playerPanel -> playerPanel.add(playerPanel.tail().makeNextRound()));
  }

  public int size() {
    return playerPanels.size();
  }

  public List<PlayerPanel> rounds() {
    return playerPanels;
  }

  public int runningFrame() {
    return roundNumber;
  }

  public void addRound(Player player) {
    PlayerPanel playerPanel = new PlayerPanel(player);
    makeFirstFrame(playerPanel);
    playerPanels.add(playerPanel);
  }

  public boolean checkCurrentFrameDone() {
    long frameFinishedRounds = playerPanels.stream().filter(playerPanel -> playerPanel.checkCurrentRoundFinished()).count();
    long roundsSize = size();
    return frameFinishedRounds == roundsSize;
  }

  public boolean checkFinished() {
    long finishedCount = playerPanels.stream()
      .filter(playerPanel -> playerPanel.checkFinished())
      .count();
    long fullSize = playerPanels.size();
    return finishedCount == fullSize;
  }
}
