package cake;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class UserManager
 */
@WebServlet("/UserManager")
public class UserManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		//ログインセッションがない場合、トップ画面にリダイレクトさせる
		HttpSession session = request.getSession();

		if(session.getAttribute("user") == null) {
		// ユーザ一覧のサーブレットにリダイレクト
			response.sendRedirect("TopPage");
			return;
		}

		// ユーザ一覧情報を取得
		UserDAO userDao = new UserDAO();
		List<UserDataBeans> userList = userDao.findAll();

		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("userList", userList);

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usermanager.jsp");
        dispatcher.forward(request, response);
    }

}
