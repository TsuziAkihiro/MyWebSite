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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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

		String validationMessage = (String) CakeHelper.cutSessionAttribute(session, "validationMessage");
		request.setAttribute("validationMessage",validationMessage);

	    // セッションスコープからインスタンスを取得
	    UserDataBeans user = (UserDataBeans)session.getAttribute("user");

		UserDAO userDao = new UserDAO();
		UserDataBeans udb = userDao.find(user.getId());

		// 都道府県一覧情報を取得
		DeliveryDAO deliveryDao = new DeliveryDAO();
		List<DeliveryDataBeans> ddbList = deliveryDao.findAll();

		// リクエストスコープに配送情報,ユーザ情報をセット
		request.setAttribute("ddbList", ddbList);
		request.setAttribute("udb", udb);

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
        dispatcher.forward(request, response);
    }

}
