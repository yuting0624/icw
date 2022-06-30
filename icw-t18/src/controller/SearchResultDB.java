package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Item;
import model.SearchLogicDB;

/**
 * Servlet implementation class Search
 */
@WebServlet("/SearchResultDB")
public class SearchResultDB extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//検索キーワードの文字列受け取る
		String inputKeyword = request.getParameter("keyword");
		// カテゴリーチェックボックスの受け取り（チェックボックスは複数選択に対応するため、Stringの配列として送信される。）
		String[] inputCategory = request.getParameterValues("category");
		String Category;
		
		// カテゴリー情報を、APIでの検索に使えるようにまとめる
		if (inputCategory == null) {
			Category = "VEGETABLE&category=JUICE&category=FRUIT";
		} else {
			Category = inputCategory[0];
			for (int i = 1; i < inputCategory.length; i++) {
				Category += "&category=" + inputCategory[i];
			}
		}
		/*
		//sortの設定
		String sort="id";
		sort=request.getParameter("sort");
		
		//orderの設定
		String order="asc";
		order=request.getParameter("order");
		*/
		
		SearchLogicDB logic = new SearchLogicDB();
		List<Item> itemList = new ArrayList<>();
		try {
			itemList = logic.process(inputKeyword);
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

		System.out.println(itemList);
		HttpSession session =request.getSession();
		session.setAttribute("itemList",itemList);
		request.getRequestDispatcher("/SearchResultDB.jsp").forward(request, response);
			}
	}


