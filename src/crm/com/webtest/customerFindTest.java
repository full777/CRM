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
	
	//登录
	 @Test(priority=1)
	  public void login() throws IOException{
		  lpage.login(ex.UseExcelAdd(2, 2), ex.UseExcelAdd(2, 3));//登录
	  }
	/*
	 //先添加一条数据
	 @Test(priority=2)
	  public void FindCaseOne() throws IOException{
		 cpage.add();
			 String birth=cpage.choseBirth(customerContent.Cbirth, ex.UseExcelAdd(16, 10));//输入出生日期
			  cpage.addSucess(ex.UseExcelAdd(16, 4), ex.UseExcelAdd(16, 5), ex.UseExcelAdd(16, 6), ex.UseExcelAdd(16, 7), ex.UseExcelAdd(16, 8), ex.UseExcelAdd(16, 9), birth, ex.UseExcelAdd(16, 11), 
					  ex.UseExcelAdd(16, 12), ex.UseExcelAdd(16, 13), ex.UseExcelAdd(16, 14), ex.UseExcelAdd(16, 15), ex.UseExcelAdd(16, 16),ex.UseExcelAdd(16, 17),ex.UseExcelAdd(16, 18), ex.UseExcelAdd(16, 19),
					  ex.UseExcelAdd(16, 20),ex.UseExcelAdd(16, 21));
			Assert.assertEquals(lpage.loginerror(), ex.UseExcelAdd(16, 22));	  
	  }
	 
	 //在分配
	 @Test(priority=3)
	 public void FindCaseTwo() throws IOException {
		  cpage.addallot();  //进入客户分配
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
		
		 //在数据库里模糊查询出的信息 和 在页面里模糊查出的信息条数比较，ex.UseExcelAdd(16, 32) 是添加成功姓名的某一段字符
		 if((se.SelectdbMH(ex.UseExcelSql(4, 1)).size()==cpage.MOHU(ex.UseExcelAdd(16, 32),ex.UseExcelAdd(16, 31))&& cpage.mohu(ex.UseExcelAdd(16, 32),ex.UseExcelAdd(16, 31)))){
		 bool=true;
		 }
		 
	//	 de.Delectsql(ex.UseExcelSql(3, 1)); //是sql语句 
	//	  Assert.assertEquals(bool,  true);  //根据客户姓名查询
		  
		 //将数据库里面对应信息 与页面的一一对比
		  
		  List<Customer_info >  listadd= se.SelectCustAdd(ex.UseExcelSql(5, 1));
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
		
		//  Assert.assertEquals(bool2,  true);  //根据客户姓名查询,每个数据做对比
			if(bool==true&& bool2==true){
				result=true;
			} 
			Assert.assertEquals(result, true);	
		//de.Delectsql(ex.UseExcelSql(5, 1),ex.UseExcelSql(3, 1));//前面是sql查询语句 ，后面是删除语句
	 }

  @BeforeClass
  public void beforeClass() throws IOException {
	  de=new deleteCustomer(); //实例化删除客户
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
