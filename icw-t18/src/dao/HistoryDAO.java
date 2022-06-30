package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.History;

public class HistoryDAO {

	public List<History> findByOrder(String accountId) throws SQLException {
		
		DBUtil db = new DBUtil();
		
		Connection con = null;
		try {
			/* STEP 1:データベースの接続 */
			con = db.getConnection();

			/* STEP 2:SQL送信処理 */
			String sql = "SELECT * FROM ORDER WHERE ACCOUNTID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, accountId);
			ResultSet rs = pstmt.executeQuery();
			List<History> list = new ArrayList<History>();
			History history = null;
			while (rs.next()) {
				history = new History();
				history.setOrderDate(rs.getString("ORDERDATE"));
				history.setOrderId(rs.getString("ORDERID"));
				history.setItemId(rs.getString("ITEMID"));
				history.setOrderAmount(rs.getInt("ORDERAMOUNT"));
				history.setTotalPrice(rs.getInt("TOTALPRICE"));
				history.setDeliStatus(rs.getString("DELISTATUS"));
				list.add(history);
			}
			pstmt.close();
			return list;
		} finally {
			/* STEP 3:データベースとの接続を切断 */
			db.closeConnection(con);
		}
	}
}
		
	
