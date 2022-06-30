<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dto.Item,dto.Account"%>
    
    <%
// セッションスコープからItemオブジェクトを取得
Account account = (Account)session.getAttribute("account");
Item item = (Item)session.getAttribute("item") ;
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細画面</title>
</head>
<body>
<p>
<%= item.getCategory() %><br>
<%= item.getName() %><br>
<%= item.getImage_url() %><br>
<%= item.getPrice() %><br>
<%= item.getComment() %><br>

</p>
<a href="SearchResult.jsp">戻る</a>
//個数を入れてBuy.jspに遷移
<form action="Buy" method="get">
<input type="number" name="amount">個
</form>
</body>
</html>