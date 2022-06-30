package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Account;
import dto.DeliFee;

public class DeliFeeDAO {
	
	public void searchByAddress(Account account) throws SQLException {
		
		DBUtil db = new DBUtil();
		
		Connection con = null;
		try {
			/* STEP 1:データベースの接続 */
			con = db.getConnection();

			/* STEP 2:SQL送信処理 */
			String sql = "SELECT * FROM ACCOUNT WHERE ADDRESS1=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, account.getAddress1());
			ResultSet rs = pstmt.executeQuery();
			DeliFee deliFee = null;
			if (rs.next()) {
				account.setDeliFee(rs.getInt("DELIFEE"));
			}
			pstmt.close();
			return ;
		} finally {
			/* STEP 3:データベースとの接続を切断 */
			db.closeConnection(con);
		}
	}


}
