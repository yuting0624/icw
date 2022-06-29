package model;

import java.sql.SQLException;

import dao.HistoryDAO;
import dto.Account;
import dto.History;
import dto.Item;

public class ConfirmLogic {
	
	public boolean confirm(Account account, Item item)throws SQLException {
		HistoryDAO dao = new HistoryDAO();
		History history = new History();
		int r =dao.insert(history);
		
		return true;
		
		
		
	}

}
