package bowling.domain.frame;

import bowling.domain.Player;
import bowling.domain.turn.Pins;

import java.util.ArrayList;
import java.util.List;

public class PlayerPanel {
  private static final int ZERO = 0;
  private static final int FINAL_ROUND = 10;

  private final List<Frame> frames;
  private final Player player;

  public PlayerPanel(Player player) {
    frames = new ArrayList<>();
    this.player = player;
  }

  public List<Frame> frames() {
    return frames;
  }

  public void add(Frame frame) {
    frames.add(frame);
  }

  public Frame tail() {
    return frames.get(frames.size() - 1);
  }

  public int size() {
    return frames.size();
  }

  public boolean isEmpty() {
    return frames.size() == ZERO;
  }

  public boolean checkCurrentRoundFinished() {
    return tail().checkFinished();
  }

  public boolean checkFinished() {
    return size() == FINAL_ROUND && tail().checkFinished();
  }

  public void addNewBall(Pins pins) {
    Frame frame = tail();
    frame.shot(pins);
  }

  public String playerName() {
    return player.name();
  }
}
