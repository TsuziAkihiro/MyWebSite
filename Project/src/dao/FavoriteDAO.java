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
import beans.ItemDataBeans;

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
     * お気に入りに追加
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
    /**
     * お気に入りから削除
     */
    public void deleteFavorite(int user_id, int item_id){
    	Connection conn = null;
    	 try {
             // データベースへ接続
             conn = DBManager.getConnection();
             String sql = "DELETE FROM t_favorite WHERE user_id = ? and item_id = ?";
             // SELECTを実行し、結果表を取得
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user_id);
            stmt.setInt(2, item_id);
            int result = stmt.executeUpdate();
            // 追加された行数を出力
            System.out.println(result);
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	/**
	 * item_idとuseridから情報を取得する
	 *
	 */
 public FavoriteDataBeans find(int user_id, int item_id) {
     Connection conn = null;

     try {
         // データベースへ接続
         conn = DBManager.getConnection();

         // SELECT文を準備
         // 自分のIDで取得する
         String sql = "SELECT * FROM t_favorite WHERE user_id = ? and item_id = ? ";

         // SELECTを実行し、結果表を取得
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.setInt(1, user_id);
        pStmt.setInt(2, item_id);
        ResultSet rs = pStmt.executeQuery();

         // 結果表に格納されたレコードの内容を
         // Userインスタンスに設定し、ArrayListインスタンスに追加
         while (rs.next()) {
         	int id = rs.getInt("id");
             int userId = rs.getInt("user_id");
             int itemId = rs.getInt("item_id");
             Date createDate = rs.getDate("create_date");

             return new FavoriteDataBeans(id, userId, itemId, createDate);
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
     return null;
 }
 /**
 * 商品検索
 */
public static ArrayList<ItemDataBeans> getItemsByItemName(int user_id, String searchWord, int pageNum, int pageMaxItemCount) throws SQLException {
	Connection con = null;
	PreparedStatement st = null;
	try {
		int startiItemNum = (pageNum - 1) * pageMaxItemCount;
		con = DBManager.getConnection();

		if (searchWord.length() == 0) {
			// 全検索
			st = con.prepareStatement("SELECT * FROM t_favorite "
					+ "INNER JOIN t_item "
					+ "ON t_favorite.item_id = t_item.id "
					+ "WHERE user_id = ? "
					+ "ORDER BY id ASC LIMIT ?,? ");
			st.setInt(1, user_id);
			st.setInt(2, startiItemNum);
			st.setInt(3, pageMaxItemCount);
		} else {
			// 商品名検索
			st = con.prepareStatement("SELECT * FROM t_favorite WHERE name LIKE ? ORDER BY id ASC LIMIT ?,? ");
			st.setString(1,"%"+searchWord+"%");
			st.setInt(2, startiItemNum);
			st.setInt(3, pageMaxItemCount);
		}

		ResultSet rs = st.executeQuery();
		ArrayList<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();

		while (rs.next()) {
			ItemDataBeans item = new ItemDataBeans();
			item.setId(rs.getInt("item_id"));
			item.setName(rs.getString("name"));
			item.setDetail(rs.getString("detail"));
			item.setPrice(rs.getInt("price"));
			item.setFileName(rs.getString("file_name"));
			itemList.add(item);
		}
		System.out.println("get Items by itemName has been completed");
		return itemList;
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		throw new SQLException(e);
	} finally {
		if (con != null) {
			con.close();
		}
	}
}
/**
 * 商品総数を取得
 *
 */
public static double getItemCount(int user_id, String searchWord) throws SQLException {
	Connection con = null;
	PreparedStatement st = null;
	try {
		con = DBManager.getConnection();
		st = con.prepareStatement("select count(*) as cnt from t_favorite where name like ? and user_id = ?");
		st.setString(1, "%" + searchWord + "%");
		st.setInt(2, user_id);
		ResultSet rs = st.executeQuery();
		double coung = 0.0;
		while (rs.next()) {
			coung = Double.parseDouble(rs.getString("cnt"));
		}
		return coung;
	} catch (Exception e) {
		System.out.println(e.getMessage());
		throw new SQLException(e);
	} finally {
		if (con != null) {
			con.close();
		}
	}
}

/**
 * 商品が何人からお気に入りにされているか取得
 *
 */
		public int favoriteCount(int item_id)
			throws SQLException {
			Connection con = null;
			PreparedStatement st = null;
			try {
				con = DBManager.getConnection();
				st = con.prepareStatement("select count(*) as cnt from t_favorite where item_id = ?");
				st.setInt(1, item_id);
				ResultSet rs = st.executeQuery();
				int count  = 0;
				while (rs.next()) {
					count = rs.getInt("cnt");
				}
				return count;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw new SQLException(e);
			} finally {
				if (con != null) {
					con.close();
				}
			}
		}


}
