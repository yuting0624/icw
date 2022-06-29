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
 * Servlet implementation class Detail
 */
@WebServlet("/Detail")
public class Detail extends HttpServlet {

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		

		HttpSession session =request.getSession();
		Item item = (Item) session.getAttribute("item");
		Account account = (Account) session.getAttribute("account");
		account=item;
		session.setAttribute("account", account);
		
		
		request.getRequestDispatcher("WEB-INF/Detail.jsp").forward(request, response);
		
		
		
		
		
		
		
		
	}

	

}
