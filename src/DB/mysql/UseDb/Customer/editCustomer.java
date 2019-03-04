package DB.mysql.UseDb.Customer;

import java.util.ArrayList;
import java.util.List;

import DB.mysql.UseDb.Customer.table.Customer_info;
import DB.mysql.connection.Sqlconnection;

public class editCustomer {
	public static SelectCustomer select;
	Sqlconnection sqlconn;
	
	//更新数据库，当在页面删除一条数据的时候，在数据库里面修改used状态
	
	
	//编辑过数据之后,将数据还原到添加的数据的原来的样子
	//value是要还原的选项的值
	public List<Customer_info > SelectCustUpdate (String sql,String value) {
		sqlconn=new Sqlconnection();
		List<Customer_info > list=new ArrayList<>();
		try{
			
		sqlconn.ps=sqlconn.connection().prepareStatement(sql);
		sqlconn.ps.setString(1, value);
		sqlconn.ps.executeUpdate();

			sqlconn.ps.close();
			sqlconn.connection().close();
	}catch(Exception e){
		e.printStackTrace();
	}
		return list;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
