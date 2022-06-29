<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品検索</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/common.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<style>
body {
    margin: 0;
	padding: 90px 0%;
}

main {
	margin: 0px 10%;
}

.container {
	width: 90%;
	text-align: center;
}

.first-sentence {
	font-weight: bold;
}


</style>
</head>
<body>
<form action = "SearchResult" method ="get">
<a href = "index.html">トップへ</a>
<div class="row">
				<div class="col-md-12">
					<div class="card border-0">
						<div class="card-body text-center"></div>
					</div>
				</div>
			</div>
			<!-- <h2 id="title">商品検索</h2> -->
			<div align="center">
		    <header id="title"><font size="6">商品検索</font></header>
			<p class="card-text">検索条件をご入力し、検索ボタンを押してください</p>
			<p class="form-check">
				●カテゴリーを選択する（未入力の場合は全カテゴリーで検索）<br> <input class="form-check-input" type="checkbox"
					name="category" value="VEGETABLE" id="flexCheckDefault" checked>野菜 <input
					type="checkbox" name="category" value="FRUIT">フルーツ <input
					type="checkbox" name="category" value="JUICE">ジュース
			</p>
			<p>
				●キーワードを指定する <br> <input type="text" name="keyword" size=30><br>
				<font size="2">例：りんご</font>
			</p>
			<p>
				●価格帯（本体価格）を指定する <br> <input type="number" name="priceMin"
					step=10 min=0 max=1000000 size=10 placeholder="数字を入力" onkeydown="return event.keyCode !== 69"> 円～ <input
					type="number" name="priceMax" step=10 min=0 max=999999 size=10
					placeholder="数字を入力" onkeydown="return event.keyCode !== 69">円
			</p>
			<input type="hidden" value="id" name="sort">
			<input type="hidden" value="asc" name="order">
			<input type="submit" value="この条件で検索">
			</div>
		</form>

</body>
</html>