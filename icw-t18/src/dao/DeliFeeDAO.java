package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.DeliFee;

public class DeliFeeDAO {
	
	public DeliFee searchByAddress(String address1) throws SQLException {
		
		DBUtil db = new DBUtil();
		
		Connection con = null;
		try {
			/* STEP 1:データベースの接続 */
			con = db.getConnection();

			/* STEP 2:SQL送信処理 */
			String sql = "SELECT * FROM ACCOUNT WHERE ADDRESS1=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, address1);
			ResultSet rs = pstmt.executeQuery();
			DeliFee deliFee = null;
			if (rs.next()) {
				deliFee = new DeliFee();
				deliFee.setAddress1(rs.getString("ADDRESS1"));
				deliFee.setDeliFee(rs.getInt("DELIFEE"));
			}
			pstmt.close();
			return deliFee;
		} finally {
			/* STEP 3:データベースとの接続を切断 */
			db.closeConnection(con);
		}
	}


}
