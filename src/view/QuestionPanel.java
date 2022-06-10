package view;

import java.util.*;
import javax.swing.*;
import java.awt.*;

import model.*;

/**
 * This class creates a panel that represents all question and answering mechanics
 * within the GUI.
 */
public class QuestionPanel extends JPanel
{
    private Question myQuestion;

    private String myQuestionType;
    private Stack<String> myAnswers;

    private JTextPane myQuestionText;

    LinkedList<JRadioButton> myAnswerOptions;
    private final ButtonGroup myButtonGroup = new ButtonGroup();

    private JTextField myShortAnswerInput;

    /**
     * The default constructor sets up the panel that is a part of the larger
     * Game Board that the GUI is made up of. This sets up all of the defaults for
     * the text used in the panel and the background.
     */
    public QuestionPanel()
    {
        setLayout(null);

        this.myQuestionText = new JTextPane();
        this.myQuestionText.setBounds(50, 0, 250, 120);
        this.myQuestionText.setText("Question Text");
        myQuestionText.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        myQuestionText.setBackground(null);
        this.myQuestionText.setEditable(false);
        add(this.myQuestionText);

        myAnswerOptions = new LinkedList<JRadioButton>();
    }

    /**
     * This method initializes the question text that is displayed to the user.
     * @param theQuestion A Question object to generate the question data for the GUI from.
     */
    public void initializeQuestionData(final Question theQuestion)
    {
        this.myQuestion = theQuestion;

        cleanUpMultipleChoiceInputs();
        if (myShortAnswerInput != null)
            cleanUpShortAnswerTextbox();

        myQuestionText.setText(theQuestion.getQuestion());
        myAnswers = theQuestion.getAnswer();
        myQuestionType = theQuestion.getType().toString();

        String[] answers = null;
        System.out.println(myQuestionType);

        int size = myAnswerOptions.size();
        for (int i = 0; i < size; i++) {
            myAnswerOptions.pop().hide();
        }
        myAnswerOptions.clear();

        switch (myQuestionType)
        {
            case ("TF"):
                initializeAnswerRadios(new String[] { "True", "False" });
                break;
            case ("MC"):
                initializeAnswerRadios(new String[] { myAnswers.pop(), myAnswers.pop(),
                        myAnswers.pop(), myAnswers.pop() });
                break;
            case ("SA"):
                initializeShortAnswerTextbox();
                break;
        }
    }

    /**
     * This method initializes radio buttons for multiple choice and true/false
     * questions. A String array is passed which contains the answers to make
     * radio buttons from.
     * @param answers A String array containing String answers to make radio buttons from.
     */
    private void initializeAnswerRadios(final String[] answers)
    {
        myAnswerOptions.clear();
        for (int i = 50; i <= answers.length * 50; i += 50)
        {
            JRadioButton radioAnswer = new JRadioButton();
            radioAnswer.setText(answers[(i / 50) - 1]);
            myButtonGroup.add(radioAnswer);
            radioAnswer.setBounds(0, i + 50, 480, 50);
            radioAnswer.setVisible(true);
            radioAnswer.setSelected(false);
            myAnswerOptions.add(radioAnswer);
            add(radioAnswer);
        }
    }

    /**
     * This method initializes the JTextBox for short answer questions when called.
     */
    private void initializeShortAnswerTextbox()
    {
        myShortAnswerInput = new JTextField();
        myShortAnswerInput.setText("Type Answer Here");
        myShortAnswerInput.setBounds(50, 150, 180, 20);
        add(myShortAnswerInput);
        myShortAnswerInput.setColumns(10);
    }

    /**
     * This method is used to check if the answer checked by the user is correct by calling the
     * isCorrect() method of the Question class in the model package.
     * @return Returns a boolean true if answer is correct, false if not correct.
     */
    public boolean isAnswerCorrect()
    {
        switch (myQuestionType)
        {
            case "MC":
                return myQuestion.isCorrect(getSelectedAnswer());
            case "SA":
                return myQuestion.isCorrect(getShortAnswer());
            case "TF":
                return myQuestion.isCorrect(getSelectedAnswer());
        }
        return false;
    }

    /**
     * Getter for the myShortAnswer variable of this class. In this case the text entered
     * into the JTextBox is what is returned.
     * @return Returns the myShortAnswer variable of this class.
     */
    private String getShortAnswer()
    {
        return myShortAnswerInput.getText();
    }

    /**
     * This method is to get the text from the answer selected by the user so it can be
     * compared against the correct answer in the model package and confirmed if it is correct.
     * @return Returns the text from the radio button options, returns null if there are no options selected.
     */
    private String getSelectedAnswer()
    {
        for (JRadioButton radio : myAnswerOptions)
        {
            if (radio.isSelected())
            {
                return radio.getText();
            }
        }
        return null;
    }

    /**
     * This method is used to hide the multiple choice answers after their use has concluded.
     */
    private void cleanUpMultipleChoiceInputs()
    {
        int size = myAnswerOptions.size();
        for (int i = 0; i < size; i++)
        {
            myAnswerOptions.pop().hide();
        }
    }

    /**
     * This method is used to hide the short answer textbox after its use is concluded.
     */
    private void cleanUpShortAnswerTextbox()
    {
        this.myShortAnswerInput.hide();
    }
}
