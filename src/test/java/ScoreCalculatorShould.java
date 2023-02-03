import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreCalculatorShould {

    private ScoreCalculator scoreParser;
    private String game;
    private List<Integer> expectedScores, actualScores;

    @BeforeEach
    void setUp(){
        scoreParser = new ScoreCalculator();
        expectedScores = new ArrayList<>();
        actualScores = new ArrayList<>();
    }

    @Test
    void convert_number_scores() {
        game = "1|1";
        expectedScores = List.of(1,1);

        actualScores = scoreParser.execute(game);

        assertEquals(expectedScores, actualScores);
    }

    @Test
    void convert_two_plays_in_two_rounds() {
        game = "14|23";
        expectedScores = List.of(1,4,2,3);

        actualScores = scoreParser.execute(game);

        assertEquals(expectedScores, actualScores);
    }

    @Test
    void convert_non_scored_play(){
        String game = "-";
        expectedScores = List.of(0);

        actualScores = scoreParser.execute(game);

        assertEquals(expectedScores, actualScores);
    }

    @Test
    void convert_a_game_score_with_number_scores_and_non_scores_combined(){
        String game = "-7|1-";
        expectedScores = List.of(0,7,1,0);

        actualScores = scoreParser.execute(game);

        assertEquals(expectedScores, actualScores);
    }

    @Test
    void convert_a_spare() {
        String game = "2/|72";
        expectedScores = List.of(2,8,7,2,7);

        actualScores = scoreParser.execute(game);

        assertEquals(expectedScores, actualScores);
    }

    @Test
    void convert_a_strike() {
        String game = "X|23";
        expectedScores = List.of(10,2,3,2,3);

        actualScores = scoreParser.execute(game);

        assertEquals(expectedScores, actualScores);
    }
}