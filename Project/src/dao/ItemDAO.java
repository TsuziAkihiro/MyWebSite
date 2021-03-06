package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.util.StringUtils;

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
    /**
     * 全取得
     */
    public List<ItemDataBeans> findAll() {
        Connection conn = null;
        List<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM t_item";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
            	int id = rs.getInt("id");
                String name = rs.getString("name");
                String detail = rs.getString("detail");
                int price = rs.getInt("price");
                String file_name = rs.getString("file_name");
                ItemDataBeans item = new ItemDataBeans(id, name, detail, price, file_name);

                itemList.add(item);
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
        return itemList;
    }

	/**
	 * ランダムで引数指定分のItemDataBeansを取得
	 * @param limit 取得したいかず
	 * @return <ItemDataBeans>
	 * @throws SQLException
	 */
	public static ArrayList<ItemDataBeans> getRandItem(int limit) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM t_item ORDER BY RAND() LIMIT ? ");
			st.setInt(1, limit);

			ResultSet rs = st.executeQuery();

			ArrayList<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();

			while (rs.next()) {
				ItemDataBeans item = new ItemDataBeans();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setDetail(rs.getString("detail"));
				item.setPrice(rs.getInt("price"));
				item.setFileName(rs.getString("file_name"));
				itemList.add(item);
			}
			System.out.println("getAllItem completed");
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
     * IDをもとにアイテム情報を取得
     */
	public static ItemDataBeans getItemByItemID(int itemId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM t_item WHERE id = ?");
			st.setInt(1, itemId);

			ResultSet rs = st.executeQuery();

			ItemDataBeans item = new ItemDataBeans();
			if (rs.next()) {
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setDetail(rs.getString("detail"));
				item.setPrice(rs.getInt("price"));
				item.setFileName(rs.getString("file_name"));
			}

			System.out.println("searching item by itemID has been completed");

			return item;
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
     * 消去
     */
    public void deleteDao(int id){
    	Connection conn = null;
    	 try {
             // データベースへ接続
             conn = DBManager.getConnection();
             String sql = "DELETE FROM t_item WHERE id = ?";
             // SELECTを実行し、結果表を取得
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
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
	 * 商品検索
	 */
	public static ArrayList<ItemDataBeans> getItemsByItemName(String searchWord, int pageNum, int pageMaxItemCount) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			int startiItemNum = (pageNum - 1) * pageMaxItemCount;
			con = DBManager.getConnection();

			if(StringUtils.isNullOrEmpty(searchWord)) {
				// 全検索
				st = con.prepareStatement("SELECT * FROM t_item ORDER BY id ASC LIMIT ?,? ");
				st.setInt(1, startiItemNum);
				st.setInt(2, pageMaxItemCount);
			}else {
				if (searchWord.length() == 0) {
					// 全検索
					st = con.prepareStatement("SELECT * FROM t_item ORDER BY id ASC LIMIT ?,? ");
					st.setInt(1, startiItemNum);
					st.setInt(2, pageMaxItemCount);
				} else {
					// 商品名検索
					st = con.prepareStatement("SELECT * FROM t_item WHERE name LIKE ? ORDER BY id ASC LIMIT ?,? ");
					st.setString(1,"%"+searchWord+"%");
					st.setInt(2, startiItemNum);
					st.setInt(3, pageMaxItemCount);
				}
			}

			ResultSet rs = st.executeQuery();
			ArrayList<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();

			while (rs.next()) {
				ItemDataBeans item = new ItemDataBeans();
				item.setId(rs.getInt("id"));
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
	public static double getItemCount(String searchWord) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("select count(*) as cnt from t_item where name like ?");
			st.setString(1, "%" + searchWord + "%");
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
	 * 商品の更新
	 */
	    public void updateItemDao (String name,int price, String detail,String fileName, int id){
	    	Connection con= null;
	    	PreparedStatement st = null;

			try {
				con = DBManager.getConnection();
				st = con.prepareStatement("UPDATE t_item SET name = ?,detail = ?,price = ?,file_name = ?,update_date = now() WHERE id = ?");
				st.setString(1, name);
				st.setString(2, detail);
				st.setInt(3, price);
				st.setString(4, fileName);
				st.setInt(5,id);
				st.executeUpdate();
				System.out.println("updating user has been completed");

		      } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            // データベース切断
		            if (con != null) {
		                try {
		                    con.close();
		                } catch (SQLException e) {
		                    e.printStackTrace();
		                }
		            }
		        }
		    }


}
