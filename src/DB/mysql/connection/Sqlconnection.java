package DB.mysql.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sqlconnection {
	public static String url = "jdbc:mysql://localhost:3306/crm?characterEncoding=utf8"; //  ?characterEncoding=utf8 �����ݿ�ı����ʽ��
	public  static Connection con = null; //����������
	 public PreparedStatement ps; //sql��䣬������������
	public  ResultSet rs;  //�����
	public  ResultSet rs2;  //�����
	 //�������
	 String name;
	 
public Connection connection(){
try{
	Class.forName("com.mysql.jdbc.Driver");
	//��������
	con =DriverManager.getConnection(url,"root","123456");
}catch(Exception e){
	e.printStackTrace();
}
return con;
}

}
