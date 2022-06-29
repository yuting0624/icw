package model;

import java.sql.SQLException;
import java.util.List;

import dao.HistoryDAO;
import dto.History;

public class HistoryLogic {

	public List<History> process(String accountId ) throws SQLException {
		// DAOを使用して、引数のaccount IDと一致する注文をテーブルから検索
		HistoryDAO dao = new HistoryDAO();	
		List<History> historyList = dao.findByOrder(accountId);
		return historyList;
	
		//ItemDAO dao2 = new ItemDAO();
		//Item item = dao2.searchById(history.getItemId());
		
	}	
}