package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;
import model.LoginLogic;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("getでのエラー");
		request.getRequestDispatcher("error.jsp").forward(request, response);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// リクエストパラメータを取得
			request.setCharacterEncoding("UTF-8");
			String accountId = request.getParameter("id");
			String accountPw = request.getParameter("pw");
			
			// userIdに入力があった場合
			if (accountId != null) {
				
			// 検索を依頼
			LoginLogic logic = new LoginLogic();
			Account account = logic.login(accountId);
			
			// IDとPWの検証
			if (account.getAccountId().equals(accountId) && account.getAccountPw().equals(accountPw)) {
				// セッションスコープにアカウントを格納
				HttpSession session = request.getSession();
				session.setAttribute("account", account);
				
				//フォワード
				request.getRequestDispatcher("index.html").forward(request, response);
			} else {
				//idまたはパスワードが不正
				request.getRequestDispatcher("loginError.jsp").forward(request, response);
			}
			
			}
		} catch(SQLException e) {
			// フォワード
			e.printStackTrace();		
			System.out.println("postでのエラー");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}	
	}
	
}
