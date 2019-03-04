package crm.com.webtest;

import org.testng.annotations.Test;

import DB.mysql.UseDb.Customer.SelectCustomer;
import DB.mysql.UseDb.Customer.deleteCustomer;
import Excel.excel;
import crm.com.base.BasePage;
import crm.com.base.UseBrowser;
import crm.com.content.customerContent;
import crm.com.page.customerPage;
import crm.com.page.loginPage;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class customerTest {
	customerPage cpage;
	loginPage lpage;
	BasePage page;
	customerTest ctest;
	UseBrowser browser;
	excel ex;
	deleteCustomer de;
	SelectCustomer select;
 @Test(priority=1)
	  public void login() throws IOException{
		  lpage.login(ex.UseExcelAdd(2, 2), ex.UseExcelAdd(2, 3));//登录
	  }

	//必填项为空
 //{客户姓名}{Email}{出生日期}{创建人}
  @Test(priority=2)
  public void addCustCaseOne() throws IOException {
	  
	  cpage.add();
	  cpage.addCustomer(ex.UseExcelAdd(3, 4), ex.UseExcelAdd(3, 9), ex.UseExcelAdd(3, 10), ex.UseExcelAdd(3, 16));
	  Assert.assertEquals(lpage.loginerror(),ex.UseExcelAdd(3, 23) );
  }
  /*
  //客户名填，其余不填
  @Test(priority=3)
  public void addCustCaseTwo() throws IOException {
	  page.clickName(customerContent.Creturn); //返回
	  page.clickXpath(customerContent.add);//点击添加
	  cpage.addCustomer(ex.UseExcelAdd(4, 4), ex.UseExcelAdd(4, 9), ex.UseExcelAdd(4, 10), ex.UseExcelAdd(4, 16));
	  Assert.assertEquals(lpage.loginerror(), ex.UseExcelAdd(4, 23));
  }
  //Email填，其他不填
  @Test(priority=4)
  public void addCustCaseThree() throws IOException {
	  page.clickName(customerContent.Creturn); //返回
	  page.clickXpath(customerContent.add);//点击添加
	  cpage.addCustomer(ex.UseExcelAdd(5, 4), ex.UseExcelAdd(5, 9), ex.UseExcelAdd(5, 10), ex.UseExcelAdd(5, 16));
	    Assert.assertEquals(lpage.loginerror(), ex.UseExcelAdd(5, 23));
  }

  //出生日期填，其余不填
  @Test(priority=5)
  public void addCustCaseFour() throws IOException {
	  page.clickName(customerContent.Creturn); //返回
	  page.clickXpath(customerContent.add);//点击添加
	  String birth=cpage.choseBirth(customerContent.Cbirth, ex.UseExcelAdd(6, 10));//输入出生日期
	  cpage.addCustomer(ex.UseExcelAdd(6, 4), ex.UseExcelAdd(6, 9), birth, ex.UseExcelAdd(6, 16));
	  Assert.assertEquals(lpage.loginerror(),  ex.UseExcelAdd(6, 23));
  }

  //创建人填，其余不填
  @Test(priority=6)
  public void addCustCaseFive() throws IOException {
	  page.clickName(customerContent.Creturn); //返回
	  page.clickXpath(customerContent.add);//点击添加
	  cpage.addCustomer(ex.UseExcelAdd(7, 4), ex.UseExcelAdd(7, 9), ex.UseExcelAdd(7, 10), ex.UseExcelAdd(7, 16));
	  Assert.assertEquals(lpage.loginerror(), ex.UseExcelAdd(7, 23));
  }

 

 
 //email错误，格式正确，全数字
 @Test(priority=7)
 public void addCustCaseSeven() throws IOException {
	 page.clickName(customerContent.Creturn); //返回
	  page.clickXpath(customerContent.add);//点击添加
	  String birth=cpage.choseBirth(customerContent.Cbirth, ex.UseExcelAdd(8, 10));//输入出生日期
	  cpage.addCustomer(ex.UseExcelAdd(8, 4), ex.UseExcelAdd(8, 9), birth, ex.UseExcelAdd(8, 16));
	  Assert.assertEquals(lpage.loginerror(), ex.UseExcelAdd(8, 26));
 }

 //email错误，格式正确，数字+@
 @Test(priority=8)
 public void addCustCaseEight() throws IOException {
	 page.clickName(customerContent.Creturn); //返回
	  page.clickXpath(customerContent.add);//点击添加
	  String birth=cpage.choseBirth(customerContent.Cbirth, ex.UseExcelAdd(9, 10));//输入出生日期
	  cpage.addCustomer(ex.UseExcelAdd(9, 4), ex.UseExcelAdd(9, 9), birth, ex.UseExcelAdd(9, 16));
	  Assert.assertEquals(lpage.loginerror(), ex.UseExcelAdd(9, 26));
 }

 //email错误，格式正确，含汉字
 @Test(priority=9)
 public void addCustCaseNine() throws IOException{
	 page.clickName(customerContent.Creturn); //返回
	  page.clickXpath(customerContent.add);//点击添加
	  String birth=cpage.choseBirth(customerContent.Cbirth, ex.UseExcelAdd(10, 10));//输入出生日期
	  cpage.addCustomer(ex.UseExcelAdd(10, 4), ex.UseExcelAdd(10, 9), birth, ex.UseExcelAdd(10, 16));
	  Assert.assertEquals(lpage.loginerror(), ex.UseExcelAdd(10, 26));
 }
 
 //客户座机错误，小于8位
 @Test(priority=10)
 public void addCustCaseTen() throws IOException {
	 page.clickName(customerContent.Creturn); //返回
	  page.clickXpath(customerContent.add);//点击添加
	  String birth=cpage.choseBirth(customerContent.Cbirth, ex.UseExcelAdd(11, 10));//输入出生日期
	  cpage.addSucess(ex.UseExcelAdd(11, 4), ex.UseExcelAdd(11, 5), ex.UseExcelAdd(11, 6), ex.UseExcelAdd(11, 7), ex.UseExcelAdd(11, 8), ex.UseExcelAdd(11, 9), birth, ex.UseExcelAdd(11, 11), 
			  ex.UseExcelAdd(11, 12), ex.UseExcelAdd(11, 13), ex.UseExcelAdd(11, 14), ex.UseExcelAdd(11, 15), ex.UseExcelAdd(11, 16),ex.UseExcelAdd(11, 17),ex.UseExcelAdd(11, 18), ex.UseExcelAdd(11, 19),
			  ex.UseExcelAdd(11, 20),ex.UseExcelAdd(11, 21));
	   Assert.assertEquals(lpage.loginerror(), ex.UseExcelAdd(11, 24));
 } 
 
 //客户座机错误，大于8位
 @Test(priority=11)
 public void addCustCaseEleven() throws IOException {
	 page.clickName(customerContent.Creturn); //返回
	  page.clickXpath(customerContent.add);//点击添加
	  String birth=cpage.choseBirth(customerContent.Cbirth, ex.UseExcelAdd(12, 10));//输入出生日期
	  cpage.addSucess(ex.UseExcelAdd(12, 4), ex.UseExcelAdd(12, 5), ex.UseExcelAdd(12, 6), ex.UseExcelAdd(12, 7), ex.UseExcelAdd(12, 8), ex.UseExcelAdd(12, 9), birth, ex.UseExcelAdd(12, 11), 
			  ex.UseExcelAdd(12, 12), ex.UseExcelAdd(12, 13), ex.UseExcelAdd(12, 14), ex.UseExcelAdd(12, 15), ex.UseExcelAdd(12, 16),ex.UseExcelAdd(12, 17),ex.UseExcelAdd(12, 18), ex.UseExcelAdd(12, 19),
			  ex.UseExcelAdd(12, 20),ex.UseExcelAdd(12, 21));
	   Assert.assertEquals(lpage.loginerror(), ex.UseExcelAdd(12, 24));
 } 
 //客户手机错误，小于11位，大陆手机号
 @Test(priority=12)
 public void addPhoneCaseOne() throws IOException {
	 page.clickName(customerContent.Creturn); //返回
	  page.clickXpath(customerContent.add);//点击添加
	  String birth=cpage.choseBirth(customerContent.Cbirth, ex.UseExcelAdd(13, 10));//输入出生日期
	  cpage.addSucess(ex.UseExcelAdd(13, 4), ex.UseExcelAdd(13, 5), ex.UseExcelAdd(13, 6), ex.UseExcelAdd(13, 7), ex.UseExcelAdd(13, 8), ex.UseExcelAdd(13, 9), birth, ex.UseExcelAdd(13, 11), 
			  ex.UseExcelAdd(13, 12), ex.UseExcelAdd(13, 13), ex.UseExcelAdd(13, 14), ex.UseExcelAdd(13, 15), ex.UseExcelAdd(13, 16),ex.UseExcelAdd(13, 17),ex.UseExcelAdd(13, 18), ex.UseExcelAdd(13, 19),
			  ex.UseExcelAdd(13, 20),ex.UseExcelAdd(13, 21));
	   Assert.assertEquals(lpage.loginerror(), ex.UseExcelAdd(13, 25));
 }
 
 //客户手机错误，大于11位，大陆手机号
 @Test(priority=13)
 public void addPhoneCaseTwo() throws IOException {
	 page.clickName(customerContent.Creturn); //返回
	  page.clickXpath(customerContent.add);//点击添加
	  String birth=cpage.choseBirth(customerContent.Cbirth, ex.UseExcelAdd(14, 10));//输入出生日期
	  cpage.addSucess(ex.UseExcelAdd(14, 4), ex.UseExcelAdd(14, 5), ex.UseExcelAdd(14, 6), ex.UseExcelAdd(14, 7), ex.UseExcelAdd(14, 8), ex.UseExcelAdd(14, 9), birth, ex.UseExcelAdd(14, 11), 
			  ex.UseExcelAdd(14, 12), ex.UseExcelAdd(14, 13), ex.UseExcelAdd(14, 14), ex.UseExcelAdd(14, 15), ex.UseExcelAdd(14, 16),ex.UseExcelAdd(14, 17),ex.UseExcelAdd(14, 18), ex.UseExcelAdd(14, 19),
			  ex.UseExcelAdd(14, 20),ex.UseExcelAdd(14, 21));
	   Assert.assertEquals(lpage.loginerror(), ex.UseExcelAdd(14, 25));
 }

 //客户手机错误，大陆手机号格式不正确
 @Test(priority=14)
 public void addPhoneCaseThree() throws IOException {
	 page.clickName(customerContent.Creturn); //返回
	  page.clickXpath(customerContent.add);//点击添加
	  String birth=cpage.choseBirth(customerContent.Cbirth, ex.UseExcelAdd(15, 10));//输入出生日期
	  cpage.addSucess(ex.UseExcelAdd(15, 4), ex.UseExcelAdd(15, 5), ex.UseExcelAdd(15, 6), ex.UseExcelAdd(15, 7), ex.UseExcelAdd(15, 8), ex.UseExcelAdd(15, 9), birth, ex.UseExcelAdd(15, 11), 
			  ex.UseExcelAdd(15, 12), ex.UseExcelAdd(15, 13), ex.UseExcelAdd(15, 14), ex.UseExcelAdd(15, 15), ex.UseExcelAdd(15, 16),ex.UseExcelAdd(15, 17),ex.UseExcelAdd(15, 18), ex.UseExcelAdd(15, 19),
			  ex.UseExcelAdd(15, 20),ex.UseExcelAdd(15, 21));
	   Assert.assertEquals(lpage.loginerror(), ex.UseExcelAdd(15, 25));
 }
*/
//全部选项都正确填写

@Test(priority=15)
public void addCustCaseSix() throws IOException {
	//先判断有无要添加的数据，若有先删除
	de.Delectsql(ex.UseExcelSql(5, 1),ex.UseExcelSql(3, 1));

	 page.clickName(customerContent.Creturn); //返回
	  page.clickXpath(customerContent.add);//点击添加
	 String birth=cpage.choseBirth(customerContent.Cbirth, ex.UseExcelAdd(16, 10));//输入出生日期
	  cpage.addSucess(ex.UseExcelAdd(16, 4), ex.UseExcelAdd(16, 5), ex.UseExcelAdd(16, 6), ex.UseExcelAdd(16, 7), ex.UseExcelAdd(16, 8), ex.UseExcelAdd(16, 9), birth, ex.UseExcelAdd(16, 11), 
			  ex.UseExcelAdd(16, 12), ex.UseExcelAdd(16, 13), ex.UseExcelAdd(16, 14), ex.UseExcelAdd(16, 15), ex.UseExcelAdd(16, 16),ex.UseExcelAdd(16, 17),ex.UseExcelAdd(16, 18), ex.UseExcelAdd(16, 19),
			  ex.UseExcelAdd(16, 20),ex.UseExcelAdd(16, 21));

	Assert.assertEquals(lpage.loginerror(), ex.UseExcelAdd(16, 22));

}

//分配客户
 
 @Test(priority=16,dependsOnMethods="addCustCaseSix")
 public void findCustCaseOne() throws IOException {
	  cpage.addallot();  //进入客户分配
	 cpage.selectAllot( ex.UseExcelAdd(16, 28), ex.UseExcelAdd(16, 29));
	  Assert.assertEquals(lpage.loginerror(),  ex.UseExcelAdd(16, 27));
 }
 
 //查询
 //精确查询


 @Test(priority=17,dependsOnMethods="findCustCaseOne")
 public void findCustCaseTwo() throws IOException {
	 cpage.addallotBack();  //分配后,进入客户信息查询
	 
	   Assert.assertEquals(cpage.mohu(ex.UseExcelAdd(16, 30),ex.UseExcelAdd(16, 31)),  true);  //输入客户的全名查询
	  // de.Delectsql(ex.UseExcelSql(5, 1),ex.UseExcelSql(3, 1));
 }


 
 /*
 //删除
 //根据客户姓名
 @Test(priority=13,dependsOnMethods="findCustCaseTwo")
 public void deleteCustomer(){
	 cpage.CustFind("马纱纱", "客户姓名");
	 cpage.deleteCust(1);//删除姓名如果有重复，就删除第一条信息
	 Assert.assertEquals(lpage.loginerror(), customerContent.deleteSucess); 
 }
 */
  @BeforeClass
  public void beforeClass() throws IOException {
	//de=new deleteCustomer(); //实例化删除客户
	 // select =new SelectCustomer(); //实例化查询
	  
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
