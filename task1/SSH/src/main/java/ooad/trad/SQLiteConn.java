package ooad.trad;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteConn {
	private static final String FILENAME = "D:/SQLite/test.db";
	private Connection conn;	           
	public SQLiteConn() throws Exception {
	    Class.forName("org.sqlite.JDBC");
       this.conn = DriverManager.getConnection("jdbc:sqlite:"+FILENAME);
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
