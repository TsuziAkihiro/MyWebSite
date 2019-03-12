package cake;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import beans.BuyDataBeans;
import beans.UserDataBeans;
import dao.BuyDAO;
import dao.UserDAO;

/**
 * Servlet implementation class MyPage
 */
@WebServlet("/MyPage")
@MultipartConfig(location="/Users/tsujiakihiro/Documents/GitHub/MyWebSite/Project/WebContent/img", maxFileSize=1048576)
public class MyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ログインセッションがない場合、トップ画面にリダイレクトさせる
		HttpSession session = request.getSession();

	    // セッションスコープからインスタンスを取得
	    UserDataBeans user = (UserDataBeans)session.getAttribute("user");

		if(user == null) {
		// ユーザ一覧のサーブレットにリダイレクト
			response.sendRedirect("TopPage");
			return;
		}
		try {

			// 購入一覧情報を取得
			BuyDAO buyDao = new BuyDAO();
			List<BuyDataBeans> buyList = buyDao.findById(user.getId());

			// リクエストスコープにユーザ一覧情報をセット
			request.setAttribute("buyList", buyList);

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
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

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

	    // セッションスコープからインスタンスを取得
	    UserDataBeans user = (UserDataBeans)session.getAttribute("user");

		Part part = request.getPart("file");
        String name = this.getFileName(part);
        part.write(name);

     // 画像をデータベースに登録
        UserDAO userDao = new UserDAO();
        userDao.updateImgDao(user.getId(), name);

        //セッションスコープ再登録
        user.setFileName(name);
		session.setAttribute("user", user);

		// 購入一覧情報を取得
		BuyDAO buyDao = new BuyDAO();
		List<BuyDataBeans> buyList = buyDao.findById(user.getId());

		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("buyList", buyList);

		// 画像の反映待ち
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
        dispatcher.forward(request, response);
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
