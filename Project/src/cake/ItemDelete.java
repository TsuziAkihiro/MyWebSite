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
 * Servlet implementation class ItemDelete
 */
@WebServlet("/ItemDelete")
public class ItemDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDelete() {
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

		if(session.getAttribute("user") == null) {
				// ユーザ一覧のサーブレットにリダイレクト
					response.sendRedirect("TopPage");
					return;
		}

		//選択された商品のIDを型変換し利用
		int id = Integer.parseInt(request.getParameter("item_id"));

		//対象のアイテム情報を取得
		ItemDataBeans item = ItemDAO.getItemByItemID(id);

		//リクエストパラメーターにセット
		request.setAttribute("item", item);
        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemdelete.jsp");
        dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//選択された商品のIDを型変換し利用
		int id = Integer.parseInt(request.getParameter("item_id"));

		ItemDAO itemDao = new ItemDAO();
		itemDao.deleteDao(id);

		List<ItemDataBeans> itemList = itemDao.findAll();

		//リクエストスコープにセット
		request.setAttribute("itemList", itemList);

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemlist.jsp");
        dispatcher.forward(request, response);
	}

}
