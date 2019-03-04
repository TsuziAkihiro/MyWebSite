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

import beans.DeliveryDataBeans;
import dao.DeliveryDAO;

/**
 * Servlet implementation class Regist
 */
@WebServlet("/Regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		HttpSession session = request.getSession();

		String validationMessage = (String) CakeHelper.cutSessionAttribute(session, "validationMessage");
		request.setAttribute("validationMessage",validationMessage);

		// 都道府県一覧情報を取得
		DeliveryDAO deliveryDao = new DeliveryDAO();
		List<DeliveryDataBeans> ddbList = deliveryDao.findAll();

		// リクエストスコープに配送情報をセット
		request.setAttribute("ddbList", ddbList);

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp");
        dispatcher.forward(request, response);

    }


}