package bowling.controller;

import bowling.domain.Board;
import bowling.domain.Player;
import bowling.domain.frame.Frame;
import bowling.domain.frame.PlayerBoard;
import bowling.domain.turn.Pins;
import bowling.view.InputView;
import bowling.view.ResultView;

public class BowlingGame {
  private final InputView inputView;
  private final ResultView resultView;
  private final Board board;


  public BowlingGame() {
    inputView = new InputView();
    resultView = new ResultView();
    board = new Board();
  }

  public void run() {
    Player player = new Player(inputView.setupPlayer());
    board.addRound(player);
    playGame();
  }

  private void playGame() {
    while (!board.checkFinished()) {
      playRound(board);
    }
  }

  private void playRound(Board board) {
    for (PlayerBoard playerBoard : board.rounds()) {
      playFrame(playerBoard);
    }
  }

  private void playFrame(PlayerBoard playerBoard) {
    Frame tailFrame = playerBoard.tail();
    if (!tailFrame.checkFinished()) {
      int fallenPins = inputView.setupPins(tailFrame.round());
      playerBoard.addNewBall(new Pins(fallenPins));
      resultView.printBoard(playerBoard);
    }
  }

}
