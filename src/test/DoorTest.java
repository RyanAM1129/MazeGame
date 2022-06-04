package test;

import model.Door;
import model.DoorType;
import model.Question;
import model.QuestionType;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Tests the methods of the Door Class.
 */
public class DoorTest {
    /**
     * The door used for testing.
     */
    Door myTestDoor;
    /**
     * The question used for testing.
     */
    Question myTestQuestion;

    /**
     * Initializes all test fields.
     * Makes the question "Does Java support OOP".
     * Makes the correct answer "Yes".
     * Makes the door type Vertical.
     */
    @Before
    public void init() {
        Stack<String> myAnswers = new Stack<>();
        myAnswers.push("Yes");
        myTestQuestion = new Question("Does Java support OOP", myAnswers, QuestionType.SA);
        myTestDoor = new Door(myTestQuestion, DoorType.VERTICAL);
    }

    /**
     * Tests the getQuestion method.
     */
    @Test
    public void getQuestionTest() {
        Question expected = myTestQuestion;
        Question actual = myTestDoor.getQuestion();
        assertEquals("The Questions do not equal.", expected, actual);
    }

    /**
     * Tests the toString() method for vertical doors.
     */
    @Test
    public void toStringVerticalTest() {
        String expected = "|";
        String actual = myTestDoor.toString();
        assertEquals("The Strings do not equal.", expected, actual);
    }

    /**
     * Tests the toString() method for horizontal doors.
     */
    @Test
    public void toStringHorizontalTest() {
        myTestDoor = new Door(myTestQuestion, DoorType.HORIZONTAL);
        String expected = "-";
        String actual = myTestDoor.toString();
        assertEquals("The Strings do not equal.", expected, actual);
    }
}
