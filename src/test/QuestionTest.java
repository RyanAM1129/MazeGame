package test;

import model.Question;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link Question}.
 */
public class QuestionTest {
    /**
     * The Question being tested. It has a 'Q' for its Question string,
     * and a 'A' for its Answer string.
     */
    Question myTestQuestion = new Question("Q", "A");

    /**
     * Tests the getQuestion() method.
     */
    @Test
    public void getQuestionTest() {
        String myExpected = "Q";
        String myActual = myTestQuestion.getQuestion();
        assertEquals("The Questions do not match.", myExpected, myActual);
    }

    /**
     * Tests the getAnswer() method.
     */
    @Test
    public void getAnswerTest() {
        String myExpected = "A";
        String myActual = myTestQuestion.getAnswer();
        assertEquals("The Answers do not match.", myExpected, myActual);
    }

    /**
     * Tests the isCorrect() method with a correct answer.
     */
    @Test
    public void isCorrectTrueTest() {
        boolean myExpected = true;
        boolean myActual = myTestQuestion.isCorrect("A");
        assertEquals("Either the answers didn't match or the method isn't working.",
                myExpected, myActual);
    }

    /**
     * Tests the isCorrect() method with a false answer.
     */
    @Test
    public void isCorrectFalseTest() {
        boolean myExpected = false;
        boolean myActual = myTestQuestion.isCorrect("N");
        assertEquals("Either the answers did match or the method isn't working.",
                myExpected, myActual);
    }
}