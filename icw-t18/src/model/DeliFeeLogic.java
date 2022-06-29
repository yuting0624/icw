package model;

import dao.DeliFeeDAO;
import dto.Account;

public class DeliFeeLogic {
	public int buylogic(Account account,int amount)throws Exception{
		
	DeliFeeDAO dao= new DeliFeeDAO();
	dao.searchByAddress(account.getAddress1());
	
	
	
	int sum = itemList.price*amount;
	int total = sum +dao.deliFee;
			
	return total;
	}
	
}
