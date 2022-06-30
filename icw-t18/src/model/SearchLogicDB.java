package model;

import java.util.ArrayList;
import java.util.List;

import dao.ItemDAO;
import dto.Item;

public class SearchLogicDB {
	public List<Item> process(String name)throws Exception{
		// ItemDAO作成（商品検索をしてくれるdaoさんを作成）
		ItemDAO dao = new ItemDAO();
		
		// 商品検索（search）をお願いする。
		List<Item> itemList = new ArrayList<>();
		itemList = dao.searchByNameDB(name);

		//取得したリストを返す
		System.out.println(itemList);
		return itemList;
	}
	
	}

