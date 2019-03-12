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
 * Servlet implementation class UpdateResult
 */
@WebServlet("/UpdateResult")
public class UpdateResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateResult() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ログインセッションがない場合、トップ画面にリダイレクトさせる
		HttpSession session = request.getSession();

		if(session.getAttribute("user") == null) {
		// ユーザ一覧のサーブレットにリダイレクト
			response.sendRedirect("TopPage");
			return;
		}
			request.setCharacterEncoding("UTF-8");
			try {
				String inputLoginId = request.getParameter("login_id");
				String inputUserName = request.getParameter("name");
				String inputUserMailAddress = request.getParameter("mail_address");
				String inputUserPostalCode = request.getParameter("postal_code");
				String inputUserPrefecture = request.getParameter("prefecture");
				String inputUserAddress = request.getParameter("address");

				DeliveryDataBeans ddb = new DeliveryDataBeans();
				DeliveryDAO delivery = new DeliveryDAO();
				ddb = delivery.findPf(inputUserPrefecture);

				UserDataBeans udb = new UserDataBeans();

			    // セッションスコープからインスタンスを取得
			    UserDataBeans user = (UserDataBeans)session.getAttribute("user");

			    udb.setId(user.getId());
				udb.setLoginId(inputLoginId);
				udb.setName(inputUserName);
				udb.setMailAddress(inputUserMailAddress);
				udb.setPostalCode(inputUserPostalCode);
				udb.setPrefecture(ddb.getPrefecture());
				udb.setAddress(inputUserAddress);

				// 都道府県一覧情報を取得
				DeliveryDAO deliveryDao = new DeliveryDAO();
				List<DeliveryDataBeans> ddbList = deliveryDao.findAll();


				request.setAttribute("ddbList", ddbList);

				String validationMessage = "";

				// 登録が確定されたかどうか確認するための変数
				String confirmed = request.getParameter("confirm_button");

				//修正
				if(confirmed == null){
					response.sendRedirect("MyPage");

				//登録
				}else {
				// ログインIDの入力規則チェック 英数字 ハイフン アンダースコアのみ入力可能
				if (!CakeHelper.isLoginIdValidation(udb.getLoginId())) {
					validationMessage += "半角英数とハイフン、アンダースコアのみ入力できます";
				}

				// バリデーションエラーメッセージがないなら確認画面へ
				if (validationMessage.length() == 0) {
					request.setAttribute("udb", udb);

					UserDAO dao = new UserDAO();
					dao.updateUserDao(udb);
					user.setLoginId(udb.getLoginId());
					session.setAttribute("user", user);

				       // フォワード
			        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/updateresult.jsp");
			        dispatcher.forward(request, response);
				} else {
					session.setAttribute("udb", udb);

					request.setAttribute("validationMessage", validationMessage);

				       // フォワード
			        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
			        dispatcher.forward(request, response);
				}
			}

			} catch (Exception e) {
				e.printStackTrace();
				session.setAttribute("errorMessage", e.toString());
				response.sendRedirect("Error");
			}
		}

}
