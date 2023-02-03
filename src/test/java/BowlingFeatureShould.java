import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingFeatureShould {

    @ParameterizedTest
    @CsvSource({"X|X|X|X|X|X|X|X|X|X||XX,300", "9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||,90", "5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5,150", "X|7/|9-|X|-8|8/|-6|X|X|X||81,167"})
    void return_the_score_of_a_given_bowling_game(String game, int expectedScore){
        ScoreCalculator scoreParser = new ScoreCalculator();
        Bowling bowling = new Bowling(scoreParser);

        int actualScore = bowling.score(game);

        assertEquals(expectedScore, actualScore);
    }
}
