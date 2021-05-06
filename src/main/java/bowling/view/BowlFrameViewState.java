package bowling.view;

public enum BowlFrameViewState {
  STRIKE("X"),
  SPARE("%d|/"),
  MISS("%d|%d"),
  FIRSTBOWL("%d");

  private final String viewType;

  BowlFrameViewState(String viewType){
    this.viewType = viewType;
  }

}
