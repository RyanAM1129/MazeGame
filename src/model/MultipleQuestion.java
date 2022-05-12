package Question;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


public class MultipleQuestion {
    private Queue<Question> questions = new LinkedList<Question>();;
    private int size;
    SQLiteDataSource ds;

    private Queue<Question> getQuestionFromDatabase() {
        ds = new SQLiteDataSource();
        ds.setUrl("jdbc:sqlite:Question.db");
        String query = "SELECT * FROM MultipleChoice";
        size = getQuestionLength();
        Question[] questionList = new Question[size];
        try (Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                String question = rs.getString("Question");
                String CorrectAnswer = rs.getString("Correct");
                String theWrong1 = rs.getString("Wrong1");
                String theWrong2 = rs.getString("Wrong2");
                String theWrong3 = rs.getString("Wrong3");
                questionList[i] = new MultipleChoice(question, CorrectAnswer, theWrong1, theWrong2, theWrong3);
                i++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        Collections.addAll(questions, questionList);
        return questions;
    }
    /*
     *get the size of the question in database
     */
    private int getQuestionLength() {

        try (Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement()) {
            String query = "SELECT * FROM MultipleChoice";
            ResultSet rs = stmt.executeQuery(query);
            size = rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return size;
    }
    
    public Question getQuestion() {
		Question temp = questions.poll();
		return temp;
	}
}
