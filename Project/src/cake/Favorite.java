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

import beans.FavoriteDataBeans;
import beans.UserDataBeans;
import dao.FavoriteDAO;

/**
 * Servlet implementation class Favorite
 */
@WebServlet("/Favorite")
public class Favorite extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Favorite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		try {

		//ログインセッションがない場合、トップ画面にリダイレクトさせる
		HttpSession session = request.getSession();

		if(session.getAttribute("user") == null) {

		// ユーザ一覧のサーブレットにリダイレクト
			response.sendRedirect("TopPage");
			return;
		}

		UserDataBeans user = (UserDataBeans)session.getAttribute("user");

		//商品情報を全取得
		FavoriteDAO favoriteDao = new FavoriteDAO();
		List<FavoriteDataBeans> favoriteList = favoriteDao.findAll(user.getId());

		//リクエストスコープにセット
		request.setAttribute("favoriteList", favoriteList);

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/favorite.jsp");
        dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("TopPage");
		}
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

			if(itemId != 0) {
				favoriteDao.deleteFavorite(user.getId(),itemId);
			}

			List<FavoriteDataBeans> favoriteList = favoriteDao.findAll(user.getId());

			//リクエストスコープにセット
			request.setAttribute("favoriteList", favoriteList);

	        // フォワード
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/favorite.jsp");
	        dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("TopPage");
		}
	}
}
