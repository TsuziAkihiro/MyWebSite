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
 * Servlet implementation class FavoriteAdd
 */
@WebServlet("/FavoriteAdd")
public class FavoriteAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriteAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		HttpSession session = request.getSession();

		try {
			//選択された商品のIDを型変換し利用
			int itemId = Integer.parseInt(request.getParameter("item_id"));

		    // セッションスコープからインスタンスを取得
		    UserDataBeans user = (UserDataBeans)session.getAttribute("user");

		    //データベースにお気に入り登録
			FavoriteDAO favoriteDao = new FavoriteDAO();
			favoriteDao.insertFavorite(user.getId(),itemId);

			//対象のアイテム情報を取得
			ItemDataBeans item = ItemDAO.getItemByItemID(itemId);

			//リクエストパラメーターにセット
			request.setAttribute("item", item);

	        // フォワード
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item.jsp");
	        dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("TopPage");
		}
	}
}
