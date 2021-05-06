package bowling.domain.frame;

import bowling.domain.Player;
import bowling.domain.turn.Pins;

import java.util.ArrayList;
import java.util.List;

public class PlayerBoard {
  private static final int ZERO = 0;
  private static final int FIRST_ROUND = 1;
  private static final int FINAL_ROUND = 10;

  private Frame currentFrame;
  private final Player player;

  public PlayerBoard(Player player) {
    currentFrame = Frame.of(FIRST_ROUND);
    this.player = player;
  }

  public Frame tail() {
    return currentFrame;
  }

  public int size() {
    return currentFrame.round();
  }

  public boolean checkCurrentRoundFinished() {
    return tail().checkFinished();
  }

  public boolean checkFinished() {
    return size() == FINAL_ROUND && tail().checkFinished();
  }

  public void addNewBall(Pins pins) {
    currentFrame = currentFrame.bowl(pins);
  }

  public String playerName() {
    return player.name();
  }
}
