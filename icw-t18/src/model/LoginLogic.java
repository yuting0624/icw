package model;

import java.sql.SQLException;

import dao.AccountDAO;
import dto.Account;

public class LoginLogic {
	
	public Account login(String accountId) throws SQLException {
		
		// DAOを利用してAccountテーブルから検索する
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByLogin(accountId);
		return account;
		
	}	

}
