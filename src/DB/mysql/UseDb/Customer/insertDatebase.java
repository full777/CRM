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
	 	//�������ݿ�����
	 	try{
	 		
	 		sqlconn.connection();
	 		//���Ͳ�ѯ���
	 		sqlconn.ps=sqlconn.con.prepareStatement("insert into customer_info values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	 		//��һ��?�������Ϊ��haha��
	 		
	 		sqlconn.ps.setInt(1,007 );
	 		sqlconn.ps.setInt(2,007 );
	 		sqlconn.ps.setInt(3,007 );
	 		sqlconn.ps.setInt(4,007 );
	 		sqlconn.ps.setInt(5,007 );
	 		sqlconn.ps.setString(2, "����");
	 	

	 		//ִ��sql���
	 		sqlconn.ps.executeUpdate();
	 		

	 		//����������ر�
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
