<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dto.Account, dto.Item, dao.AccountDAO, dao.ItemDAO"%>
 
<%
//セッションスコープからAccountオブジェクトを取得
Account account = (Account)session.getAttribute("account");
String accountId = "";
String accountPw = "";
String accountName = "";
String postalCode= "";
String address1 = "";
String address2 = "";
String phoneNumber = "";

//セッションスコープからProductオブジェクトを取得
Item item = (Item)session.getAttribute("item");
String image =""; 
String name = "";
int price = 0;
//String deliFee ="";
//String amount ="";


//Accountオブジェクトが取得できた時の処理(確認画面から戻た時の処理。初回リクエスト時はAccountオブジェクトは取得できない)
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
<title>BuyConfirm</title>
</head>
<body>

<form action="BuyConfirm" method="get">
画像
商品名 <%= item.getName() %><br>
価格<%= item.getPrice() %><br>
送料<%= %><br>
商品注文数<%= %><br>
総額<%= %><br>
顧客情報<br>
名前 <%= account.getAccountName() %><br>
郵便番号<%= account.getPostalCode() %><br>
住所<%= account.getAddress2() %><br>
電話番号<%= account.getPhoneNumber() %><br>
支払方法<br>
銀行振込<%= %><br>
振込先口座<%= %><br>


<input type="submit" value="購入">
<input type="submit" value="戻る">



</form>

</body>
</html>