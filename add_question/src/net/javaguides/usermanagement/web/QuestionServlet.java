package net.javaguides.usermanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.usermanagement.dao.QuestionDAO;
import net.javaguides.usermanagement.model.Question;


@WebServlet("/")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionDAO questionDAO;
	
	public void init() {
		questionDAO = new QuestionDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertQuestion(request, response);
				break;
			case "/delete":
				deleteQuestion(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateQuestion(request, response);
				break;
			default:
				listQuestion(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listQuestion(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Question> listQuestion = questionDAO.selectAllQuestions();
		request.setAttribute("listQuestion", listQuestion);
		RequestDispatcher dispatcher = request.getRequestDispatcher("question-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("question-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int question_no= Integer.parseUnsignedInt(request.getParameter("id"));
		Question existingUser = questionDAO.selectQuestion(question_no);
		RequestDispatcher dispatcher = request.getRequestDispatcher("question-form.jsp");
		request.setAttribute("question", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertQuestion(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
        String question = request.getParameter("question");
       
		Question newQuestion = new Question(question); 
		questionDAO.insertQuestion(newQuestion);
		response.sendRedirect("list");
	}

	private void updateQuestion(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int question_no = Integer.parseUnsignedInt(request.getParameter("id"));
		String question= request.getParameter("question");
		Question book = new Question(question_no,question);
		questionDAO.updateQuestion(book);
		response.sendRedirect("list");
	}

	private void deleteQuestion(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int question_no = Integer.parseUnsignedInt(request.getParameter("id"));
		questionDAO.deleteQuestion(question_no);
		response.sendRedirect("list");

	}

}
