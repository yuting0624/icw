package model;

import dao.ItemDAO;
import dto.ItemList;

public class SearchLogic {
	public ItemList process(String keyword, String category, int priceMin, int priceMax, int offset, int limit, String sort, String order)throws Exception{
		// ItemDAO作成（商品検索をしてくれるdaoさんを作成）
		ItemDAO dao = new ItemDAO();
		
		// 商品検索（search）をお願いする。
		ItemList itemList=new ItemList();
		itemList = dao.search(keyword, category, priceMin, priceMax, offset, limit, sort, order);

		//取得したリストを返す
		return itemList;
	}
	
	}


