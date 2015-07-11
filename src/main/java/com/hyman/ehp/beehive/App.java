package com.hyman.ehp.beehive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 */
public class App 
{
	public static final String DRIVER_NAME="org.apache.hive.jdbc.HiveDriver";
	public static final String URL="jdbc:hive2://hadoop-ehp.hyman.com:10000/default";
	public static final String USERNAME="ehp";
	public static final String PASSWORD="ehp";
	
	
    public static void main( String[] args ) throws Exception
    {
    	Class.forName(DRIVER_NAME);
		Connection conn =DriverManager.getConnection(URL, USERNAME, PASSWORD);
		Statement stmt = conn.createStatement();
		
		String sql = "select * from dept left join emp on dept.deptno=emp.empno";
		
		//String sql1 = "CREATE TABLE t2 (id INT ,name STRING) ROW FORMAT DELIMITED FIELDS TERMINATED BY '\t'";
		
		//stmt.executeUpdate(sql1);
		
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}

		rs.close();
		stmt.close();
		conn.close();
        
    }
}