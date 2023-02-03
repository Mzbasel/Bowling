import java.util.ArrayList;
import java.util.List;

public class ScoreCalculator {
    private final List<Character> scoreCharacters;
    private final BonusScore bonusScore = new BonusScore(this);
    private final AdditionalScore additionalScore = new AdditionalScore(this);
    private final Score scores = new Score(this);
    private char previousScore, prePreviousScore;
    public String[] rounds;
    private final char ZERO = '0';
    private int FIRST_GAME = 0;
    private int LAST_GAME = 10;


    public ScoreCalculator() {
        scoreCharacters = new ArrayList<>();
        scoreCharacters.add(ZERO);
        scoreCharacters.add(ZERO);
    }

    public List<Integer> execute(String game) {
        rounds = splitRounds(game);

        for (int index = FIRST_GAME; index < rounds.length; index++) {
            for (char score : rounds[index].toCharArray()) {
                if(index > LAST_GAME) break;
                setPreviousScore();
                setPrePreviousScore();
                scores.add(score);
                scoreCharacters.add(score);
                additionalScore.add(score);
            }
        }

        if(rounds.length > LAST_GAME){
            bonusScore.calculate();
        }
        return totalScore();
    }

    private List<Integer> totalScore() {
        List<Integer> finalScores = new ArrayList<>();
        finalScores.addAll(scores.getScores());
        finalScores.addAll(bonusScore.getScores());
        finalScores.addAll(additionalScore.getScores());
        return finalScores;
    }

    private void setPrePreviousScore(){
        prePreviousScore = scoreCharacters.get(scoreCharacters.size()-2);
    }

    private void setPreviousScore(){
        previousScore = scoreCharacters.get(scoreCharacters.size()-1);
    }
    private String[] splitRounds(String game) {
        return game.split("\\|");
    }

    public char getPreviousScore() {
        return previousScore;
    }

    public char getPrePreviousScore() {
        return prePreviousScore;
    }
}
