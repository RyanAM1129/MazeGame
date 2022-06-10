package test;

import model.Question;
import model.QuestionType;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Tests the methods of the Question Class.
 */
public class QuestionTest {
    /**
     * The question String used for testing.
     */
    String questionString;
    /**
     * The Stack of answers Strings used for testing.
     */
    Stack<String> answerStrings;
    /**
     * The Question used for testing.
     */
    Question testQuestion;

    /**
     * Initializes the Question with the question "Test Question",
     * the answer "Test Answer", and the type SA.
     */
    @Before
    public void init() {
        questionString = "Test Question";
        answerStrings = new Stack<>();
        answerStrings.push("Test Answer");
        testQuestion = new Question(questionString, answerStrings, QuestionType.SA);
    }

    /**
     * Tests the getAnswer() method.
     */
    @Test
    public void getAnswerTest() {
        String expected = answerStrings.peek();
        String actual = testQuestion.getAnswer().peek();
        assertEquals("The strings do not equal", expected, actual);
    }

    /**
     * Tests the getQuestion() method.
     */
    @Test
    public void getQuestionTest() {
        String expected = questionString;
        String actual = testQuestion.getQuestion();
        assertEquals("The strings do not equal", expected, actual);
    }

    /**
     * Tests the isCorrect() method with a true result.
     */
    @Test
    public void isCorrectTrueTest() {
        boolean expected = true;
        boolean actual = testQuestion.isCorrect("Test Answer");
        assertEquals("The strings do not equal", expected, actual);
    }

    /**
     * Tests the isCorrect() method with a false result.
     */
    @Test
    public void isCorrectFalseTest() {
        boolean expected = false;
        boolean actual = testQuestion.isCorrect("Not Test Answer");
        assertEquals("The strings do equal", expected, actual);
    }

    /**
     * Tests the getType() method with a SA result.
     */
    @Test
    public void getTypeTest() {
        QuestionType expected = QuestionType.SA;
        QuestionType actual = testQuestion.getType();
        assertEquals("The types do not equal", expected, actual);
    }
}
