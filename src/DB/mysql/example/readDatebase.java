package DB.mysql.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class readDatebase {
	 static String url = "jdbc:mysql://localhost:3306/quote?characterEncoding=utf8"; //  ?characterEncoding=utf8 是数据库的编码格式；
	 Connection con = null; //定义连接名
	 PreparedStatement ps; //sql语句，创建操作对象
	 ResultSet rs;  //结果集
	 //定义变量
	 String name;
		public List<Tb_customer> readdb() {
			//声明一个容器，来存放这个类
			List<Tb_customer> list=new ArrayList<>();
			//加载数据库驱动
			try{
				//加载驱动
				Class.forName("com.mysql.jdbc.Driver");
				//建立连接
				con =DriverManager.getConnection(url,"root","123456");
				//发送查询语句
				ps=con.prepareStatement("Select * from tb_order ");//where otherInfo=?
				//第一个?里的内容为“haha”
			//	ps.setString(1, "haha");
				//执行sql语句
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
				//由里层向外层关闭
				rs.close();
				ps.close();
				con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
			return list;
		}
		
		public List<Tb_customer> readdbOther() {
			//声明一个容器，来存放这个类
			List<Tb_customer> list=new ArrayList<>();
			//加载数据库驱动
			try{
				//加载驱动
				Class.forName("com.mysql.jdbc.Driver");
				//建立连接
				con =DriverManager.getConnection(url,"root","123456");
				//发送查询语句
				ps=con.prepareStatement("Select * from tb_producttype ");//where otherInfo=?
				//第一个?里的内容为“haha”
			//	ps.setString(1, "haha");
				//执行sql语句
				rs=ps.executeQuery();
				while (rs.next()){
					Tb_customer order=new Tb_customer();
					order.setProNO(rs.getInt("producttypeNO"));
					//name=rs.getString("orderNO");
				order.setProName(rs.getString("producttypeName"));

				list.add(order);

				}
				//由里层向外层关闭
				rs.close();
				ps.close();
				con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
			return list;
		}
public void Updatesql(){


			//加载数据库驱动
			try{
				//加载驱动
				Class.forName("com.mysql.jdbc.Driver");
				//建立连接
				con =DriverManager.getConnection(url,"root","123456");
				//发送查询语句
				ps=con.prepareStatement("Update tb_order SET otherInfo=? Where orderNO=?");
				//第一个?里的内容为“haha”
				ps.setString(1, "易易");
				ps.setInt(2,1010121 );
				//执行sql语句
				ps.executeUpdate();
				

				//由里层向外层关闭
				ps.close();
				con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	

	
}
//插入信息

public void Insertsql(){

	//加载数据库驱动
	try{
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//建立连接
		con =DriverManager.getConnection(url,"root","123456");
		//发送查询语句
		ps=con.prepareStatement("insert into tb_producttype values(?,?)");
		//第一个?里的内容为“haha”
		
		ps.setInt(1,007 );
		ps.setString(2, "易易");
	

		//执行sql语句
		ps.executeUpdate();
		

		//由里层向外层关闭
		ps.close();
		con.close();
	}catch(Exception e){
	e.printStackTrace();
}

	
}
//删除信息

public void Deletesql(){
	//加载数据库驱动
	try{
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//建立连接
		con =DriverManager.getConnection(url,"root","123456");
		//发送查询语句
		ps=con.prepareStatement("delete from tb_order where orderNO=?");
		ps.setInt(1,1010124 );
		//执行sql语句
		ps.executeUpdate();
		

		//由里层向外层关闭
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
