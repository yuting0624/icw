package dto;

public class Item extends Account{
	private String itemId;

	/** カテゴリー */
	private String category;

	/** 名前 */
	private String name;
	
	private String kana;

	/** 価格*/
	private Integer price;

	/** コメント */
	private String comment;
	
	/** URL */
	private String image_url;

	public Item(String itemId, String category, String name, String kana, Integer price,String comment,String image_url) {
		this.itemId = itemId;
		this.category = category;
		this.name = name;
		this.kana = kana;
		this.price = price;
		this.comment = comment;
		this.image_url = image_url;
		
	}

	public Item() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getItemId() {
		return itemId;
	}

	public String getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public Integer getPrice() {
		return price;
	}

	public String getComment() {
		return comment;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setKana(String kana) {
		this.kana = kana;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	

}
	