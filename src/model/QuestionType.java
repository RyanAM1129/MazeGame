package model;

/**
 * Used to keep track of types of Question.
 */
public enum QuestionType {
    /**
     * Short Answer.
     */
    SA {
        @Override
        public String toString() {
            return "SA";
        }
    },
    /**
     * True False.
     */
    TF{
        @Override
        public String toString() {
            return "TF";
        }
    },
    /**
     * Multiple Choice.
     */
    MC{
        @Override
        public String toString() {
            return "MC";
        }
    }
}
