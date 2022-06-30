package model;

import javax.servlet.http.HttpSession;

import dao.DeliFeeDAO;
import dto.Account;
import dto.Item;

public class DeliFeeLogic {
	public int buyLogic(Account account,int amount)throws Exception{
	
	//セッションスコープからitemを取得
	HttpSession session =request.getSession();
	Item item = (Item) session.getAttribute("item");
	DeliFeeDAO dao= new DeliFeeDAO();
	dao.searchByAddress(account);
	
	
	int sum = item.getPrice()*amount;
	item.setSum(sum);
	int total = sum +account.getDeliFee();
	item.setTotal(total);
	
	return item;
	}
	
}
