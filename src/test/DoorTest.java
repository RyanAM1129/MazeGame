package test;

import model.Door;
import model.MultipleChoice;
import model.Question;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests class for {@link Door}.
 */
public class DoorTest {
    /**
     * The Question for the Door being used.
     */
    Question myTestQuestion = new Question("Q", "A");
    /**
     * The Door being tested.
     */
    Door myTestDoor;

    /**
     * Rebuilds the Door each Test to make sure the states are "fresh".
     */
    @Before
    public void before() {
        myTestDoor = new Door(myTestQuestion);
    }

    /**
     * Tests the getQuestion() method.
     */
    @Test
    public void getQuestionTest() {
        Question myExpected = myTestQuestion;
        Question myActual = myTestDoor.getQuestion();
        assertEquals("The doors do not equal.", myExpected, myActual);
    }

    /**
     * Tests the getQuestion with a MultipleChoice.
     */
    @Test
    public void getQuestionMCTest() {
        Question myExpected = new MultipleChoice("Q", "A", "W1", "W2", "W3");
        Question myActual = myTestDoor.getQuestion();
        assertEquals("The doors do not equal.", myExpected, myActual);
    }

    /**
     * Tests the getLockStatus() method.
     */
    @Test
    public void getLockStatusTest() {
        boolean myExpected = true;
        boolean myActual = myTestDoor.getLockStatus();
        assertEquals("The status' do not equal.", myExpected, myActual);
    }

    /**
     * Tests the unlock() method.
     */
    @Test
    public void unlockTest() {
        boolean myExpected = false;
        myTestDoor.unlock();
        boolean myActual = myTestDoor.getLockStatus();
        assertEquals("The door did not unlock.", myExpected, myActual);
    }
}
