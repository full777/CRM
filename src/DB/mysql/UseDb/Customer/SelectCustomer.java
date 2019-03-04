package DB.mysql.UseDb.Customer;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import DB.mysql.UseDb.Customer.table.Customer_info;
import DB.mysql.connection.Sqlconnection;

public class SelectCustomer {
	public static SelectCustomer select;
	Sqlconnection sqlconn;

	
//根据姓名查询
	
	public List<Customer_info > SelectdbMH(String sql) {

		sqlconn=new Sqlconnection();
		//声明一个容器，来存放这个类
		List<Customer_info > list=new ArrayList<>();
		//加载数据库驱动
		try{
			//sqlconn.connection();
			//发送查询语句
			sqlconn.ps=sqlconn.connection().prepareStatement(sql);
			//sqlconn.ps.setString(1, cname);
			sqlconn.rs=sqlconn.ps.executeQuery();
			while (sqlconn.rs.next()){
				Customer_info  order=new Customer_info ();

				order.setCustid(sqlconn.rs.getString("customer_id"));
				order.setCid(sqlconn.rs.getString("condition_id"));
				order.setSid(sqlconn.rs.getString("source_id"));
				order.setUid(sqlconn.rs.getString("user_id"));
				order.setTid(sqlconn.rs.getString("type_id"));
				order.setCname(sqlconn.rs.getString("customer_name"));
				order.setCsex(sqlconn.rs.getString("customer_sex"));
				order.setCmobile(sqlconn.rs.getString("customer_mobile"));
				order.setCqq(sqlconn.rs.getString("customer_qq"));
				order.setCaddr(sqlconn.rs.getString("customer_address"));
				order.setCemail(sqlconn.rs.getString("customer_email"));
				order.setCmark(sqlconn.rs.getString("customer_remark"));
				order.setCjob(sqlconn.rs.getString("customer_job"));
				order.setCblog(sqlconn.rs.getString("customer_blog"));
				order.setCtel(sqlconn.rs.getString("customer_tel"));
				order.setCmsn(sqlconn.rs.getString("customer_msn"));
				order.setCbirth(sqlconn.rs.getString("birth_day"));
				order.setCaddtime(sqlconn.rs.getString("customer_addtime"));
				order.setCaddman(sqlconn.rs.getString("customer_addman"));
				order.setCctime(sqlconn.rs.getString("customer_changtime"));
				order.setCcman(sqlconn.rs.getString("change_man"));
				order.setCcomp(sqlconn.rs.getString("customer_company"));
				order.setCused(sqlconn.rs.getString("is_used"));

			list.add(order);

			}
			//由里层向外层关闭
			sqlconn.rs.close();
			sqlconn.ps.close();
			sqlconn.connection().close();
	}catch(Exception e){
		e.printStackTrace();
	}
		return list;
	}
	
	//当增加好一条客户信息时，一一对比全部信息，用一个list取出数据库的和页面对比

	public List<Customer_info > SelectCustAdd(String sql) {

		sqlconn=new Sqlconnection();
		List<Customer_info > list=new ArrayList<>();
		try{
			
		sqlconn.ps=sqlconn.connection().prepareStatement(sql);
		sqlconn.rs=sqlconn.ps.executeQuery();
		//声明一个容器，来存放这个类
		
		//加载数据库驱动
		
			Customer_info  order=new Customer_info ();

			while (sqlconn.rs.next()){
				//获取customer_condition表里的condition_name，页面中的状态
				sqlconn.ps=sqlconn.connection().prepareStatement("SELECT * FROM customer_condition	 where condition_id ="+ sqlconn.rs.getInt("condition_id"));
				
				sqlconn.rs2 = sqlconn.ps.executeQuery();
				if(sqlconn.rs2.next()){
					order.setCid(sqlconn.rs2.getString("condition_name"));
				}
				//获取customer_source表里的source_name，页面中的客户来源
				sqlconn.ps=sqlconn.connection().prepareStatement( "SELECT * FROM customer_source	 where source_id = "+  sqlconn.rs.getInt("source_id"));
				sqlconn.rs2 = sqlconn.ps.executeQuery();
				if(sqlconn.rs2.next()){
					order.setSid(sqlconn.rs2.getString("source_name"));
				}
				//获取user_info表里的user_name，页面中的所属员工
				sqlconn.ps=sqlconn.connection().prepareStatement( "SELECT * FROM user_info where user_id = "+sqlconn.rs.getInt("user_id") );
				sqlconn.rs2 = sqlconn.ps.executeQuery();
				if(sqlconn.rs2.next()){
				order.setUid(sqlconn.rs2.getString("user_name"));
				}
				
				//获取customer_type表里的type_name，页面中的类型
				sqlconn.ps=sqlconn.connection().prepareStatement( "SELECT * FROM customer_type	 where type_id =  "+ sqlconn.rs.getInt("type_id") );
				sqlconn.rs2 = sqlconn.ps.executeQuery();
				if(sqlconn.rs2.next()){
				order.setTid(sqlconn.rs2.getString("type_name"));
				}

				
				//order.setCid(sqlconn.rs.getInt("condition_id"));
				//order.setSid(sqlconn.rs.getInt("source_id"));
				//order.setUid(sqlconn.rs.getInt("user_id"));
				//order.setTid(sqlconn.rs.getInt("type_id"));
				order.setCname(sqlconn.rs.getString("customer_name"));//客户姓名
				order.setCsex(sqlconn.rs.getString("customer_sex"));
				order.setCmobile(sqlconn.rs.getString("customer_mobile"));
				order.setCqq(sqlconn.rs.getString("customer_qq"));
				//order.setCaddr(sqlconn.rs.getString("customer_address"));
				order.setCemail(sqlconn.rs.getString("customer_email"));
				order.setCjob(sqlconn.rs.getString("customer_job"));
				order.setCcomp(sqlconn.rs.getString("customer_company"));
				order.setCmark(sqlconn.rs.getString("customer_remark"));
				//order.setCblog(sqlconn.rs.getString("customer_blog"));
				//order.setCtel(sqlconn.rs.getString("customer_tel"));
				//order.setCmsn(sqlconn.rs.getString("customer_msn"));
				//order.setCbirth(sqlconn.rs.getString("birth_day"));
				//order.setCaddtime(sqlconn.rs.getString("customer_addtime"));
				//order.setCaddman(sqlconn.rs.getString("customer_addman"));
				//order.setCctime(sqlconn.rs.getString("customer_changtime"));
				//order.setCcman(sqlconn.rs.getString("change_man"));
				//order.setCcomp(sqlconn.rs.getString("customer_company"));
				//order.setCused(sqlconn.rs.getString("is_used"));

			list.add(order);

			}
			//由里层向外层关闭
			sqlconn.rs.close();
			sqlconn.ps.close();
			sqlconn.connection().close();
	}catch(Exception e){
		e.printStackTrace();
	}
		return list;
	}
	
	
	
	//根据客户姓名打印出客户信息
	public void SelectUse(String name){
		
		List<Customer_info > se=select.SelectdbMH(name);
		
		for(int i=0;i<se.size();i++){
			System.out.println(se.get(i).getCustid()+"\t"+se.get(i).getCid()+"\t"+se.get(i).getCid()+"\t"+se.get(i).getCid()+"\t"+
					se.get(i).getCid()+"\t"+se.get(i).getCid()+"\t"+se.get(i).getCid()+"\t"+se.get(i).getCid()+"\t"+se.get(i).getCid()
		+"\t"+se.get(i).getCid());
		}
	}
	

}	



