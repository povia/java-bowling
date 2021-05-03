package bowling.controller;

import bowling.domain.Board;
import bowling.domain.Player;
import bowling.domain.frame.Frame;
import bowling.domain.frame.PlayerPanel;
import bowling.domain.turn.Pins;
import bowling.view.InputView;
import bowling.view.ResultView;

public class BowlingBoard {
  private static final int FIRST_ROUND = 1;

  private final InputView inputView;
  private final ResultView resultView;
  private final Board board;


  public BowlingBoard() {
    inputView = new InputView();
    resultView = new ResultView();
    board = new Board();
  }

  public void run() {
    Player player = new Player(inputView.setupPlayer());
    board.addRound(player);
    playGame();
  }

  // TODO
  private void playGame() {
//    while (!board.checkFinished()) {
//      playFrame(board);
//    }
  }

  private void playRound(Board board) {
    checkAndAddingFrame();
    for (PlayerPanel playerPanel : board.rounds()) {
      playFrame(playerPanel);
    }
  }

  private void playFrame(PlayerPanel playerPanel) {
    Frame tailFrame = playerPanel.tail();
    if (!tailFrame.checkFinished()) {
      int fallenPins = inputView.setupPins(board.runningFrame());
      playerPanel.addNewBall(new Pins(fallenPins));
      resultView.printBoard(playerPanel);
    }
  }

  private void checkAndAddingFrame() {
    if (board.checkCurrentFrameDone()) {
      board.addingFrame();
    }
  }
}
