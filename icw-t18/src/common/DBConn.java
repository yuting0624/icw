package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class DBConn {
	private static final String DRIVER_NAME = "org.h2.Driver";
	// local開発用JDBC_URLを定義
	private static final String LOCAL_JDBC_URL = "jdbc:h2:tcp://localhost:9092/t18-db";
	// 本番用JDBC_URLを定義
	private static final String PROD_JDBC_URL = "jdbc:h2:tcp://my-h2-service.default.svc.cluster.local:9092/t18-db";
	private static final String USER = "sa";
	private static final String PASS = "sa";
	private static final String APP_ENV = getEnv("APP_ENV").orElse("");

	public static Connection getConn() throws SQLException {
		final String JDBC_URL = createJdbcUrl();

		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
				"JDBCドライバのロードに失敗しました");
		}
    return DriverManager.getConnection(JDBC_URL, USER, PASS);
	}

	/**
	 * JDBC_URLを環境変数を基に実行環境用URLを分岐
	 *
	 * @return JDBC_URL
	 */
	private static String createJdbcUrl() {
    switch (APP_ENV) {
      case "prod":
        return PROD_JDBC_URL;
      default:
        return LOCAL_JDBC_URL;
    }
	}

	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

  private static Optional<String> getEnv(String key) {
    return Optional.ofNullable(System.getenv(key));
  }
}