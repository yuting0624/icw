package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.ItemList;
import model.SearchLogic;

/**
 * Servlet implementation class Search
 */
@WebServlet("/SearchResult")
public class SearchResult extends HttpServlet {
	
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
		// 価格下限と価格上限はint型に変更した上で格納。
		int inputPriceMin = 0;
		//もし下限が空欄の場合は0を格納
		if (request.getParameter("priceMin").equals("")) {
			inputPriceMin = 0;
		} else {
			inputPriceMin = Integer.parseInt(request.getParameter("priceMin"));
		}
		int inputPriceMax = 0;
		//もし上限が空欄の場合は100000を格納（全て検索にヒットさせるため）
		if (request.getParameter("priceMax").equals("")) {
			inputPriceMax = 99999;
		} else {
			inputPriceMax = Integer.parseInt(request.getParameter("priceMax"));
		}
		
		//offset=ヒット件数の何番目の値かた取得するか
		int offset = Integer.parseInt(request.getParameter("offset"));
		//limit＝ヒット件数が多い場合に、数を絞る
		int limit = 10;
		
		//sortの設定
		String sort="id";
		sort=request.getParameter("sort");
		
		//orderの設定
		String order="asc";
		order=request.getParameter("order");
		
		
		SearchLogic logic = new SearchLogic();
		ItemList itemList = new ItemList();
		
		HttpSession session =request.getSession();
		session.setAttribute("items",itemList);
		try {
			itemList = logic.process(inputKeyword, Category, inputPriceMin, inputPriceMax, offset, limit, sort, order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("productsList", itemList);
		request.setAttribute("keyword", inputKeyword);
		request.setAttribute("category", Category);
		request.setAttribute("priceLow", inputPriceMin);
		request.setAttribute("priceHigh", inputPriceMax);
		request.setAttribute("offset", offset);
		request.setAttribute("sort", sort);
		request.setAttribute("order", order);
		request.getRequestDispatcher("WEB-INF/SearchResult.jsp").forward(request, response);
			
			}
	}


