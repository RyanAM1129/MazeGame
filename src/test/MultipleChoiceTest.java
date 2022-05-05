package test;

import model.MultipleChoice;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class MultipleChoiceTest {
    /**
     * Builds a Multiple Choice Questions using string literal constructor.
     */
    @Test
    public void literalConstructorTest() {
        MultipleChoice testQuestion = new MultipleChoice("Is the sky Blue?",
                "Yes", "Maybe", "IDK", "Who Cares!?");
    }
    /**
     * Builds a Multiple Choice Questions using string array constructor.
     */
    @Test
    public void arrayConstructorTest() {
        String[] myArray = new String[] {"Maybe", "IDK", "Who Cares!?"};
        MultipleChoice testQuestion = new MultipleChoice("Is the sky Blue?",
                "Yes", myArray);
    }
    /**
     * Test MultipleChoice.getWrong() by checking the first element.
     */
    @Test
    public void getWrongTest() {
        String[] myArray = new String[] {"Maybe", "IDK", "Who Cares!?"};
        MultipleChoice testQuestion = new MultipleChoice("Is the sky Blue?",
                "Yes", myArray);
        String expected, actual;

        expected = myArray[0];
        actual = testQuestion.getWrong(0);
        assertEquals(expected, actual);
    }
    /**
     * Test MultipleChoice.getWrongSet().
     */
    @Test
    public void getWrongSetTest() {
        String[] myArray = new String[] {"Maybe", "IDK", "Who Cares!?"};
        MultipleChoice testQuestion = new MultipleChoice("Is the sky Blue?",
                "Yes", myArray);
        assertEquals(myArray, testQuestion.getWrongSet());
    }
}