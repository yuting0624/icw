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
		public int insert(History history) throws SQLException {
			/* STEP 0:JDBCドライバの有効化 */
				DBUtil db =new DBUtil();

			Connection con = null;
			try {
				/* STEP 1:データベースの接続 */
				con = db.getConnection();

				/* STEP 2:SQL送信処理 */
				String sql = "INSERT INTO ORDER(ORDERDATE,ORDERID,ITEMID,ORDERAMOUNT,TOTALPRICE,DELISTATUS) VALUES(?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				history=new History();
				pstmt.setString(1, history.getOrderDate());
				pstmt.setString(2, history.getOrderId());
				pstmt.setString(3, history.getItemId());
				pstmt.setInt(4, history.getOrderAmount());
				pstmt.setInt(5, history.getTotalPrice());
				pstmt.setString(6, history.getDeliStatus());
				int r = pstmt.executeUpdate();
				pstmt.close();
				return r;

			} finally {
				/* STEP 3:データベースとの接続を切断 */
				db.closeConnection(con);
			}
	}
}
