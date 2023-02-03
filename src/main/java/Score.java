import java.util.ArrayList;
import java.util.List;

public class Score extends IScore {
    private final ScoreCalculator scoreCalculator;
    private List<Integer> scores;

    public Score(ScoreCalculator scoreCalculator) {
        super(scoreCalculator);
        this.scoreCalculator = scoreCalculator;
        scores = new ArrayList<>();
    }

    public void add(char score) {
        scores.add(getScore(score));
    }

    public List<Integer> getScores() {
        return scores;
    }
}