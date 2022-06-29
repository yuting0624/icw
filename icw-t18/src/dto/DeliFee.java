package dto;

public class DeliFee {
	//住所
	private String address1;
	//送料
	private int deliFee;
	
	public DeliFee(){
	}
	public DeliFee(String address1,int deliFee) {
		super();
		this.address1=address1;
		this.deliFee=deliFee;
		
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public int getDeliFee() {
		return deliFee;
	}
	public void setDeliFee(int deliFee) {
		this.deliFee = deliFee;
	}
	
	
	

}
