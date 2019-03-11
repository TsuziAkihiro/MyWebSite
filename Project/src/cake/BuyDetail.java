package cake;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BuyDataBeans;
import beans.ItemDataBeans;
import beans.UserDataBeans;
import dao.BuyDAO;
import dao.BuyDetailDAO;

/**
 * Servlet implementation class BuyDetail
 */
@WebServlet("/BuyDetail")
public class BuyDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyDetail() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		//ログインセッションがない場合、トップ画面にリダイレクトさせる
		HttpSession session = request.getSession();

	    // セッションスコープからインスタンスを取得
	    UserDataBeans user = (UserDataBeans)session.getAttribute("user");

		if(user == null) {
		// ユーザ一覧のサーブレットにリダイレクト
			response.sendRedirect("TopPage");
			return;
		}

		try {
			// リクエストパラメータの取得
			String id = request.getParameter("buyId");
			int  buyId = Integer.parseInt(id);

			/* ====購入完了ページ表示用==== */
			BuyDataBeans resultBDB = BuyDAO.getBuyDataBeansByBuyId(buyId);
			request.setAttribute("resultBDB", resultBDB);

			// 購入アイテム情報
			ArrayList<ItemDataBeans> buyIDBList = BuyDetailDAO.getItemDataBeansListByBuyId(buyId);
			request.setAttribute("buyIDBList", buyIDBList);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/buydetail.jsp");
        dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("TopPage");
		}

	}
}
