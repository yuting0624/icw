package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;
import dto.DeliFee;
import model.DeliFeeLogic;

/**
 * Servlet implementation class Buy
 */
@WebServlet("/Buy")
public class Buy extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		HttpSession session =request.getSession();
		Account account = (Account) session.getAttribute("account");
		
		DeliFeeLogic buylogic = new DeliFeeLogic();
		DeliFee deliFee=buylogic.buylogic(account,amount);
		
		request.getRequestDispatcher("WEB-INF/buy.jsp").forward(request, response);
		
	}

}
