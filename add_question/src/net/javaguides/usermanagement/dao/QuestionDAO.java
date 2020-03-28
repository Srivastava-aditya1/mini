package net.javaguides.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.usermanagement.model.Question;

public class QuestionDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/studentss1";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_QUESTIONS_SQL = "INSERT INTO question_table" +
            "  (question) VALUES " + " (?);";

	private static final String SELECT_QUESTIONS_BY_ID = "select question_no,question from question_table where question_no =?";
	private static final String SELECT_ALL_QUESTIONS = "select * from question_table";
	private static final String DELETE_QUESTIONS_SQL = "delete from question_table where question_no=?;";
	private static final String UPDATE_QUESTIONS_SQL = "update question_table set question=? where question_no = ?;";

	public QuestionDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertQuestion(Question question) throws SQLException {
		System.out.println(INSERT_QUESTIONS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUESTIONS_SQL)) {
			
            preparedStatement.setString(1, question.getquestion());
           
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Question selectQuestion(int question_no) {
		Question question = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUESTIONS_BY_ID);) {
			preparedStatement.setInt(1, question_no);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				
				String question1 = rs.getString("question");
				
				question = new Question(question_no,question1);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return question;
	}

	public List<Question> selectAllQuestions() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Question> questions = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUESTIONS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int question_no= rs.getInt("question_no");
				String question= rs.getString("question");
				
				questions.add(new Question(question_no,question));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return questions;
	}

	public boolean deleteQuestion(int question_no) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_QUESTIONS_SQL);) {
			statement.setInt(1, question_no);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateQuestion(Question question) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_QUESTIONS_SQL);) {
			
			
			statement.setString(1,question.getquestion());
			statement.setInt(2, question.getquestion_no());
			

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
