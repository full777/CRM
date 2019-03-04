package DB.mysql.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class readDatebase {
	 static String url = "jdbc:mysql://localhost:3306/quote?characterEncoding=utf8"; //  ?characterEncoding=utf8 �����ݿ�ı����ʽ��
	 Connection con = null; //����������
	 PreparedStatement ps; //sql��䣬������������
	 ResultSet rs;  //�����
	 //�������
	 String name;
		public List<Tb_customer> readdb() {
			//����һ������������������
			List<Tb_customer> list=new ArrayList<>();
			//�������ݿ�����
			try{
				//��������
				Class.forName("com.mysql.jdbc.Driver");
				//��������
				con =DriverManager.getConnection(url,"root","123456");
				//���Ͳ�ѯ���
				ps=con.prepareStatement("Select * from tb_order ");//where otherInfo=?
				//��һ��?�������Ϊ��haha��
			//	ps.setString(1, "haha");
				//ִ��sql���
				rs=ps.executeQuery();
				while (rs.next()){
					Tb_customer order=new Tb_customer();
					order.setOid(rs.getInt("orderNO"));
					//name=rs.getString("orderNO");
				order.setOtime(rs.getString("orderTime"));
				order.setOinfo(rs.getString("otherInfo"));
				order.setOq(rs.getString("quantity"));
				order.setOcNo(rs.getString("customerNO"));
				order.setoPNo(rs.getString("productNO"));
				list.add(order);

				}
				//����������ر�
				rs.close();
				ps.close();
				con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
			return list;
		}
		
		public List<Tb_customer> readdbOther() {
			//����һ������������������
			List<Tb_customer> list=new ArrayList<>();
			//�������ݿ�����
			try{
				//��������
				Class.forName("com.mysql.jdbc.Driver");
				//��������
				con =DriverManager.getConnection(url,"root","123456");
				//���Ͳ�ѯ���
				ps=con.prepareStatement("Select * from tb_producttype ");//where otherInfo=?
				//��һ��?�������Ϊ��haha��
			//	ps.setString(1, "haha");
				//ִ��sql���
				rs=ps.executeQuery();
				while (rs.next()){
					Tb_customer order=new Tb_customer();
					order.setProNO(rs.getInt("producttypeNO"));
					//name=rs.getString("orderNO");
				order.setProName(rs.getString("producttypeName"));

				list.add(order);

				}
				//����������ر�
				rs.close();
				ps.close();
				con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
			return list;
		}
public void Updatesql(){


			//�������ݿ�����
			try{
				//��������
				Class.forName("com.mysql.jdbc.Driver");
				//��������
				con =DriverManager.getConnection(url,"root","123456");
				//���Ͳ�ѯ���
				ps=con.prepareStatement("Update tb_order SET otherInfo=? Where orderNO=?");
				//��һ��?�������Ϊ��haha��
				ps.setString(1, "����");
				ps.setInt(2,1010121 );
				//ִ��sql���
				ps.executeUpdate();
				

				//����������ر�
				ps.close();
				con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	

	
}
//������Ϣ

public void Insertsql(){

	//�������ݿ�����
	try{
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		//��������
		con =DriverManager.getConnection(url,"root","123456");
		//���Ͳ�ѯ���
		ps=con.prepareStatement("insert into tb_producttype values(?,?)");
		//��һ��?�������Ϊ��haha��
		
		ps.setInt(1,007 );
		ps.setString(2, "����");
	

		//ִ��sql���
		ps.executeUpdate();
		

		//����������ر�
		ps.close();
		con.close();
	}catch(Exception e){
	e.printStackTrace();
}

	
}
//ɾ����Ϣ

public void Deletesql(){
	//�������ݿ�����
	try{
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		//��������
		con =DriverManager.getConnection(url,"root","123456");
		//���Ͳ�ѯ���
		ps=con.prepareStatement("delete from tb_order where orderNO=?");
		ps.setInt(1,1010124 );
		//ִ��sql���
		ps.executeUpdate();
		

		//����������ر�
		ps.close();
		con.close();
	}catch(Exception e){
	e.printStackTrace();
}

}
	public static void main(String[] args)  {

		readDatebase db=new readDatebase();
		//System.out.println(db.readdb());
		
		//db.Updatesql();

		//db.Deletesql();
		/*
		for(int i=0;i<db.readdb().size();i++){
			System.out.println(db.readdb().get(i).getOid()+"\t"+db.readdb().get(i).getOtime()+"\t"+db.readdb().get(i).getOinfo());
		}
		*/
		db.Insertsql();
		for(int i=0;i<db.readdbOther().size();i++){
			System.out.println(db.readdbOther().get(i).getProNO()+"\t"+db.readdbOther().get(i).getProName());
		}
		
		
	}

}
