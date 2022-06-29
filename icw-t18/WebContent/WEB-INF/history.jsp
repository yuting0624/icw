<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import=dto.History,java.util.List %>

<%
// リクエストスコープから注文履歴を取得
List<History> history =(List<History>)request.getAttribute("history");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文履歴一覧</title>
</head>
<body>
<p>
注文日時: <%= history.getOrderDate() %><br>
注文ID: <%= history.getOrderId() %><br>
<!--商品名: <%= history.getProduct_name() %><br>-->
注文数: <%= history.getOrderAmount() %><br>
支払い金額: <%= history.getTotalPrice() %><br>
ステータス: <%= history.getDeliStatus() %><br>
</p>
<a href="index">トップへ戻る</a>

</body>
</html>
