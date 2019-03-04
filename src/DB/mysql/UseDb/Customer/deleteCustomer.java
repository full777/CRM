package DB.mysql.UseDb.Customer;

import DB.mysql.connection.Sqlconnection;

public class deleteCustomer {

	public static SelectCustomer select;
	Sqlconnection sqlconn;
	 public void Delectsql(String sqlSelect,String sqlDel ){
		 sqlconn=new Sqlconnection();
	 	//加载数据库驱动
	 	try{
	 		
	 		sqlconn.connection();
	 		//发送查询语句
	 		//先判断是否存在此条数据
	 		select =new SelectCustomer();
	 		if(select.SelectdbMH(sqlSelect).size()==0){	
	 			System.out.println("该信息不存在!");	
	 		}
	 		else{
	 			sqlconn.ps=sqlconn.connection().prepareStatement(sqlDel);
		 		//sqlconn.ps.setString(1, cname);
				//执行sql语句

		 		sqlconn.ps.executeUpdate();
		 		System.out.println("删除成功");
		 		
		 		//由里层向外层关闭
		 		sqlconn.ps.close();
		 		sqlconn.connection().close();
	 			
	 		}
	 	}catch(Exception e){
	 	e.printStackTrace();
	 	}

	 	
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		deleteCustomer de=new deleteCustomer();
		select =new SelectCustomer();
		//de.Delectsql("马纱纱");
		
	}

}
