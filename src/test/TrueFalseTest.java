package test;

import model.TrueFalse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrueFalseTest {
    TrueFalse myTestTrueFalse = new TrueFalse("TestQuestion", "TestAnswer");

    /**
     * Tests the isCorrect() method with the same cased input.
     */
    @Test
    public void isCorrectSameCaseTest() {
        final boolean expected = true;
        final boolean actual = myTestTrueFalse.isCorrect("TestAnswer");
        assertEquals("They do not equal or the method isn't working.",
                expected, actual);
    }

    /**
     * Tests the isCorrect() method with a different cased input.
     */
    @Test
    public void isCorrectDifferentCaseTest() {
        final boolean expected = true;
        final boolean actual = myTestTrueFalse.isCorrect("testanswer");
        assertEquals("They do not equal or the method isn't working.",
                expected, actual);
    }

    /**
     * Tests the isCorrect() method with leading/trailing whitespace.
     */
    @Test
    public void isCorrectStripTest() {
        final boolean expected = true;
        final boolean actual = myTestTrueFalse.isCorrect(" TestAnswer ");
        assertEquals("They do not equal or the method isn't working.",
                expected, actual);
    }
}
