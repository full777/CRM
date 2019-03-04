package DB.mysql.UseDb.Customer;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import DB.mysql.UseDb.Customer.table.Customer_info;
import DB.mysql.connection.Sqlconnection;

public class SelectCustomer {
	public static SelectCustomer select;
	Sqlconnection sqlconn;

	
//����������ѯ
	
	public List<Customer_info > SelectdbMH(String sql) {

		sqlconn=new Sqlconnection();
		//����һ������������������
		List<Customer_info > list=new ArrayList<>();
		//�������ݿ�����
		try{
			//sqlconn.connection();
			//���Ͳ�ѯ���
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
			//����������ر�
			sqlconn.rs.close();
			sqlconn.ps.close();
			sqlconn.connection().close();
	}catch(Exception e){
		e.printStackTrace();
	}
		return list;
	}
	
	//�����Ӻ�һ���ͻ���Ϣʱ��һһ�Ա�ȫ����Ϣ����һ��listȡ�����ݿ�ĺ�ҳ��Ա�

	public List<Customer_info > SelectCustAdd(String sql) {

		sqlconn=new Sqlconnection();
		List<Customer_info > list=new ArrayList<>();
		try{
			
		sqlconn.ps=sqlconn.connection().prepareStatement(sql);
		sqlconn.rs=sqlconn.ps.executeQuery();
		//����һ������������������
		
		//�������ݿ�����
		
			Customer_info  order=new Customer_info ();

			while (sqlconn.rs.next()){
				//��ȡcustomer_condition�����condition_name��ҳ���е�״̬
				sqlconn.ps=sqlconn.connection().prepareStatement("SELECT * FROM customer_condition	 where condition_id ="+ sqlconn.rs.getInt("condition_id"));
				
				sqlconn.rs2 = sqlconn.ps.executeQuery();
				if(sqlconn.rs2.next()){
					order.setCid(sqlconn.rs2.getString("condition_name"));
				}
				//��ȡcustomer_source�����source_name��ҳ���еĿͻ���Դ
				sqlconn.ps=sqlconn.connection().prepareStatement( "SELECT * FROM customer_source	 where source_id = "+  sqlconn.rs.getInt("source_id"));
				sqlconn.rs2 = sqlconn.ps.executeQuery();
				if(sqlconn.rs2.next()){
					order.setSid(sqlconn.rs2.getString("source_name"));
				}
				//��ȡuser_info�����user_name��ҳ���е�����Ա��
				sqlconn.ps=sqlconn.connection().prepareStatement( "SELECT * FROM user_info where user_id = "+sqlconn.rs.getInt("user_id") );
				sqlconn.rs2 = sqlconn.ps.executeQuery();
				if(sqlconn.rs2.next()){
				order.setUid(sqlconn.rs2.getString("user_name"));
				}
				
				//��ȡcustomer_type�����type_name��ҳ���е�����
				sqlconn.ps=sqlconn.connection().prepareStatement( "SELECT * FROM customer_type	 where type_id =  "+ sqlconn.rs.getInt("type_id") );
				sqlconn.rs2 = sqlconn.ps.executeQuery();
				if(sqlconn.rs2.next()){
				order.setTid(sqlconn.rs2.getString("type_name"));
				}

				
				//order.setCid(sqlconn.rs.getInt("condition_id"));
				//order.setSid(sqlconn.rs.getInt("source_id"));
				//order.setUid(sqlconn.rs.getInt("user_id"));
				//order.setTid(sqlconn.rs.getInt("type_id"));
				order.setCname(sqlconn.rs.getString("customer_name"));//�ͻ�����
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
			//����������ر�
			sqlconn.rs.close();
			sqlconn.ps.close();
			sqlconn.connection().close();
	}catch(Exception e){
		e.printStackTrace();
	}
		return list;
	}
	
	
	
	//���ݿͻ�������ӡ���ͻ���Ϣ
	public void SelectUse(String name){
		
		List<Customer_info > se=select.SelectdbMH(name);
		
		for(int i=0;i<se.size();i++){
			System.out.println(se.get(i).getCustid()+"\t"+se.get(i).getCid()+"\t"+se.get(i).getCid()+"\t"+se.get(i).getCid()+"\t"+
					se.get(i).getCid()+"\t"+se.get(i).getCid()+"\t"+se.get(i).getCid()+"\t"+se.get(i).getCid()+"\t"+se.get(i).getCid()
		+"\t"+se.get(i).getCid());
		}
	}
	

}	



