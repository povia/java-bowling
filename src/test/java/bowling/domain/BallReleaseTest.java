//package bowling.domain;
//
//import bowling.domain.turn.BallRelease;
//import bowling.domain.turn.Pins;
//import bowling.error.InvalidFallenPinsException;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//class BallReleaseTest {
//
//  @ParameterizedTest
//  @CsvSource(value = {"1,9", "2,8"})
//  @DisplayName("두 번째 샷 추가 확인")
//  void addingOtherPinCheckTest(int firstShotPins, int secondShotPins) {
//    Pins firstShot = new Pins(firstShotPins);
//    Pins secondShot = new Pins(secondShotPins);
//
//    BallRelease ballRelease = new BallRelease(firstShot);
//
//    assertThat(ballRelease.checkAddable(secondShot)).isEqualTo(true);
//  }
//
//  @ParameterizedTest
//  @CsvSource(value = {"1,10", "2,9"})
//  @DisplayName("두 번째 샷 추가 실패")
//  void invalidAddingTest(int firstShotPins, int secondShotPins) {
//    Pins firstShot = new Pins(firstShotPins);
//    Pins secondShot = new Pins(secondShotPins);
//
//    BallRelease ballRelease = new BallRelease(firstShot);
//
//    assertThatThrownBy(() -> ballRelease.checkAddable(secondShot))
//      .isInstanceOf(InvalidFallenPinsException.class);
//  }
//}