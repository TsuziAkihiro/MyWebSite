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
 * Servlet implementation class RegistResult
 */
@WebServlet("/RegistResult")
public class RegistResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		try {

			String inputLoginId = request.getParameter("login_id");
			String inputUserName = request.getParameter("name");
			String inputUserMailAddress = request.getParameter("mail_address");
			String inputUserPostalCode = request.getParameter("postal_code");
			String inputUserPrefecture = request.getParameter("prefecture");
			String inputUserAddress = request.getParameter("address");
			String inputPassword = request.getParameter("password");

			UserDataBeans udb = new UserDataBeans();
			udb.setLoginId(inputLoginId);
			udb.setName(inputUserName);
			udb.setMailAddress(inputUserMailAddress);
			udb.setPostalCode(inputUserPostalCode);
			udb.setPrefecture(inputUserPrefecture);
			udb.setAddress(inputUserAddress);
			udb.setPassword(inputPassword);

			// 登録が確定されたかどうか確認するための変数
			String confirmed = request.getParameter("confirm_button");

			//修正
			if(confirmed.isEmpty()){
				session.setAttribute("udb", udb);
				response.sendRedirect("Regist");
			//登録
			}else {
				UserDAO.insertUser(udb);
				request.setAttribute("udb", udb);
			       // フォワード
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registresult.jsp");
		        dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}