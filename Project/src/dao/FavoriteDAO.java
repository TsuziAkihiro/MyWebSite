package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.FavoriteDataBeans;

public class FavoriteDAO {

	   /**
     * 全取得
     */
    public List<FavoriteDataBeans> findAll(int user_id) {
        Connection conn = null;
        ArrayList<FavoriteDataBeans> favoriteList = new ArrayList<FavoriteDataBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // 自分のIDで取得する
            String sql = "SELECT * FROM t_favorite " +
            		"INNER JOIN t_item " +
            		"ON t_favorite.item_id = t_item.id " +
            		"WHERE t_favorite.user_id = ?";

            // SELECTを実行し、結果表を取得
           PreparedStatement pStmt = conn.prepareStatement(sql);
           pStmt.setInt(1, user_id);
           ResultSet rs = pStmt.executeQuery();

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
            	int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                int itemId = rs.getInt("item_id");
                Date createDate = rs.getDate("create_date");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String fileName = rs.getString("file_name");

                FavoriteDataBeans favorite = new FavoriteDataBeans(id, userId, itemId, createDate, name, price, fileName);

                favoriteList.add(favorite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return favoriteList;
    }

    /**
     * 新規登録
     */
	public void insertFavorite(int user_id, int item_id) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("INSERT INTO t_favorite(user_id,item_id,create_date) VALUES(?,?,now())");
			st.setInt(1, user_id);
			st.setInt(2, item_id);
			st.executeUpdate();
			System.out.println("inserting favorite has been completed");

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
