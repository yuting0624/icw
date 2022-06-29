package dto;

import java.util.List;

public class ItemList {
	private String number;
	private List<Item> items;
	
	public ItemList(String number, List<Item> items) {
		super();
		this.number = number;
		this.items = items;
	}
	public ItemList() {
		
	}
	
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}

	
	
}