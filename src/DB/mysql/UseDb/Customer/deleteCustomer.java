package DB.mysql.UseDb.Customer;

import DB.mysql.connection.Sqlconnection;

public class deleteCustomer {

	public static SelectCustomer select;
	Sqlconnection sqlconn;
	 public void Delectsql(String sqlSelect,String sqlDel ){
		 sqlconn=new Sqlconnection();
	 	//�������ݿ�����
	 	try{
	 		
	 		sqlconn.connection();
	 		//���Ͳ�ѯ���
	 		//���ж��Ƿ���ڴ�������
	 		select =new SelectCustomer();
	 		if(select.SelectdbMH(sqlSelect).size()==0){	
	 			System.out.println("����Ϣ������!");	
	 		}
	 		else{
	 			sqlconn.ps=sqlconn.connection().prepareStatement(sqlDel);
		 		//sqlconn.ps.setString(1, cname);
				//ִ��sql���

		 		sqlconn.ps.executeUpdate();
		 		System.out.println("ɾ���ɹ�");
		 		
		 		//����������ر�
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
		//de.Delectsql("��ɴɴ");
		
	}

}
