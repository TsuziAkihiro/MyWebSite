package cake;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemDataBeans;
import beans.UserDataBeans;
import dao.FavoriteDAO;
import dao.ItemDAO;

/**
 * Servlet implementation class Item
 */
@WebServlet("/Item")
public class Item extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Item() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		HttpSession session = request.getSession();
		try {

		//選択された商品のIDを型変換し利用
		int itemId = Integer.parseInt(request.getParameter("item_id"));

	    // セッションスコープからインスタンスを取得
	    UserDataBeans user = (UserDataBeans)session.getAttribute("user");

		//対象のアイテム情報を取得
		ItemDataBeans item = ItemDAO.getItemByItemID(itemId);

		FavoriteDAO favoriteDao = new FavoriteDAO();
		int count = favoriteDao.favoriteCount(itemId);

		//リクエストパラメーターにセット
		request.setAttribute("item", item);
		request.setAttribute("count", count);

		//ユーザー情報があればお気に入りボタンを表示し、メッセージを入れる

		if(user != null) {
			if(favoriteDao.find(user.getId(),itemId) == null) {
				request.setAttribute("Msg", "お気に入りにする");
			}else {
				request.setAttribute("Msg",  "お気に入り中");
			}
		}
        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item.jsp");
        dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
     }
}
