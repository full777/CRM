package DB.mysql.UseDb.Customer;

import java.util.ArrayList;
import java.util.List;

import DB.mysql.UseDb.Customer.table.Customer_info;
import DB.mysql.connection.Sqlconnection;

public class editCustomer {
	public static SelectCustomer select;
	Sqlconnection sqlconn;
	
	//�������ݿ⣬����ҳ��ɾ��һ�����ݵ�ʱ�������ݿ������޸�used״̬
	
	
	//�༭������֮��,�����ݻ�ԭ����ӵ����ݵ�ԭ��������
	//value��Ҫ��ԭ��ѡ���ֵ
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
