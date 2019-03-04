package crm.com.webtest;

import org.testng.annotations.Test;

import DB.mysql.UseDb.Customer.SelectCustomer;
import DB.mysql.UseDb.Customer.deleteCustomer;
import DB.mysql.UseDb.Customer.editCustomer;
import DB.mysql.UseDb.Customer.table.Customer_info;
import Excel.excel;
import crm.com.base.BasePage;
import crm.com.base.UseBrowser;
import crm.com.content.customerContent;
import crm.com.content.loginContent;
import crm.com.page.customerPage;
import crm.com.page.loginPage;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class customerEditTest {
	customerPage cpage;
	loginPage lpage;
	BasePage page;
	customerTest ctest;
	UseBrowser browser;
	excel ex;
	deleteCustomer de;
	SelectCustomer se;
	editCustomer edit;
	//��¼
 @Test(priority=1)
	  public void login() throws IOException{
		  lpage.login(ex.UseExcel(1, 2), ex.UseExcel(1, 3));//��¼
	  }
	/*
	//����ӳɹ�
  @Test(priority=2)
  public void Add() {
	  cpage.add();
		 String birth=cpage.choseBirth(customerContent.Cbirth, "1990-10-26 15:21:00");//�����������
		  cpage.addSucess("��ɴɴ", "�����Ƽ�", "����", "��Ӧ��", "Ů", "1234@qq.com", birth,"���׿ͻ�", "15783094235", "15789541", "����ʡ", "", "����", "����ô���Գ�С����",
					"55359123", "��", "��ΰ", "�Ѻ�����");
		  
		Assert.assertEquals(lpage.loginerror(), customerContent.sucess);
  }
  //����ͻ� 
  @Test(priority=3)
  public void changeOne() {
 	  cpage.addallot();  //����ͻ�����
 	 cpage.selectAllot("��ɴɴ","�����");
 	  Assert.assertEquals(lpage.loginerror(), customerContent.allotSucess);
  }
*/
 
//==========================
  //�ٱ༭


  //�༭�ɹ�,email ��ʽ����Ӣ����ĸ
  @Test(priority=2)
  public void editSucessOne() throws IOException {
	 
	  
	  cpage.edit();
	  cpage.selectEdit( ex.UseExcel(2, 4),ex.UseExcel(2, 5),1);
		 cpage.editSucess(ex.UseExcel(2, 7), ex.UseExcel(2, 8), ex.UseExcel(2, 9), ex.UseExcel(2, 10),ex.UseExcel(2, 11), ex.UseExcel(2, 12), ex.UseExcel(2, 13), ex.UseExcel(2, 14), ex.UseExcel(2, 15), 
				 ex.UseExcel(2, 16), ex.UseExcel(2, 17), ex.UseExcel(2, 18),ex.UseExcel(2, 19), ex.UseExcel(2, 20), ex.UseExcel(2, 21), ex.UseExcel(2, 22));
		 Assert.assertEquals(lpage.loginerror(), ex.UseExcel(2, 23));
		 edit.SelectCustUpdate(ex.UseExcelSql(2, 2), ex.UseExcelAdd(16, 9));//������email��ԭ�ɸ���ӵ�����
		  
		
	  
  }
  //�༭�ɹ�
  @Test(priority=3)
  public void editSucessTwo() throws IOException{
	  cpage.selectEdit(ex.UseExcel(3, 4),ex.UseExcel(3, 5),1);
	  cpage.editSucess(ex.UseExcel(3, 7), ex.UseExcel(3, 8), ex.UseExcel(3, 9), ex.UseExcel(3, 10),ex.UseExcel(3, 11), ex.UseExcel(3, 12), ex.UseExcel(3, 13), ex.UseExcel(3, 14), ex.UseExcel(3, 15), 
				 ex.UseExcel(3, 16), ex.UseExcel(3, 17), ex.UseExcel(3, 18),ex.UseExcel(3, 19), ex.UseExcel(3, 20), ex.UseExcel(3, 21), ex.UseExcel(3, 22));
		 Assert.assertEquals(lpage.loginerror(), ex.UseExcel(3, 23));
	  
  }
  //�༭�ɹ��󣬲鿴�ͻ���Ϣ�Ƿ��Ѿ��޸�
  @Test(priority=4)
  public void editCompare() throws IOException{
	  /*
 	 cpage.selectEdit("��ɴɴ", "�ͻ�����",1);  
 	 cpage.editSucess("����", "�����Ƽ�", "Ǳ�ڿͻ�", "Ů","�������", "13254874356", "145345467", "��������", "3797245@qq.com", "����", "����1234", "87654367",
 			 "", "", "", "No");
 	
 	 page.alertAccpet();
 	 */
	  boolean bool2=false;
	  boolean result=false; //����
 cpage.CustFind(ex.UseExcel(4, 4),ex.UseExcel(4, 5));
 	boolean bool=cpage.editCompare(ex.UseExcel(4, 6), ex.UseExcel(4, 9), ex.UseExcel(4, 8), ex.UseExcel(4, 7), ex.UseExcel(4, 11), ex.UseExcel(4, 10), ex.UseExcel(4, 12), 
 			ex.UseExcel(4, 13), ex.UseExcel(4, 15), ex.UseExcel(4, 16), ex.UseExcel(4, 20), ex.UseExcel(4, 22));
 	
 	  List<Customer_info >  listadd= se.SelectCustAdd(ex.UseExcelSql(5, 1));
 	  //�༭��Ա����ݿ������Ϣ
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
		if(bool==true&& bool2==true){
			result=true;
		} 
		Assert.assertEquals(result, true);	
		de.Delectsql(ex.UseExcelSql(5, 1),ex.UseExcelSql(3, 1));
 	}

  
  
  
  
 /*
  
  //���������ʽС��8λ
  @Test(priority=5)
  public void editTwo() throws IOException {
	  cpage.addallotBack();  //�����,����ͻ���Ϣ��ѯ
	  cpage.selectEdit(ex.UseExcel(5, 4),ex.UseExcel(5, 5),1);
	  cpage.editOnly(customerContent.Ctel, ex.UseExcel(5, 18));
		 Assert.assertEquals(lpage.loginerror(), ex.UseExcel(5, 24));
	  
  }
 
  //���������ʽ����8λ
  @Test(priority=6)
  public void editThree() throws IOException {
	  page.clickName(customerContent.Creturn);
	  cpage.selectEdit(ex.UseExcel(6, 4),ex.UseExcel(6, 5),1);
	  cpage.editOnly(customerContent.Ctel, ex.UseExcel(6, 18));
		 Assert.assertEquals(lpage.loginerror(), ex.UseExcel(6, 24));
	  
  }
 
  //�ֻ������ʽС��11λ
  @Test(priority=7)
  public void editFour() throws IOException {
	  page.clickName(customerContent.Creturn);
	  cpage.selectEdit(ex.UseExcel(7, 4),ex.UseExcel(7, 5),1);
	  cpage.editOnly(customerContent.Cphone, ex.UseExcel(7, 12));
		 Assert.assertEquals(lpage.loginerror(), ex.UseExcel(7, 25));
	  
  }
  //�ֻ������ʽ����11λ
  @Test(priority=8)
  public void editFive() throws IOException {
	  page.clickName(customerContent.Creturn);
	  cpage.selectEdit(ex.UseExcel(8, 4),ex.UseExcel(8, 5),1);
	  cpage.editOnly(customerContent.Cphone, ex.UseExcel(8, 12));
		 Assert.assertEquals(lpage.loginerror(), ex.UseExcel(8, 25));
	  
  }
  
  //email��ʽ����
  @Test(priority=9)
  public void editSix() throws IOException {
	  page.clickName(customerContent.Creturn);
	  cpage.selectEdit(ex.UseExcel(9, 4),ex.UseExcel(9, 5),1);
	  cpage.editOnly(customerContent.CEmail, ex.UseExcel(9, 15));
		 Assert.assertEquals(lpage.loginerror(), ex.UseExcel(9, 26));
	  
  }
 
  //email��ʽ����+@
  @Test(priority=10)
  public void editSeven() throws IOException {
	  page.clickName(customerContent.Creturn);
	  cpage.selectEdit(ex.UseExcel(10, 4),ex.UseExcel(10, 5),1);
	  cpage.editOnly(customerContent.CEmail, ex.UseExcel(10, 15));
		 Assert.assertEquals(lpage.loginerror(), ex.UseExcel(10, 26));
	  
  }

  //email��ʽ����+����+@qq.com,����
  @Test(priority=11)
  public void editEight() throws IOException {
	  page.clickName(customerContent.Creturn);
	  cpage.selectEdit(ex.UseExcel(11, 4),ex.UseExcel(11, 5),1);
	  cpage.editOnly(customerContent.CEmail, ex.UseExcel(11, 15));
		 Assert.assertEquals(lpage.loginerror(), ex.UseExcel(11, 26));
	  
  }
//emailΪ��
  
  @Test(priority=12)
  public void editNine() throws IOException {
	  page.clickName(customerContent.Creturn);
	  cpage.selectEdit(ex.UseExcel(12, 4),ex.UseExcel(12, 5),1);
	  cpage.editOnly(customerContent.CEmail, ex.UseExcel(12, 15));
		 Assert.assertEquals(lpage.loginerror(), ex.UseExcel(12, 26));
		 
	  de.Delectsql(ex.UseExcelAdd(2, 4));
  }
*/

  
  @BeforeClass
  public void beforeClass() throws IOException {
	  de=new deleteCustomer(); //ʵ����ɾ���ͻ�
	 se =new SelectCustomer(); //ʵ������ѯ
	  edit=new editCustomer();
	 ex=new excel();
	  ctest=new customerTest();
	  cpage=new customerPage();
	  lpage=new loginPage();
	  browser=new UseBrowser();
	  page=new BasePage(UseBrowser.driver);
	  page.getUrl(ex.UseExcel(1, 1));  //url
  }

  @AfterClass
  public void afterClass() {
	  page.close();
  }

}
