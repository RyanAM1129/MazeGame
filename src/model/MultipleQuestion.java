package Question;

import org.sqlite.SQLiteDataSource;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class MultipleQuestion {

    private static final ArrayList<String> Question = new ArrayList<>();

    private static final ArrayList<String> Answer = new ArrayList<>();

    private static final ArrayList<String> Wrong = new ArrayList<>();
    String[][]WrongSet;
    private static int Number = 0;
    /*
     *
     */
    public static void getFromDatabase() {
        SQLiteDataSource ds = new SQLiteDataSource();
        ds.setUrl("jdbc:sqlite:Question.db");
        String query = "SELECT * FROM MultipleChoice";
        try (Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String question = rs.getString("Question");
                String CorrectAnswer = rs.getString("Correct");
                String theWrong1 = rs.getString("Wrong1");
                String theWrong2 = rs.getString("Wrong2");
                String theWrong3 = rs.getString("Wrong3");
                Wrong.add(theWrong1);
                Wrong.add(theWrong2);
                Wrong.add(theWrong3);
                Question.add(question);
                Answer.add(CorrectAnswer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    public static Question setQuestion() {
        return new Question(getQuestion(), getAnswer());
    }

    private static String getAnswer() {
        return Answer.get(Number);//get the exactly same number in the answer list as the question answer
    }


    private static String getQuestion() {
        return Question.get(Number);//May use another method to randomize the Number value
    }
}