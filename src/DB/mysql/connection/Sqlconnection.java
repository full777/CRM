package DB.mysql.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sqlconnection {
	public static String url = "jdbc:mysql://localhost:3306/crm?characterEncoding=utf8"; //  ?characterEncoding=utf8 是数据库的编码格式；
	public  static Connection con = null; //定义连接名
	 public PreparedStatement ps; //sql语句，创建操作对象
	public  ResultSet rs;  //结果集
	public  ResultSet rs2;  //结果集
	 //定义变量
	 String name;
	 
public Connection connection(){
try{
	Class.forName("com.mysql.jdbc.Driver");
	//建立连接
	con =DriverManager.getConnection(url,"root","123456");
}catch(Exception e){
	e.printStackTrace();
}
return con;
}

}
