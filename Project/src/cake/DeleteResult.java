package cake;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;
import dao.UserDAO;
/**
 * Servlet implementation class DeleteResult
 */
@WebServlet("/DeleteResult")
public class DeleteResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteResult() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
	    // セッションスコープからインスタンスを取得
	    UserDataBeans user = (UserDataBeans)session.getAttribute("user");

		UserDAO userDao = new UserDAO();
		userDao.deleteDao(user.getId());

		session.setAttribute("isLogin", false);
		session.removeAttribute("userInfo");

	       // フォワード
     RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/deleteresult.jsp");
     dispatcher.forward(request, response);

	}
}
