package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Board {
  private final List<Frame> frames;

  public Board(){
    frames = new ArrayList<>();
  }

  public void addFrame(Frame frame){
    frames.add(frame);
  }
}
