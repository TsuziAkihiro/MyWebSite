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
import beans.DeliveryDataBeans;
import beans.ItemDataBeans;
import beans.UserDataBeans;
import dao.DeliveryDAO;
import dao.UserDAO;

/**
 * Servlet implementation class BuyConfirm
 */
@WebServlet("/BuyConfirm")
public class BuyConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// セッションスコープからインスタンスを取得
		UserDataBeans user = (UserDataBeans)session.getAttribute("user");

		if(user == null) {
			response.sendRedirect("Login");
			return;
		}

		UserDAO userDao = new UserDAO();
		user = userDao.find(user.getId());

		//カートを取得
		ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");

		//合計金額
		int totalPrice = CakeHelper.getTotalItemPrice(cart);

		// 都道府県一覧情報を取得
		DeliveryDAO deliveryDao = new DeliveryDAO();
		DeliveryDataBeans ddb = deliveryDao.findFee(user.getPrefecture());

		// 購入情報をセット
		BuyDataBeans bdb = new BuyDataBeans();
		bdb.setUserId( user.getId());
		bdb.setTotalPrice(totalPrice + ddb.getFee());
		bdb.setDeliveryMethodPrice(ddb.getFee());

		//購入確定で利用
		session.setAttribute("bdb", bdb);

      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/buyconfirm.jsp");
      dispatcher.forward(request, response);
	}
}
