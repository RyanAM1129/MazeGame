package model;

public class TrueFalse extends Question{
    /**
     * A String representing the type of question.
     */
    final static String myType = "TF";

    /**
     * Constructor for Question using a given Question and Answer.
     *
     * @param theQuestion the given question.
     * @param theAnswer   the given answer.
     */
    public TrueFalse(String theQuestion, String theAnswer) {
        //Strip leading whitespace since it is one word.
        super(theQuestion, theAnswer.strip());
    }

    /**
     * Overrides super method to make case insensitive.
     * @param theGiven the given answer string.
     * @return true if the given answer is correct, false if not.
     */
    @Override
    public boolean isCorrect(final String theGiven) {
        final String lowerAnswer = getAnswer().toLowerCase();
        //Strip leading whitespace since it is one word.
        final String lowerGiven = theGiven.strip().toLowerCase();
        return lowerAnswer.equals(lowerGiven);
    }
}
