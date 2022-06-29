package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Account;

public class AccountDAO {
	
	public Account findByLogin(String accountId) throws SQLException {
		
		DBUtil db = new DBUtil();
		
		Connection con = null;
		try {
			/* STEP 1:データベースの接続 */
			con = db.getConnection();

			/* STEP 2:SQL送信処理 */
			String sql = "SELECT * FROM ACCOUNT WHERE ACCOUNTID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, accountId);
			ResultSet rs = pstmt.executeQuery();
			Account account = null;
			if (rs.next()) {
				account = new Account();
				account.setAccountId(rs.getString("ACCOUNT_ID"));
				account.setAccountPw(rs.getString("PASS"));
				account.setAccountName(rs.getString("ACCOUNT_NAME"));
				account.setPostalCode(rs.getString("POSTALCODE"));
				account.setAddress1(rs.getString("ADDRESS1"));
				account.setAddress2(rs.getString("ADDRESS2"));
				account.setPhoneNumber(rs.getString("PHONENUMBER"));
			}
			pstmt.close();
			return account;
		} finally {
			/* STEP 3:データベースとの接続を切断 */
			db.closeConnection(con);
		}
	}

	}