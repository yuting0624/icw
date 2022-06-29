<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "dto.Item, dto.ItemList, java.util.List" %>
    <%
//検索にヒットした商品数と、商品リストを受け取る
ItemList itemListNumber = (ItemList) request.getAttribute("itemList");

//商品数情報を取り出す
int matched = Integer.parseInt(itemListNumber.getNumber());
//商品リストを取り出す
List<Item> itemList = itemListNumber.getItems();

int offset = (int) request.getAttribute("offset");
//int offset = Integer.parseInt(offsetString);
String category = (String) request.getAttribute("category");
String keyword = (String) request.getAttribute("keyword");
int priceMin = (int) request.getAttribute("priceMin");
int priceMax = (int) request.getAttribute("priceMax");
String order = (String) request.getAttribute("order");
String sort = (String) request.getAttribute("sort");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/common.css">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>検索結果</title>
<script>
	function add() {
		// 商品検索ロジックの呼び出し
		SearchLogic logic = new SearchLogic();
		// 取得した商品リストの格納場所を準備
		ItemList itemList=new ItemList();
		try {
			// 商品検索処理を実行
			itemList = logic.process(inputKeyword, Category, inputPriceMin, inputPriceMax,offset, limit);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		List<Item> itemLists=itemList.getItem();
		for (Item item : itemLists) {
			item.getCategory();
		}
	}
</script>
</head>
<body>
ヒット数：<%=matched%>
			<%=offset + 1%>～<%
			if (offset + 10 > matched) {
			%><%=matched%>
			<%
			;
			} else {
			%><%=offset + 10%>
			<%
			;
			}
			%>件を表示中<br>
			
			<p></p>
<form action="SearchServlet" method="get">
				<input type="submit" value="商品検索画面へ戻る">
			</form>
		
			<font size="2"> <a
				href="SearchResult?category=<%=category%>&keyword=<%=keyword%>&priceMin=<%=priceMin%>&priceMax=<%=priceMax%>&offset=<%=offset%>&sort=name&order=asc">商品名：昇順</a>
				<a
				href="SearchResult?category=<%=category%>&keyword=<%=keyword%>&priceMin=<%=priceMin%>&priceMax=<%=priceMax%>&offset=<%=offset%>&sort=name&order=desc">商品名：降順</a>
				<a
				href="SearchResult?category=<%=category%>&keyword=<%=keyword%>&priceMin=<%=priceMin%>&priceMax=<%=priceMax%>&offset=<%=offset%>&sort=price&order=asc">価格：昇順</a>
				<a
				href="SearchResult?category=<%=category%>&keyword=<%=keyword%>&priceMin=<%=priceMin%>&priceMax=<%=priceMax%>&offset=<%=offset%>&sort=price&order=desc">価格：降順</a>
			</font>
<table>
				<tr>
					<th>カテゴリー　</th>
					<th>　商品名　</th>
					<th>　価格　</th>
					<th>　商品画像　</th>
				</tr>
				<%for (Item item : itemList) {%>
				<tr>
					<td><%=item.getCategory()%></td>
					<td>　
							<a> <%=item.getName()%> <%
 %></a></td>
					<td align="right"><%=item.getPrice()%>円　</td>
					<td align="center"><img src="<%=item.getImage_url()%>"
						height=35></td>
				</tr>
				<%}%>
			</table>
<%
			if (offset == 0) {
			} else {
			%>
			<a
				href="SearchResult?category=<%=category%>&keyword=<%=keyword%>&priceMin=<%=priceMin%>&priceMax=<%=priceMax%>&offset=<%=offset - 10%>&sort=<%=sort%>&order=<%=order%>">前へ</a>
			<%
			}
			if (offset + 10 >= matched) {
			} else {
			%>
			<a
				href="SearchResult?category=<%=category%>&keyword=<%=keyword%>&priceMin=<%=priceMin%>&priceMax=<%=priceMax%>&offset=<%=offset + 10%>&sort=<%=sort%>&order=<%=order%>">次へ</a>
			<%}%>
</body>
</html>