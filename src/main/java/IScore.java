public abstract class IScore {
    protected final ScoreCalculator scoreCalculator;
    private final char ZERO = '0';

    public IScore(ScoreCalculator scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
    }

    protected int getScore(char score) {
        if (score == Scoring.SPARE.type)
            return Scoring.SPARE.value - toInteger(scoreCalculator.getPreviousScore());
        if (score == Scoring.MISS.type) return Scoring.MISS.value;
        if (score == Scoring.STRIKE.type) return Scoring.STRIKE.value;
        if (inRange(toInteger(score), 1, 9)) return toInteger(score);
        throw new UnrecognizedTypeOfScore();
    }

    private int toInteger(char number) {
        return number - ZERO;
    }

    private boolean inRange(int number, int lower, int upper) {
        return lower <= number && number <= upper;
    }
}