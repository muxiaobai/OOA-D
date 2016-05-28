package ooad.trad;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultUtil {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs;
	public ResultUtil() {
		try {

			//this.conn = new SQLiteConn().getConnection();
			this.conn = new lianjie().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Object> findResult(String sql) {
		List<Object> result =new ArrayList<Object>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		//	rs=conn.createStatement().executeQuery(sql);
			String table=rs.getMetaData().getTableName(1);
			Class clazz = Class.forName("ooad.trad."+table.substring(0, 1).toUpperCase()+ table.substring(1));
			Object instance;
			while (rs.next()) {
				instance=clazz.newInstance();
				Field[] fields = clazz.getDeclaredFields();
				for (Field field : fields) {
					String column = field.getName();
					Class columnType=field.getType();
					//获取属性名
					String getMethodName = "set"+ column.substring(0,1).toUpperCase()+ column.substring(1);
					Method getMethod =clazz.getDeclaredMethod(getMethodName,columnType); //Integer.class,String.class
				// 	System.out.println("方法名:"+getMethodName);
				//	System.out.println("列类型:"+columnType+"列名:"+column+"=====》列值"+rs.getObject(column));
					getMethod.invoke(instance,rs.getObject(column));
					String rsMethodName=null;
					if(columnType.toString().length()>10){
						if(columnType.toString().substring(columnType.toString().length()-6,columnType.toString().length()).equals("String")){
							rsMethodName="get"+columnType.toString().substring(columnType.toString().length()-6,columnType.toString().length());
						}else if(columnType.toString().substring(columnType.toString().length()-9,columnType.toString().length()).equals("Timestamp")){
							rsMethodName="get"+columnType.toString().substring(columnType.toString().length()-9,columnType.toString().length());
						}else if(columnType.toString().substring(columnType.toString().length()-4,columnType.toString().length()).equals("Date")){
							rsMethodName="get"+columnType.toString().substring(columnType.toString().length()-4,columnType.toString().length());
						}else { }
					}else {
					 rsMethodName="get"+columnType.toString().substring(0,1).toUpperCase()+columnType.toString().substring(1);
					}
					//System.out.println(rsMethodName);
					}	
				result.add(instance);
			}
			this.pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
		Map<String, Object> searchData=new HashMap<String,Object>();
		Guitar guitar=new Guitar(); 
		searchData.put("pageNum", 20);
		searchData.put("pageSize",2);
	 	searchData.put("searchModel",guitar);
		ResultUtil rr=new ResultUtil();
		List map=rr.findResult(SqlUtil.doSelect(searchData));
		System.out.println(map.toString());
	}

}
