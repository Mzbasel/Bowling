import java.util.List;

public class Bowling {
    private ScoreCalculator scoreCalculator;
    private int score;

    public Bowling(ScoreCalculator scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
    }

    public int score(String game) {
        List<Integer> scores = scoreCalculator.execute(game);
        for (int round : scores) {
            score += round;
        }
        return score;
    }
}
