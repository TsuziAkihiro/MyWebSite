package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.DeliveryDataBeans;

public class DeliveryDAO {

    public List<DeliveryDataBeans> findAll() {
        Connection conn = null;
        List<DeliveryDataBeans> ddbList = new ArrayList<DeliveryDataBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM m_location_id";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("location_id");
                String prefecture = rs.getString("prefecture");
                String fee = rs.getString("delivery_fee");
                DeliveryDataBeans ddb = new DeliveryDataBeans(id, prefecture, fee);

                ddbList.add(ddb);
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
        return ddbList;
    }

    public DeliveryDataBeans findPf(String id) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM m_location_id WHERE location_id = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, id);
            ResultSet rs = pStmt.executeQuery();

            // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
           if (!rs.next()) {
               return null;
           }

           int location_id = rs.getInt("location_id");
           String prefecture = rs.getString("prefecture");
           String fee = rs.getString("delivery_fee");
           return new DeliveryDataBeans(location_id, prefecture, fee);

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

}
