package bowling.pitching;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.util.CollectionUtils;

import bowling.pin.Pins;
import bowling.pitching.status.PitchingResult;

public class PitchingResults {

	private static final int DEFAULT_PITCH_COUNT = 2;
	private static final int MAX_PITCH_COUNT = 3;
	private static final int KNOCKING_DOWN_MAX_COUNT_FOR_DISPLAY = 10;

	private List<PitchingResult> pitchingResults;

	private PitchingResults() {
		this.pitchingResults = new ArrayList<>();
	}

	public static PitchingResults newInstance() {
		return new PitchingResults();
	}

	public PitchingResult makeResultUsing(Pins knockingDownPins) {
		PitchingState nextPitchingState = getNextPitchingState(knockingDownPins);
		PitchingResult pitchingResult = PitchingResult.of(knockingDownPins, nextPitchingState);
		pitchingResults.add(pitchingResult);

		return pitchingResult;
	}

	private PitchingState getNextPitchingState(Pins knockingDownPins) {
		List<Pins> allKnockingDownPins = getAllKnockingDownPins();
		allKnockingDownPins.add(knockingDownPins);

		return getLastPitchingState().calculatePitchingStateUsing(allKnockingDownPins);
	}

	private List<Pins> getAllKnockingDownPins() {
		return pitchingResults.stream()
							  .map(s -> Pins.of(s.getKnockingDownPins()))
							  .collect(toList());
	}

	private PitchingState getLastPitchingState() {
		if (CollectionUtils.isEmpty(pitchingResults)) {
			return PitchingState.READY;
		}
		return pitchingResults.get(pitchingResults.size() - 1)
							  .getPitchingState();
	}

	public List<String> getKnockingDownPinsSigns() {
		return IntStream.range(0, pitchingResults.size())
						.mapToObj(i -> getPitchingStateOf(i).getKnockingDownPinsSign(getKnockingDownPinsForSign(i + 1)))
						.collect(toList());
	}

	private Pins getKnockingDownPinsForSign(int size) {
		int pinsCountForDisplay = getPinsCountForDisplay(size);
		return Pins.of(pinsCountForDisplay);
	}

	private int getPinsCountForDisplay(int size) {
		int allKnockingDownPins = IntStream.range(0, size)
										   .map(i -> pitchingResults.get(i).getKnockingDownPins())
										   .sum();
		if (allKnockingDownPins < KNOCKING_DOWN_MAX_COUNT_FOR_DISPLAY) {
			return pitchingResults.get(size - 1).getKnockingDownPins();
		}
		if (allKnockingDownPins > KNOCKING_DOWN_MAX_COUNT_FOR_DISPLAY) {
			return KNOCKING_DOWN_MAX_COUNT_FOR_DISPLAY % allKnockingDownPins;
		}
		return allKnockingDownPins;
	}

	private PitchingState getPitchingStateOf(int index) {
		return pitchingResults.get(index)
							  .getPitchingState();
	}

	public boolean isDonePitchingOfCurrentFrame() {
		return getLastPitchingState().canMoveNextFrame();
	}

	public boolean finishFinalFrame(boolean oneMorePitching) {
		int currentPitchingCount = pitchingResults.size();

		return oneMorePitching ?
				currentPitchingCount == MAX_PITCH_COUNT :
				currentPitchingCount == DEFAULT_PITCH_COUNT;
	}
}