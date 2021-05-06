package bowling.domain.frame.state.running;

import bowling.domain.frame.state.State;
import bowling.domain.frame.state.finished.Miss;
import bowling.domain.frame.state.finished.Spare;
import bowling.domain.turn.Pins;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


class FirstBowlTest {

  @ParameterizedTest
  @ValueSource(ints = {0,1,2,3,4,5,6,7,8,9})
  @DisplayName("첫 공을 던졌을 때의 상태로 변경할 수 있다.")
  void moveStateFromReadyTest(int number){
    State ready = Ready.of();

    Pins pins = new Pins(number);
    Assertions.assertThat(ready.bowl(pins)).isInstanceOf(FirstBowl.class);
  }

  @ParameterizedTest
  @ValueSource(ints = 10)
  @DisplayName("스트라이크는 이곳에 들어올 수 없다")
  void strikeIsInvalidHereTest(int pins){
    State ready = Ready.of();
    Pins addingPins = new Pins(pins);

    Assertions.assertThat(ready.bowl(addingPins)).isNotInstanceOf(FirstBowl.class);
  }

  @ParameterizedTest
  @CsvSource(value = {"8,2", "7,3"})
  @DisplayName("스페어 처리했을 경우 Spare로 상태 변경 테스트")
  void moveToSpareTest(int bowlA, int bowlB){
    State state = Ready.of();
    State finalState = state.bowl(new Pins(bowlA)).bowl(new Pins(bowlB));

    Assertions.assertThat(finalState).isInstanceOf(Spare.class);
  }

  @ParameterizedTest
  @CsvSource(value = {"8,0", "7,1"})
  @DisplayName("스페어 처리못할 경우 Miss로 상태 변경 테스트")
  void moveToMissTest(int bowlA, int bowlB){
    State state = Ready.of();
    State finalState = state.bowl(new Pins(bowlA)).bowl(new Pins(bowlB));

    Assertions.assertThat(finalState).isInstanceOf(Miss.class);
  }
}