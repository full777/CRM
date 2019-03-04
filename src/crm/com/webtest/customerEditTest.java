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
	//登录
 @Test(priority=1)
	  public void login() throws IOException{
		  lpage.login(ex.UseExcel(1, 2), ex.UseExcel(1, 3));//登录
	  }
	/*
	//先添加成功
  @Test(priority=2)
  public void Add() {
	  cpage.add();
		 String birth=cpage.choseBirth(customerContent.Cbirth, "1990-10-26 15:21:00");//输入出生日期
		  cpage.addSucess("马纱纱", "朋友推荐", "助理", "供应商", "女", "1234@qq.com", birth,"交易客户", "15783094235", "15789541", "江苏省", "", "张三", "你怎么可以吃小兔兔",
					"55359123", "无", "嘉伟", "友好意向");
		  
		Assert.assertEquals(lpage.loginerror(), customerContent.sucess);
  }
  //分配客户 
  @Test(priority=3)
  public void changeOne() {
 	  cpage.addallot();  //进入客户分配
 	 cpage.selectAllot("马纱纱","孙悟空");
 	  Assert.assertEquals(lpage.loginerror(), customerContent.allotSucess);
  }
*/
 
//==========================
  //再编辑


  //编辑成功,email 格式含有英文字母
  @Test(priority=2)
  public void editSucessOne() throws IOException {
	 
	  
	  cpage.edit();
	  cpage.selectEdit( ex.UseExcel(2, 4),ex.UseExcel(2, 5),1);
		 cpage.editSucess(ex.UseExcel(2, 7), ex.UseExcel(2, 8), ex.UseExcel(2, 9), ex.UseExcel(2, 10),ex.UseExcel(2, 11), ex.UseExcel(2, 12), ex.UseExcel(2, 13), ex.UseExcel(2, 14), ex.UseExcel(2, 15), 
				 ex.UseExcel(2, 16), ex.UseExcel(2, 17), ex.UseExcel(2, 18),ex.UseExcel(2, 19), ex.UseExcel(2, 20), ex.UseExcel(2, 21), ex.UseExcel(2, 22));
		 Assert.assertEquals(lpage.loginerror(), ex.UseExcel(2, 23));
		 edit.SelectCustUpdate(ex.UseExcelSql(2, 2), ex.UseExcelAdd(16, 9));//将数据email还原成刚添加的样子
		  
		
	  
  }
  //编辑成功
  @Test(priority=3)
  public void editSucessTwo() throws IOException{
	  cpage.selectEdit(ex.UseExcel(3, 4),ex.UseExcel(3, 5),1);
	  cpage.editSucess(ex.UseExcel(3, 7), ex.UseExcel(3, 8), ex.UseExcel(3, 9), ex.UseExcel(3, 10),ex.UseExcel(3, 11), ex.UseExcel(3, 12), ex.UseExcel(3, 13), ex.UseExcel(3, 14), ex.UseExcel(3, 15), 
				 ex.UseExcel(3, 16), ex.UseExcel(3, 17), ex.UseExcel(3, 18),ex.UseExcel(3, 19), ex.UseExcel(3, 20), ex.UseExcel(3, 21), ex.UseExcel(3, 22));
		 Assert.assertEquals(lpage.loginerror(), ex.UseExcel(3, 23));
	  
  }
  //编辑成功后，查看客户信息是否已经修改
  @Test(priority=4)
  public void editCompare() throws IOException{
	  /*
 	 cpage.selectEdit("马纱纱", "客户姓名",1);  
 	 cpage.editSucess("张三", "朋友推荐", "潜在客户", "女","合作伙伴", "13254874356", "145345467", "重庆云阳", "3797245@qq.com", "老总", "江湖1234", "87654367",
 			 "", "", "", "No");
 	
 	 page.alertAccpet();
 	 */
	  boolean bool2=false;
	  boolean result=false; //断言
 cpage.CustFind(ex.UseExcel(4, 4),ex.UseExcel(4, 5));
 	boolean bool=cpage.editCompare(ex.UseExcel(4, 6), ex.UseExcel(4, 9), ex.UseExcel(4, 8), ex.UseExcel(4, 7), ex.UseExcel(4, 11), ex.UseExcel(4, 10), ex.UseExcel(4, 12), 
 			ex.UseExcel(4, 13), ex.UseExcel(4, 15), ex.UseExcel(4, 16), ex.UseExcel(4, 20), ex.UseExcel(4, 22));
 	
 	  List<Customer_info >  listadd= se.SelectCustAdd(ex.UseExcelSql(5, 1));
 	  //编辑后对比数据库里的信息
		 String [] array=new String  []{ listadd.get(0).getCname(),listadd.get(0).getCid(),listadd.get(0).getSid(),listadd.get(0).getUid(),listadd.get(0).getTid(),
				 listadd.get(0).getCsex(),listadd.get(0).getCmobile(),listadd.get(0).getCqq(),listadd.get(0).getCemail(),listadd.get(0).getCjob(),listadd.get(0).getCcomp(),listadd.get(0).getCmark()};

		 //数据库里面根据sql语句查询出的添加的信息
		 for(int i=0;i<array.length;i++){
	
			String xpath= "/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td["+(i+1)+"]/div/span";
				
			if(page.dirver.findElement(By.xpath(xpath)).getText().equals(array[i])){
					bool2=true;
				}
			else{
				bool2=false;
				System.out.println("第"+i+"个有错");
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
  
  //座机号码格式小于8位
  @Test(priority=5)
  public void editTwo() throws IOException {
	  cpage.addallotBack();  //分配后,进入客户信息查询
	  cpage.selectEdit(ex.UseExcel(5, 4),ex.UseExcel(5, 5),1);
	  cpage.editOnly(customerContent.Ctel, ex.UseExcel(5, 18));
		 Assert.assertEquals(lpage.loginerror(), ex.UseExcel(5, 24));
	  
  }
 
  //座机号码格式大于8位
  @Test(priority=6)
  public void editThree() throws IOException {
	  page.clickName(customerContent.Creturn);
	  cpage.selectEdit(ex.UseExcel(6, 4),ex.UseExcel(6, 5),1);
	  cpage.editOnly(customerContent.Ctel, ex.UseExcel(6, 18));
		 Assert.assertEquals(lpage.loginerror(), ex.UseExcel(6, 24));
	  
  }
 
  //手机号码格式小于11位
  @Test(priority=7)
  public void editFour() throws IOException {
	  page.clickName(customerContent.Creturn);
	  cpage.selectEdit(ex.UseExcel(7, 4),ex.UseExcel(7, 5),1);
	  cpage.editOnly(customerContent.Cphone, ex.UseExcel(7, 12));
		 Assert.assertEquals(lpage.loginerror(), ex.UseExcel(7, 25));
	  
  }
  //手机号码格式大于11位
  @Test(priority=8)
  public void editFive() throws IOException {
	  page.clickName(customerContent.Creturn);
	  cpage.selectEdit(ex.UseExcel(8, 4),ex.UseExcel(8, 5),1);
	  cpage.editOnly(customerContent.Cphone, ex.UseExcel(8, 12));
		 Assert.assertEquals(lpage.loginerror(), ex.UseExcel(8, 25));
	  
  }
  
  //email格式不对
  @Test(priority=9)
  public void editSix() throws IOException {
	  page.clickName(customerContent.Creturn);
	  cpage.selectEdit(ex.UseExcel(9, 4),ex.UseExcel(9, 5),1);
	  cpage.editOnly(customerContent.CEmail, ex.UseExcel(9, 15));
		 Assert.assertEquals(lpage.loginerror(), ex.UseExcel(9, 26));
	  
  }
 
  //email格式数字+@
  @Test(priority=10)
  public void editSeven() throws IOException {
	  page.clickName(customerContent.Creturn);
	  cpage.selectEdit(ex.UseExcel(10, 4),ex.UseExcel(10, 5),1);
	  cpage.editOnly(customerContent.CEmail, ex.UseExcel(10, 15));
		 Assert.assertEquals(lpage.loginerror(), ex.UseExcel(10, 26));
	  
  }

  //email格式数字+中文+@qq.com,错误
  @Test(priority=11)
  public void editEight() throws IOException {
	  page.clickName(customerContent.Creturn);
	  cpage.selectEdit(ex.UseExcel(11, 4),ex.UseExcel(11, 5),1);
	  cpage.editOnly(customerContent.CEmail, ex.UseExcel(11, 15));
		 Assert.assertEquals(lpage.loginerror(), ex.UseExcel(11, 26));
	  
  }
//email为空
  
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
	  de=new deleteCustomer(); //实例化删除客户
	 se =new SelectCustomer(); //实例化查询
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
