package test;

import model.Door;
import model.DoorType;
import model.Question;
import model.QuestionType;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class DoorTest {
    Door myTestDoor;
    Question myTestQuestion;

    @Before
    public void init() {
        Stack<String> myAnswers = new Stack<>();
        myAnswers.push("Yes");
        myTestQuestion = new Question("Does Java support OOP", myAnswers, QuestionType.SA);
        myTestDoor = new Door(myTestQuestion, DoorType.VERTICAL);
    }

    @Test
    public void getQuestionTest() {
        Question expected = myTestQuestion;
        Question actual = myTestDoor.getQuestion();
        assertEquals("The Questions do not equal.", expected, actual);
    }

    @Test
    public void toStringVerticalTest() {
        String expected = "|";
        String actual = myTestDoor.toString();
        assertEquals("The Strings do not equal.", expected, actual);
    }

    @Test
    public void toStringHorizontalTest() {
        myTestDoor = new Door(myTestQuestion, DoorType.HORIZONTAL);
        String expected = "-";
        String actual = myTestDoor.toString();
        assertEquals("The Strings do not equal.", expected, actual);
    }
}
