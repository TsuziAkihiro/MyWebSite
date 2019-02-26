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

import beans.DeliveryDataBeans;
import beans.UserDataBeans;
import dao.DeliveryDAO;
import dao.UserDAO;

/**
 * Servlet implementation class RegistConfirm
 */
@WebServlet("/RegistConfirm")
public class RegistConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;


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
			String inputConfirmPassword = request.getParameter("confirm_password");

			UserDataBeans udb = new UserDataBeans();
			udb.setLoginId(inputLoginId);
			udb.setName(inputUserName);
			udb.setMailAddress(inputUserMailAddress);
			udb.setPostalCode(inputUserPostalCode);
			udb.setPrefecture(inputUserPrefecture);
			udb.setAddress(inputUserAddress);
			udb.setPassword(inputPassword);

			// 都道府県一覧情報を取得
			DeliveryDAO deliveryDao = new DeliveryDAO();
			List<DeliveryDataBeans> ddbList = deliveryDao.findAll();


			request.setAttribute("ddbList", ddbList);

			String validationMessage = "";



			// 入力されているパスワードが確認用と等しいか
			if (!inputPassword.equals(inputConfirmPassword)) {
				validationMessage += "入力されているパスワードと確認用パスワードが違います<br>";
			}

			// ログインIDの入力規則チェック 英数字 ハイフン アンダースコアのみ入力可能
			if (!CakeHelper.isLoginIdValidation(udb.getLoginId())) {
				validationMessage += "半角英数とハイフン、アンダースコアのみ入力できます";
			}

			// loginIdの重複をチェック
			if (UserDAO.isOverlapLoginId(udb.getLoginId(), 0)) {
				validationMessage += "ほかのユーザーが使用中のログインIDです";
			}

			// バリデーションエラーメッセージがないなら確認画面へ
			if (validationMessage.length() == 0) {
				request.setAttribute("udb", udb);

			       // フォワード
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registconfirm.jsp");
		        dispatcher.forward(request, response);
			} else {
				session.setAttribute("udb", udb);

				session.setAttribute("validationMessage", validationMessage);
				response.sendRedirect("Regist");
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}