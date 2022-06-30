<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dto.Account, dto.Item, dao.AccountDAO, dao.ItemDAO"%>
 
<%
// セッションスコープからAccountオブジェクトを取得
Account account = (Account)session.getAttribute("account");
String accountId = "";
String accountPw = "";
String accountName = "";
String postalCode= "";
String address1 = "";
String address2 = "";
String phoneNumber = "";

// セッションスコープからProductオブジェクトを取得
Item item = (Item)session.getAttribute("item");
String image =""; 
String name = "";
int price = 0;
//String deliFee ="";
//String amount ="";


// Accountオブジェクトが取得できた時の処理(確認画面から戻た時の処理。初回リクエスト時はAccountオブジェクトは取得できない)
if(account != null){
	name = account.getAccountName();
	postalCode = account.getPostalCode();
	address1 = account.getAddress1();
	address2 = account.getAddress2();
	phoneNumber = account.getPhoneNumber();
}

//Itemオブジェクトが取得できた時の処理(確認画面から戻た時の処理。初回リクエスト時はAccountオブジェクトは取得できない)
if(item != null){
	image = item.getImage_url();
	name = item.getName();
	price = item.getPrice();
	//deliFee = item.getDeliFee();
	//amount = item.getAmount();
}

// エラーメッセージをリクエストスコープから取得
String errorMsg = (String)request.getAttribute("errorMsg");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy</title>
</head>
<body>

<form action="RegisterConfirm" method="post">


商品名 <input type="text" name="name" value="<%= name %>"><br>
価格<input type="text" name="price" value="<%= price %>"><br>
<!-- 送料<input type="text" name="deliFee" value="<%= deliFee %>"><br>
商品注文数<input type="text" name="amount" value="<%= amount %>"><br> -->

名前 <input type="text" name="name" value="<%= accountName %>"><br>
郵便番号<input type="text" name="postalCode" value="<%= postalCode %>"><br>
住所<input type="text" name="address" value="<%= address2 %>"><br>
番号<input type="text" name="number" value="<%= phoneNumber %>"><br>
<!-- 支払い方法<input type="text" name="payment" value="<%= payment %>"> -->

<input type="submit" value="確認">
<input type="submit" value="戻る">


</form>
</body>
</html>

