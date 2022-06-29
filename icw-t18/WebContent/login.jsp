<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
    <p>ようこそ、ログインしてください</p>
<form action="Login" method="post">
ユーザーID <input type="text" name="id"><br>
パスワード <input type="text" name="pw"><br>
<input type="submit" value="ログイン">
//ユーザーID、パスワードを入力しないと画面遷移できないように
</form>

</body>
</html>