package controller;

import model.Question;
import model.QuestionType;

import java.util.Scanner;
import java.util.Stack;

/**
 * A class designed to handle the job of asking a question in a Trivia Maze Game.
 */
public class Questionnaire {
    /**
     * Displays and asks a question for a Command Line Interface.
     * @return true if the answer was correct, false if not.
     */
    public static boolean askQuestionCLI(Question theQuestion) {
        Scanner myConsole = new Scanner(System.in);
        String theAnswer = "";
        System.out.println(theQuestion.getQuestion() + "\n");
        if(theQuestion.getType() == QuestionType.MC) {
            Stack<String> myStack = theQuestion.getAnswer();
            int count = 1;
            String[] questionAnswers = new String[myStack.size()];
            while (!myStack.isEmpty()) {
                questionAnswers[count - 1] = myStack.pop();
                System.out.println("\t" + count + ". " + questionAnswers[count - 1]);
                count++;
            }
            System.out.print("\n" + "Please enter the number of your choice: ");
            theAnswer = questionAnswers[myConsole.nextInt() - 1];
        } else if(theQuestion.getType() == QuestionType.TF) {
            System.out.println("\t1. True\n\t2. False");
            int choice = myConsole.nextInt();
            if(choice >= 2) {
                choice = 2;
            } else {
                choice =1;
            }
            switch(choice) {
                case 1:
                    theAnswer = "true";
                    break;
                case 2:
                    theAnswer = "false";
            }
        } else {
            System.out.print("Please enter your answer: ");
            theAnswer = myConsole.nextLine();
        }
        return theQuestion.isCorrect(theAnswer);
    }
}
