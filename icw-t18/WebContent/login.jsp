<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/common.css">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>ログイン</title>
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
							href="./register.html">会員登録</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<form action="Login" method="post">
	<div class="container contentpadmar">
		<div class="row">
			<div class="col-md-12" style="padding: 0">
				<div class="card border-0">
					<div class="card-body text-center">
						<p class="card-text">ようこそ、ログインしてください</p>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="offset-md-2 col-md-8">
				<div class="card">
					<div class="card-header">ログイン</div>
					<div class="card-body">
						<div class="form-group row">
							<label class="control-label col-md-4">ユーザID</label> <input
								class="form-control col-md-8 " placeholder="Enter ID"type="text" id="id" name="id" />
						</div>
						<div class="form-group row">
							<label class="control-label col-md-4">パスワード</label> <input
								class="form-control col-md-8" type="password" id="password"	name="pw" />
						</div>

						<div class="form-group">
							<input type="submit" value="ログイン" class="btn btn-primary">
						</div>
					</div>
				</div>
			</div>
		</div>
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