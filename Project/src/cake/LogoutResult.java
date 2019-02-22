package cake;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ログアウト結果
 * @author d-yamaguchi
 *
 */
@WebServlet("/LogoutResult")
public class LogoutResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		session.setAttribute("isLogin", false);
		session.removeAttribute("userInfo");

		response.sendRedirect("TopPage");
	}



}
