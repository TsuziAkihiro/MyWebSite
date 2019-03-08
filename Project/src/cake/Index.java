package cake;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class List
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//1ページに表示する商品数
	final static int PAGE_MAX_ITEM_COUNT = 9;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		try {

		//商品情報を全取得
		ItemDAO itemDao = new ItemDAO();
		List<ItemDataBeans> itemList = itemDao.findAll();

		//リクエストスコープにセット
		request.setAttribute("itemList", itemList);
		//総アイテム数
		request.setAttribute("itemCount",itemList.size());


        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Index.jsp");
        dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("TopPage");
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

        // リクエストパラメータの文字コードを指定
        request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {


			String searchWord = request.getParameter("search_word");
			//表示ページ番号 未指定の場合 1ページ目を表示
			int pageNum = Integer.parseInt(request.getParameter("page_num") == null ? "1" : request.getParameter("page_num"));
			// 新たに検索されたキーワードをセッションに格納する
			session.setAttribute("searchWord", searchWord);

			// 商品リストを取得 ページ表示分のみ
			ArrayList<ItemDataBeans> searchResultItemList = ItemDAO.getItemsByItemName(searchWord, pageNum, PAGE_MAX_ITEM_COUNT);

			// 検索ワードに対しての総ページ数を取得
			double itemCount = ItemDAO.getItemCount(searchWord);
			int pageMax = (int) Math.ceil(itemCount / PAGE_MAX_ITEM_COUNT);

			//総アイテム数
			request.setAttribute("itemCount", (int) itemCount);
			// 総ページ数
			request.setAttribute("pageMax", pageMax);
			// 表示ページ
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("itemList", searchResultItemList);

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Index.jsp");
        dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("TopPage");
		}
	}
}
