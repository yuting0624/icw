package dto;

public class History {
	/** 注文ID */
	private String orderId;
	
	/**　ユーザーID */
	private String accountId;
	
	/** 商品ID */
	private String itemId;
	
	/** 注文日時 */
	private String orderDate;

	/** 注文数 */
	private int orderAmount;

	/** 注文金額 */
	private int totalPrice;

	/** 注文状態 */
	private String deliStatus;

	public History(String orderId, String accountId, String itemId, String orderDate, int orderAmount, int totalPrice,
			String deliStatus) {
		super();
		this.orderId = orderId;
		this.accountId = accountId;
		this.itemId = itemId;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
		this.totalPrice = totalPrice;
		this.deliStatus = deliStatus;
	}
	
	public History() {
		
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDeliStatus() {
		return deliStatus;
	}

	public void setDeliStatus(String deliStatus) {
		this.deliStatus = deliStatus;
	}
	
	
	

}
