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
@WebServlet("/FavoriteChange")
public class FavoriteChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriteChange() {
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

			FavoriteDAO favoriteDao = new FavoriteDAO();

//			お気に入り情報がなければ情報を作成し、メッセージを入れ、
//			情報があればお気に入り情報を削除する

			if(user != null) {
				if(favoriteDao.find(user.getId(),itemId) == null) {
					favoriteDao.insertFavorite(user.getId(),itemId);
					request.setAttribute("Msg",  "お気に入り中");
				}else {
					favoriteDao.deleteFavorite(user.getId(),itemId);
					request.setAttribute("Msg", "お気に入りにする");
				}
			}

			//対象のアイテム情報を取得
			ItemDataBeans item = ItemDAO.getItemByItemID(itemId);

			int count = favoriteDao.favoriteCount(itemId);

			//リクエストパラメーターにセット
			request.setAttribute("item", item);
			request.setAttribute("count", count);

	        // フォワード
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/item.jsp");
	        dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("TopPage");
		}
	}
}
