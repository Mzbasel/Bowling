import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class BowlingShould {

    private Bowling bowling;
    private String game;
    @Mock
    private ScoreCalculator scoreCalculator;

    @BeforeEach
    void setUp(){
        bowling = new Bowling(scoreCalculator);
    }

    @Test
    void calculate_the_score_of_an_non_scored_game() {
        game = "-";
        int expectedScore = 0;
        given(scoreCalculator.execute(game)).willReturn(List.of(0));

        int actualScore = bowling.score(game);

        assertEquals(expectedScore, actualScore);
    }

    @Test
    void calculate_the_score_of_one_round_game() {
        game = "1";
        int expectedScore = 1;
        given(scoreCalculator.execute(game)).willReturn(List.of(1));

        int actualScore = bowling.score(game);

        assertEquals(expectedScore, actualScore);
    }

    @Test
    void calculate_the_score_of_two_round_game() {
        game = "1|1";
        int expectedScore = 2;
        List<Integer> scores = List.of(1,1);

        given(scoreCalculator.execute(game)).willReturn(scores);

        int actualScore = bowling.score(game);

        assertEquals(expectedScore, actualScore);
    }
}