package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;
import dto.Item;
import model.ConfirmLogic;

/**
 * Servlet implementation class BuyConfirm
 */
@WebServlet("/BuyConfirm")
public class BuyConfirm extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		Item item =(Item)session.getAttribute("item");	
		
		
		ConfirmLogic confirmLogic =new ConfirmLogic();
		
		
		if (confirmLogic(true)) {
			request.getRequestDispatcher("WEB-INF/buyOK.jsp").forward(request, response);
		} 
		
		
	
	}

	private boolean confirmLogic(boolean b) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
