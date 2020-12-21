package bowling.domain.score;

import bowling.domain.BowlType;
import bowling.domain.point.Point;

import java.util.List;

public abstract class Score {

    protected Point firstPoint;
    protected Point secondPoint;

    protected Score(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    abstract public void pitch(Point pitchedPoint);

    abstract public boolean hasScoreTurn();

    abstract public BowlType getBowlType();

    abstract public List<Point> getPitchedPoint();

    abstract public int sumPoint();


    public int getBonusCount() {
        return getBowlType().getBonusCount();
    }
}