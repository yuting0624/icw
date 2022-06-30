package dto;

public class Account {
	/**　ユーザーID */
	private String accountId;
	
	/** パスワード */
	private String accountPw;

	/** 名前 */
	private String accountName;

	/** ローマ字 */
	private String romaji;

	/** 性別 */
	private String gender;

	/** 誕生日 */
	private String birthday;

	/** 郵便番号 */
	private String postalCode;
	
	// 地域区分
	private String address1;
	
	// 住所
	private String address2;
	
	// 電話番号
	private String phoneNumber;
	
	private int deliFee ;

	public Account() {
		
	}
	
	public Account(String accountId, String accountPw, String accountName, String romaji, String gender,
			String birthday, String postalCode, String address1, String address2, String phoneNumber) {
		super();
		this.accountId = accountId;
		this.accountPw = accountPw;
		this.accountName = accountName;
		this.romaji = romaji;
		this.gender = gender;
		this.birthday = birthday;
		this.postalCode = postalCode;
		this.address1 = address1;
		this.address2 = address2;
		this.phoneNumber = phoneNumber;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountPw() {
		return accountPw;
	}

	public void setAccountPw(String accountPw) {
		this.accountPw = accountPw;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getRomaji() {
		return romaji;
	}

	public void setRomaji(String romaji) {
		this.romaji = romaji;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getDeliFee() {
		return deliFee;
	}
	
	public void setDeliFee(int deliFee) {
		this.deliFee = deliFee;
	}


}
