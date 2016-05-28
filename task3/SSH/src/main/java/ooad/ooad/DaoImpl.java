package ooad.ooad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoImpl {
	private Connection conn=null;
	private PreparedStatement pstmt = null;

	public DaoImpl() {
		try {
			conn=new lianjie().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("conn异常");
		}

	}
	@SuppressWarnings("null")
	public List<Guitar> getData(){
		List<Guitar> guitars=new ArrayList<Guitar>();
		String sql = "SELECT * FROM guitar";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Guitar guitar=new Guitar();
			guitar.setId(rs.getInt("id"));
			guitar.setPrice(rs.getDouble("price"));
			Map<String, Object> guitarSpecMap=new HashMap<String, Object>();
			guitarSpecMap.put("backwood", rs.getString("backwood"));
			guitarSpecMap.put("topwood", rs.getString("topwood"));
			guitarSpecMap.put("type", rs.getString("type"));
			guitarSpecMap.put("builder", rs.getString("builder"));
			guitarSpecMap.put("guitarmodel", rs.getString("guitarmodel"));
			guitar.setGuitarSpecMap(guitarSpecMap);
			guitars.add(guitar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return guitars;
	
	}
}
