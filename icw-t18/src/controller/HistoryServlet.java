
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;
import dto.History;
import model.HistoryLogic;

@WebServlet("/HistoryServlet")
public class HistoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		// セッションスコープからアカウントIDを取得
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("account");
		
		// 検索を依頼
		HistoryLogic logic = new HistoryLogic();
		List<History> historyList = logic.process(account.getAccountId());
		
		//History history = logic.process(account.getAccountId());
		
		
		//　セッションスコープに格納
		session.setAttribute("history", historyList);
		
		
		// フォワード
		request.getRequestDispatcher("history.jsp").forward(request, response);
		
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
