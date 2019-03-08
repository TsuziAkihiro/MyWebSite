package cake;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import beans.UserDataBeans;
import dao.UserDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ログインセッションがある場合、マイページ画面にリダイレクトさせる
		HttpSession session = request.getSession();

		if(Objects.equals(session.getAttribute("isLogin"), true)) {
		// ユーザ一覧のサーブレットにリダイレクト
			response.sendRedirect("MyPage");
			return;
		}

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			/*文字化け対策*/
			request.setCharacterEncoding("UTF-8");

			HttpSession session = request.getSession();
			try {

				//パラメーターから取得
				String loginId = request.getParameter("loginId");
				String password = request.getParameter("password");

				//ハッシュを生成したい元の文字列
				String source = password;
				//ハッシュ生成前にバイト配列に置き換える際のCharset
				Charset charset = StandardCharsets.UTF_8;
				//ハッシュアルゴリズム
				String algorithm = "MD5";

				//ハッシュ生成処理
				byte[] bytes = null;
				try {
					bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				String result = DatatypeConverter.printHexBinary(bytes);
				//標準出力
				System.out.println(result);

				// リクエストパラメータの入力項目を引数に渡して、ユーザー情報を取得
				UserDAO userDAO = new UserDAO();

				UserDataBeans user = userDAO.findByLogin(loginId, result);

				//ユーザーIDが取得できたなら
				if (user != null) {
					session.setAttribute("isLogin", true);
					session.setAttribute("user", user);


					// マイページのサーブレットにリダイレクト
					response.sendRedirect("MyPage");
				} else {
					// リクエストスコープにエラーメッセージをセット
					request.setAttribute("errMsg", "ログインIDまたはパスワードが異なります。");
					session.setAttribute("loginId", loginId);
					// ログインjspにフォワード
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
					dispatcher.forward(request, response);
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
				session.setAttribute("errorMessage", e.toString());
				response.sendRedirect("Error");
			}
		}
}