package view;

import java.util.*;
import javax.swing.*;
import java.awt.*;

import model.*;

/**
 *
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
     *
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
     *
     * @param theQuestion
     */
    public void initializeQuestionData(Question theQuestion)
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
     *
     * @param answers
     */
    private void initializeAnswerRadios(String[] answers)
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
     *
     */
    private void initializeShortAnswerTextbox()
    {
        myShortAnswerInput = new JTextField();
        myShortAnswerInput.setText("Type Answer Here");
        myShortAnswerInput.setBounds(50, 150, 180, 20);
        add(myShortAnswerInput);
        myShortAnswerInput.setColumns(10);
    }

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
     *
     * @return
     */
    private String getShortAnswer()
    {
        return myShortAnswerInput.getText();
    }

    /**
     *
     * @return
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
     *
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
     *
     */
    private void cleanUpShortAnswerTextbox()
    {
        this.myShortAnswerInput.hide();
    }
}
