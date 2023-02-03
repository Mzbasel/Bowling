import java.util.ArrayList;
import java.util.List;

public class AdditionalScore extends IScore {
    private final List<Integer> additionalScores;
    private final ScoreCalculator scoreCalculator;

    public AdditionalScore(ScoreCalculator scoreCalculator) {
        super(scoreCalculator);
        this.scoreCalculator = scoreCalculator;
        additionalScores = new ArrayList<>();
    }

    public void add(char score) {
        if (scoreCalculator.getPreviousScore() == Scoring.SPARE.type || scoreCalculator.getPreviousScore() == Scoring.STRIKE.type)
            additionalScores.add(getScore(score));
        if (scoreCalculator.getPrePreviousScore() == Scoring.STRIKE.type)
            additionalScores.add(getScore(score));
    }

    public List<Integer> getScores() {
        return additionalScores;
    }

}