package DB.mysql.UseDb.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DB.mysql.connection.Sqlconnection;

public class insertDatebase {

	Sqlconnection sqlconn;
	 public void Insertsql(){
		 sqlconn=new Sqlconnection();
	 	//加载数据库驱动
	 	try{
	 		
	 		sqlconn.connection();
	 		//发送查询语句
	 		sqlconn.ps=sqlconn.con.prepareStatement("insert into customer_info values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	 		//第一个?里的内容为“haha”
	 		
	 		sqlconn.ps.setInt(1,007 );
	 		sqlconn.ps.setInt(2,007 );
	 		sqlconn.ps.setInt(3,007 );
	 		sqlconn.ps.setInt(4,007 );
	 		sqlconn.ps.setInt(5,007 );
	 		sqlconn.ps.setString(2, "易易");
	 	

	 		//执行sql语句
	 		sqlconn.ps.executeUpdate();
	 		

	 		//由里层向外层关闭
	 		sqlconn.ps.close();
	 		sqlconn.con.close();
	 	}catch(Exception e){
	 	e.printStackTrace();
	 }

	 	
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
