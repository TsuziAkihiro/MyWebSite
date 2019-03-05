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

import beans.ItemDataBeans;
import dao.ItemDAO;

/**
 * Servlet implementation class ItemList
 */
@WebServlet("/ItemList")
public class ItemList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemList() {
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

		//商品情報を全取得
		ItemDAO itemDao = new ItemDAO();
		List<ItemDataBeans> itemList = itemDao.findAll();

		//リクエストスコープにセット
		request.setAttribute("itemList", itemList);

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemlist.jsp");
        dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("TopPage");
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
