package bowling.domain.state.finished;

import bowling.domain.state.State;
import bowling.domain.turn.FallenPins;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StrikeTest {

  State state;

  @BeforeEach
  void setup(){
    state = Strike.of(new FallenPins(10));
  }

  @Test
  @DisplayName("종료 확인")
  void finishedTest(){
    Assertions.assertThat(state.isFinished()).isTrue();
  }
}