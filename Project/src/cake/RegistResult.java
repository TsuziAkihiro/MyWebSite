package cake;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
 * Servlet implementation class RegistResult
 */
@WebServlet("/RegistResult")
public class RegistResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		try {

			String inputLoginId = request.getParameter("login_id");
			String inputUserName = request.getParameter("name");
			String inputUserMailAddress = request.getParameter("mail_address");
			String inputUserPostalCode = request.getParameter("postal_code");
			String inputUserPrefecture = request.getParameter("prefecture");
			String inputUserAddress = request.getParameter("address");
			String inputPassword = request.getParameter("password");

			UserDataBeans udb = new UserDataBeans();
			udb.setLoginId(inputLoginId);
			udb.setName(inputUserName);
			udb.setMailAddress(inputUserMailAddress);
			udb.setPostalCode(inputUserPostalCode);
			udb.setPrefecture(inputUserPrefecture);
			udb.setAddress(inputUserAddress);
			udb.setPassword(inputPassword);

			// 登録が確定されたかどうか確認するための変数
			String confirmed = request.getParameter("confirm_button");


			//修正
			if(confirmed == null){
				session.setAttribute("udb", udb);
				response.sendRedirect("Regist");
			//登録
			}else {
				UserDAO.insertUser(udb);
				request.setAttribute("udb", udb);

				//ハッシュを生成したい元の文字列
				String source = inputPassword;
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
				UserDAO userDAO = new UserDAO();

				UserDataBeans user = userDAO.findByLogin(inputLoginId, result);
				session.setAttribute("isLogin", true);
				session.setAttribute("user", user);

			       // フォワード
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registresult.jsp");
		        dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}