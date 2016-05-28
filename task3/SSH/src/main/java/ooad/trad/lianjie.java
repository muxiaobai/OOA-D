package ooad.trad;
import java.sql.Connection;
import java.sql.DriverManager;
public class lianjie {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "123456";
	private Connection conn;

	public lianjie() throws Exception {
		Class.forName(DBDRIVER);
	
		this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
	}

	public Connection getConnection() {
		
		return this.conn;
	}

	public void close() throws Exception {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (Exception e) {
				throw e;
			}
		}
	}
}
