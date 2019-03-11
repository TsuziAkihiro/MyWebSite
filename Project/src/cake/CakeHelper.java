package cake;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import beans.ItemDataBeans;

/**
 * 定数保持、処理及び表示簡略化ヘルパークラス
 *
 * @author d-yamaguchi
 *
 */
public class CakeHelper {


	public static boolean isLoginIdValidation(String inputLoginId) {
		// 英数字アンダースコア以外が入力されていたら
		if (inputLoginId.matches("[0-9a-zA-Z-_]+")) {
			return true;
		}

		return false;

	}

	public static Object cutSessionAttribute(HttpSession session, String str) {
		Object test = session.getAttribute(str);
		session.removeAttribute(str);

		return test;
	}

	public static int getTotalItemPrice(ArrayList<ItemDataBeans> items) {
		int total = 0;
		for (ItemDataBeans item : items) {
			total += item.getPrice() * item.getNumber();
		}
		return total;
	}
}
