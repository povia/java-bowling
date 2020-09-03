package camp.nextstep.edu.rebellion.bowling.domain.score;

public class FrameScore {
    protected static final int MAX_FRAME_SCORES = 10;
    protected static final int STRIKE = 10;

    private Score first;
    private Score last;

    private FrameScore() {
        this.first = Score.of(0);
        this.last = Score.of(0);
    }

    public static FrameScore clear() {
        return new FrameScore();
    }

    public void markFirst(int hits) {
        this.first = Score.of(hits);
    }

    public void markLast(int hits) {
        checkScoreRange(hits);
        this.last = Score.of(hits);
    }

    public boolean isStrike() {
        return this.first.equals(STRIKE);
    }

    public boolean isSpare() {
        int totalScore = this.first.getHits() + this.last.getHits();
        return (this.first.getHits() > 0 && this.last.getHits() > 0) &&
                STRIKE == totalScore;
    }

    public int getFirstScore() {
        return this.first.getHits();
    }

    public int getLastScore() {
        return this.last.getHits();
    }

    private void checkScoreRange(int addedHits) {
        if (MAX_FRAME_SCORES < this.first.getHits() + addedHits) {
            throw new IllegalArgumentException("최대 10 점을 넘을 수 없습니다");
        }
    }
}