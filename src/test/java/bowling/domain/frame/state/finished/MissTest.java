package bowling.domain.frame.state.finished;

import bowling.domain.frame.state.State;
import bowling.domain.frame.state.running.Ready;
import bowling.domain.turn.Pins;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class MissTest {

  State state;

  @BeforeEach
  void setup(){
    state = Ready.of();
    state.bowl(new Pins(7));
  }


}