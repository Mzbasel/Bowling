import java.util.ArrayList;
import java.util.List;

public class BonusScore extends IScore {
    private final ScoreCalculator scoreCalculator;
    public List<Integer> bonusScores;

    public BonusScore(ScoreCalculator scoreCalculator) {
        super(scoreCalculator);
        this.scoreCalculator = scoreCalculator;
        bonusScores = new ArrayList<>();
    }

    private void add(char score) {
        bonusScores.add(getScore(score));
    }

    public void calculate() {
            for (int index = 0; index < lengthOfBonusScore(); index++) {
                if (scoreCalculator.getPreviousScore() == Scoring.STRIKE.type && index == 0)
                    add(getBonusScore(index));
                add(getBonusScore(index));
            }
    }

    private int lengthOfBonusScore() {
        return scoreCalculator.rounds[scoreCalculator.rounds.length - 1].length();
    }

    private char getBonusScore(int index) {
        return scoreCalculator.rounds[scoreCalculator.rounds.length - 1].toCharArray()[index];
    }

    public List<Integer> getScores(){
        return bonusScores;
    }
}