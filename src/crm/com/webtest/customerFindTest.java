package crm.com.webtest;

import org.testng.annotations.Test;

import DB.mysql.UseDb.Customer.SelectCustomer;
import DB.mysql.UseDb.Customer.deleteCustomer;
import DB.mysql.UseDb.Customer.table.Customer_info;
import Excel.excel;
import crm.com.base.BasePage;
import crm.com.base.UseBrowser;
import crm.com.content.customerContent;
import crm.com.page.customerPage;
import crm.com.page.loginPage;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class customerFindTest {
	customerPage cpage;
	loginPage lpage;
	BasePage page;
	customerTest ctest;
	UseBrowser browser;
	excel ex;
	deleteCustomer de;
	SelectCustomer se;
	
	//��¼
	 @Test(priority=1)
	  public void login() throws IOException{
		  lpage.login(ex.UseExcelAdd(2, 2), ex.UseExcelAdd(2, 3));//��¼
	  }
	/*
	 //�����һ������
	 @Test(priority=2)
	  public void FindCaseOne() throws IOException{
		 cpage.add();
			 String birth=cpage.choseBirth(customerContent.Cbirth, ex.UseExcelAdd(16, 10));//�����������
			  cpage.addSucess(ex.UseExcelAdd(16, 4), ex.UseExcelAdd(16, 5), ex.UseExcelAdd(16, 6), ex.UseExcelAdd(16, 7), ex.UseExcelAdd(16, 8), ex.UseExcelAdd(16, 9), birth, ex.UseExcelAdd(16, 11), 
					  ex.UseExcelAdd(16, 12), ex.UseExcelAdd(16, 13), ex.UseExcelAdd(16, 14), ex.UseExcelAdd(16, 15), ex.UseExcelAdd(16, 16),ex.UseExcelAdd(16, 17),ex.UseExcelAdd(16, 18), ex.UseExcelAdd(16, 19),
					  ex.UseExcelAdd(16, 20),ex.UseExcelAdd(16, 21));
			Assert.assertEquals(lpage.loginerror(), ex.UseExcelAdd(16, 22));	  
	  }
	 
	 //�ڷ���
	 @Test(priority=3)
	 public void FindCaseTwo() throws IOException {
		  cpage.addallot();  //����ͻ�����
		 cpage.selectAllot( ex.UseExcelAdd(16, 28), ex.UseExcelAdd(16, 29));
		  Assert.assertEquals(lpage.loginerror(),  ex.UseExcelAdd(16, 27));
	 }
	 */

	 @Test(priority=2)
	  public void FindCaseThree() throws IOException{
		 
		 cpage.find( ex.UseExcelAdd(16, 30), ex.UseExcelAdd(16, 31));
		boolean bool=false;
		boolean bool2=false;
		boolean result=false;
		
		 //�����ݿ���ģ����ѯ������Ϣ �� ��ҳ����ģ���������Ϣ�����Ƚϣ�ex.UseExcelAdd(16, 32) ����ӳɹ�������ĳһ���ַ�
		 if((se.SelectdbMH(ex.UseExcelSql(4, 1)).size()==cpage.MOHU(ex.UseExcelAdd(16, 32),ex.UseExcelAdd(16, 31))&& cpage.mohu(ex.UseExcelAdd(16, 32),ex.UseExcelAdd(16, 31)))){
		 bool=true;
		 }
		 
	//	 de.Delectsql(ex.UseExcelSql(3, 1)); //��sql��� 
	//	  Assert.assertEquals(bool,  true);  //���ݿͻ�������ѯ
		  
		 //�����ݿ������Ӧ��Ϣ ��ҳ���һһ�Ա�
		  
		  List<Customer_info >  listadd= se.SelectCustAdd(ex.UseExcelSql(5, 1));
		 String [] array=new String  []{ listadd.get(0).getCname(),listadd.get(0).getCid(),listadd.get(0).getSid(),listadd.get(0).getUid(),listadd.get(0).getTid(),
				 listadd.get(0).getCsex(),listadd.get(0).getCmobile(),listadd.get(0).getCqq(),listadd.get(0).getCemail(),listadd.get(0).getCjob(),listadd.get(0).getCcomp(),listadd.get(0).getCmark()};

		 //���ݿ��������sql����ѯ������ӵ���Ϣ
		 for(int i=0;i<array.length;i++){
	
			String xpath= "/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td["+(i+1)+"]/div/span";
				
			if(page.dirver.findElement(By.xpath(xpath)).getText().equals(array[i])){
					bool2=true;
				}
			else{
				bool2=false;
				System.out.println("��"+i+"���д�");
				break;
			}
	  } 
		
		//  Assert.assertEquals(bool2,  true);  //���ݿͻ�������ѯ,ÿ���������Ա�
			if(bool==true&& bool2==true){
				result=true;
			} 
			Assert.assertEquals(result, true);	
		//de.Delectsql(ex.UseExcelSql(5, 1),ex.UseExcelSql(3, 1));//ǰ����sql��ѯ��� ��������ɾ�����
	 }

  @BeforeClass
  public void beforeClass() throws IOException {
	  de=new deleteCustomer(); //ʵ����ɾ���ͻ�
	  se=new SelectCustomer();
	  
	  ex=new excel();
	  ctest=new customerTest();
	  cpage=new customerPage();
	  lpage=new loginPage();
	  browser=new UseBrowser();
	  page=new BasePage(UseBrowser.driver);
	  
	  page.getUrl(ex.UseExcelAdd(2, 1));
  }

  @AfterClass
  public void afterClass() {
	  page.close();
  }

}
