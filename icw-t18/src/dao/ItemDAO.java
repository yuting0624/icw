package dao;

	import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import dto.Item;
import dto.ItemList;

	public class ItemDAO {
		public ItemList search(String keyword, String category, int priceMin, int priceMax, int offset, int limit, String sort, String order) throws Exception {
			List<Item> list = new ArrayList<Item>();
			ItemList itemList = new ItemList();
			// WebAPIにリクエストを送信（基本的に決まり文句）リクエスト先のURIだけ変更する。
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					// 使うAPIに応じて以下のURLを変更。「api/」以降の文字で商品検索APIを使うのか在庫引当APIを使うのか変わる。
					.uri(URI.create("http://159.122.178.105:30763/api/products" + "?name=" + keyword + "&category="
							+ category + "&minprice=" + priceMin + "&maxprice=" + priceMax + "&offset=" + offset
							+ "&limit=" + limit+ "&sort=" + sort+ "&order=" + order))
					.header("Accept", "application/json")// リクエストヘッダー（レスポンスの形式を指定。ここではJSON）
					.GET().build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("http://159.122.178.105:30763/api/products" + "?name=" + keyword + "&category="
							+ category + "&minprice=" + priceMin + "&maxprice=" + priceMax + "&offset=" + offset
							+ "&limit=" + limit+ "&sort=" + sort+ "&order=" + order);
			int statusCode = response.statusCode();//ステータスコード：200なら成功、400なら失敗など
			String responseBody = response.body();
			
			System.out.println("ステータスコード:" + statusCode);
			System.out.println("レスポンスボディ:" + responseBody);
			
			// WEB APIが処理に成功した時の処理（ステータスコードが200のとき）
			if (statusCode == 200) {
				// レスポンスボディ(JSON)をJsonNodeオブジェクトに変換
				ObjectMapper mapper = new ObjectMapper();
				JsonNode node = mapper.readTree(responseBody);
				
				// レスポンスボディの中から検索ヒット数（matched）を格納する。
				itemList.setNumber(String.valueOf(node.get("matched").longValue()));
				// JsonNodeからArrayNodeを取得（JSONの中からリスト部分だけを抽出。ここではproductsのリストを指定）
				ArrayNode arrayNode = (ArrayNode) node.get("items");
				
				// 取得した商品リストを最初に用意した格納場所に格納
				for (JsonNode p : arrayNode) {
					list.add(new Item(p.get("id").textValue(), p.get("category").textValue(), p.get("name").textValue(),
							p.get("kana").textValue(), p.get("price").intValue(), p.get("comment").textValue(),
							p.get("image_url").textValue()));
				}
				itemList.setItems(list);
				return itemList;
			}
			else {
				throw new Exception();
			}
		}
		public Item selectByKey(String id) throws Exception {
			// public static void main(String[] args) {
			Item item = new Item();

			// String keyword="01";
			// WebAPIにリクエストを送信（基本的に決まり文句）リクエスト先のURIだけ変更する。
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://159.122.178.105:30763/api/products" + id))// リクエスト先
					.header("Accept", "application/json")// リクエストヘッダー
					.GET().build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			int statusCode = response.statusCode();
			String responseBody = response.body();
			System.out.println("ステータスコード:" + statusCode);
			System.out.println("レスポンスボディ:" + responseBody);
			
			// WEB APIが処理に成功した時の処理
			if (statusCode == 200) {
				// レスポンスボディ(JSON)をJsonNodeオブジェクトに変換
				ObjectMapper mapper = new ObjectMapper();
				JsonNode node = mapper.readTree(responseBody);
				// JsonNodeからArrayNodeを取得
				item.setItemId(node.get("id").textValue());
				item.setCategory(node.get("category").textValue());
				item.setName(node.get("name").textValue());
				item.setKana(node.get("kana").textValue());
				item.setPrice(node.get("price").intValue());
				item.setComment(node.get("comment").textValue());
				item.setImage_url(node.get("image_url").textValue());
			}
			return item;
			
			}
		
			public List<Item> searchByName(String name) throws SQLException {
				// STEP 0:JDBCドライバの有効化
				DBUtil db = new DBUtil();

				Connection con = null;
				try {
					// STEP 1:データベースの接続
					con = db.getConnection();

					// STEP 2:SQL送信処理
					String sql = "SELECT * FROM ITEM WHERE NAME=? ";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1,  name);
					ResultSet rs = pstmt.executeQuery();
					List<Item> list = new ArrayList<>();
					while(rs.next()) {
						Item item = new Item();
						item.setItemId(rs.getString("ITEMID"));
						item.setCategory(rs.getString("CATEGORY"));
						item.setName(rs.getString("NAME"));
						item.setPrice(rs.getInt("PRICE"));
						item.setComment(rs.getString("COMMENT"));
						item.setImage_url(rs.getString("IMAGE_URL"));

						list.add(item);
					}
					pstmt.close();
					return list;
				} finally {
					// STEP 3:データベースとの接続を切断
					db.closeConnection(con);
				}
			}
	
			public List<Item> searchById(String itemId) throws SQLException {
				// STEP 0:JDBCドライバの有効化
				DBUtil db = new DBUtil();

				Connection con = null;
				try {
					// STEP 1:データベースの接続 
					con = db.getConnection();

					// STEP 2:SQL送信処理
					String sql = "SELECT * FROM ITEM WHERE ID=? ";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1,  itemId);
					ResultSet rs = pstmt.executeQuery();
					List<Item> list = new ArrayList<>();
					while(rs.next()) {
						Item item = new Item();
						item.setItemId(rs.getString("ITEMID"));
						item.setCategory(rs.getString("CATEGORY"));
						item.setName(rs.getString("NAME"));
						item.setPrice(rs.getInt("PRICE"));
						item.setComment(rs.getString("COMMENT"));
						item.setImage_url(rs.getString("IMAGE_URL"));

						list.add(item);
					}
					pstmt.close();
					return list;
				} finally {
					// STEP 3:データベースとの接続を切断
					db.closeConnection(con);
				}
			}
			public List<Item> searchByNameDB(String name) throws SQLException {
					List<Item> list = new ArrayList<>();
					for(int i = 1; i<3 ; i++) {
						Item item = new Item();
						item.setItemId("IDa");
						item.setCategory("Cate1");
						item.setName("Name1");
						item.setPrice(1111);
						item.setComment("comment");
						item.setImage_url("./img/products/tomato.jpg");
						
						
						
						list.add(item);
						System.out.println(list.get(0));
					}
					System.out.println(list);
					return list;
			}
		}


