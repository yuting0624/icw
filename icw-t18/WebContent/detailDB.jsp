<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dto.Item,dto.Account"%>
    
    <%
// セッションスコープからProductオブジェクトを取得
Account account = (Account)session.getAttribute("account");
String category =""; 
String name = "";
String image_url= "";
int price = 0;
String comment = "";
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細画面</title>
</head>
<body>
<p>
<%= account.item.getCategory() %><br>
<%= account.item.getName() %><br>
<%= account.item.getImage_url() %><br>
<%= account.item.getPrice() %><br>
<%= account.item.getComment() %><br>

<a href="searchResult">戻る</a>
<a href="buy">購入</a>
</p>

</body>
</html>