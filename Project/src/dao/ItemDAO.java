package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import base.DBManager;
import beans.ItemDataBeans;

public class ItemDAO {

    /**
     * 商品新規登録
     */
	public static void insertItem(ItemDataBeans idb)
		throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("INSERT INTO t_item(name,detail,price,file_name,create_date,update_date) VALUES(?,?,?,?,now(),now())");
			st.setString(1, idb.getName());
			st.setString(2, idb.getDetail());
			st.setInt(3, idb.getPrice());
			st.setString(4, idb.getFileName());
			st.executeUpdate();
			System.out.println("inserting item has been completed");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

}
