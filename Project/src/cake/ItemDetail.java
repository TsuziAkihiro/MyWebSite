package cake;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import beans.ItemDataBeans;
import dao.ItemDAO;

/**
 * Servlet implementation class ItemDetail
 */
@WebServlet("/ItemDetail")
@MultipartConfig(location="/Users/tsujiakihiro/Documents/GitHub/MyWebSite/Project/WebContent/img", maxFileSize=1048576)
public class ItemDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDetail() {
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
		int id = Integer.parseInt(request.getParameter("item_id"));

		//対象のアイテム情報を取得
		ItemDataBeans item = ItemDAO.getItemByItemID(id);

		//リクエストパラメーターにセット
		request.setAttribute("item", item);
		// フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemdetail.jsp");
        dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		HttpSession session = request.getSession();

		try {

			//選択された商品のIDを型変換し利用
			int id = Integer.parseInt(request.getParameter("item_id"));

			String inputName = request.getParameter("name");
			int inputprice = Integer.parseInt(request.getParameter("price"));
			String inputdetail = request.getParameter("detail");

			Part part = request.getPart("file");
	        String name = this.getFileName(part);
	        part.write(name);

	        ItemDAO itemDao = new ItemDAO();
	        itemDao.updateItemDao(inputName, inputprice, inputdetail, name, id);

			response.sendRedirect("ItemList");

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("TopPage");
		}
	}

	private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
    }
}
