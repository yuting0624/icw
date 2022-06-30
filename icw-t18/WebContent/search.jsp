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
<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark"
			style="width: 100%; position: fixed; top: 0; z-index: 99;">
			<div class="container" style="font-size: 18px">
				<a class="navbar-brand" style="font-size: 32px" href="./index.html">豊田農園</a>
				<div class="collapse navbar-collapse" id="navbar">
					<ul class="navbar-nav mr-auto">
					</ul>
					<ul class="navbar-nav">
						<li class="nav-item active"><a class="nav-link"
							href="#"></a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
<form action = "SearchResult" method ="get">
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
<footer>
		(C) 豊田農園

		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
			integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
			crossorigin="anonymous"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
			integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
			integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
			crossorigin="anonymous"></script>
	</footer>
</body>
</html>