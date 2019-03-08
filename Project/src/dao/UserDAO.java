package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import base.DBManager;
import beans.UserDataBeans;


public class UserDAO {

    public UserDataBeans findByLogin(String loginId, String password) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM t_user WHERE login_id = ? and login_password = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            int idData = rs.getInt("id");
            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            String fileName = rs.getString("file_name");

            return new UserDataBeans(idData, loginIdData, nameData, fileName);

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
    }

	public static boolean isOverlapLoginId(String loginId, int userId) throws SQLException {
		// 重複しているかどうか表す変数
		boolean isOverlap = false;
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			// 入力されたlogin_idが存在するか調べる
			st = con.prepareStatement("SELECT login_id FROM t_user WHERE login_id = ? AND id != ?");
			st.setString(1, loginId);
			st.setInt(2, userId);
			ResultSet rs = st.executeQuery();

			System.out.println("searching loginId by inputLoginId has been completed");

			if (rs.next()) {
				isOverlap = true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}

		System.out.println("overlap check has been completed");
		return isOverlap;
	}

    /**
     * 新規登録
     */
	public static void insertUser(UserDataBeans udb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		//ハッシュを生成したい元の文字列
		String source = udb.getPassword();
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

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("INSERT INTO t_user(login_id,name,mail_address,postal_code,prefecture,address,login_password,file_name,create_date,update_date) VALUES(?,?,?,?,?,?,?,'images.png',now(),now())");
			st.setString(1, udb.getLoginId());
			st.setString(2, udb.getName());
			st.setString(3, udb.getMailAddress());
			st.setString(4, udb.getPostalCode());
			st.setString(5, udb.getPrefecture());
			st.setString(6, udb.getAddress());
			st.setString(7,result);
			st.executeUpdate();
			System.out.println("inserting user has been completed");
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
    public List<UserDataBeans> findAll() {
        Connection conn = null;
        List<UserDataBeans> userList = new ArrayList<UserDataBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM t_user WHERE 2 <= id";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                String fileName = rs.getString("file_name");
                UserDataBeans user = new UserDataBeans(id, loginId, name, fileName);

                userList.add(user);
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
        return userList;
    }

    /**
     * 取得
     */
    public UserDataBeans find(int Id, String loginId) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM t_user WHERE id = ? and login_id = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, Id);
            pStmt.setString(2, loginId);
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            int idData = rs.getInt("id");
            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            String mailAddressData = rs.getString("mail_address");
            String postalData = rs.getString("postal_code");
            String prefectureData = rs.getString("prefecture");
            String AddressData = rs.getString("address");
            return new UserDataBeans(idData,loginIdData, nameData,mailAddressData,postalData,prefectureData,AddressData);

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
    }

    /**
     * 消去
     */
    public void deleteDao(int id){
    	Connection conn = null;
    	 try {
             // データベースへ接続
             conn = DBManager.getConnection();
             String sql = "DELETE FROM t_user WHERE id = ?";
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
 * 更新
 */
    public void updateUserDao (UserDataBeans udb){
    	Connection con= null;
    	PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("UPDATE t_user SET login_id = ?,name = ?,mail_address = ?,postal_code = ?,prefecture = ?,address = ?,update_date = now() WHERE id = ?");
			st.setString(1, udb.getLoginId());
			st.setString(2, udb.getName());
			st.setString(3, udb.getMailAddress());
			st.setString(4, udb.getPostalCode());
			st.setString(5, udb.getPrefecture());
			st.setString(6, udb.getAddress());
			st.setInt(7,udb.getId());
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
