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

/**
 * Servlet implementation class BuyCon
 */
@WebServlet("/BuyCon")
public class BuyCon extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		Item item =(Item)session.getAttribute("item");		
		
		request.getRequestDispatcher("WEB-INF/buyConfirm.jsp").forward(request, response);
	}

}
