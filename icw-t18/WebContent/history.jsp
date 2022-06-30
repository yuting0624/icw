<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dto.History, java.util.List" %>

<%
// リクエストスコープから注文履歴を取得
List<History> list =(List<History>) request.getAttribute("history");

//String orderDate =(String) request.getAttribute("orderDate");
//String orderId =(String) request.getAttribute("orderId");
//int orderAmount =(int) request.getAttribute("orderAmount");
//int totalPrice =(int) request.getAttribute("totalPrice");
//String deliStatus =(String) request.getAttribute("deliStatus");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文履歴一覧</title>
</head>
<body>
<p>
<% for(History history : list){ %>

注文日時: <%= history.getOrderDate() %><br>
注文ID: <%= history.getOrderId() %><br>
<!--商品名: <br>-->
注文数: <%= history.getOrderAmount() %><br>
支払い金額: <%= history.getTotalPrice() %><br>
ステータス: <%= history.getDeliStatus() %><br>
<% } %>
</p>
<a href="index">トップへ戻る</a>

</body>
</html>
