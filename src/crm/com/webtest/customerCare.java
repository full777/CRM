package crm.com.webtest;

import org.testng.annotations.Test;

import crm.com.base.BasePage;
import crm.com.base.UseBrowser;
import crm.com.content.customerCareContent;
import crm.com.content.loginContent;
import crm.com.page.customerCarePage;
import crm.com.page.customerPage;
import crm.com.page.loginPage;


import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class customerCare {
	BasePage page;
	customerPage cpage;
	loginPage lpage;
	customerCarePage ccpage;
	UseBrowser browser;
	
  @Test(priority=1)
  public void careLogin() {
	  lpage.login("admin", "123456");
  }

 //新增客户关怀 
  @Test(priority=2)
  public void addCaseOne() { 
	 ccpage.addCareStart();
	 String birth=ccpage.choseBirth("careNexttime", "1988", "03", "24", "12", "30", "00");
	 ccpage.addCareAll("过生", "lisa", birth, "上门拜访", "阿呆", "么么哒");
	Assert.assertEquals(lpage.loginerror(),customerCareContent.addsucess);
  }
  /*
  //新增，不填关怀主题
@Test(priority=3)
public void addCaseTwo(){
	page.clickXpath(customerCareContent.careadd);  //点击添加
	String birth=ccpage.choseBirth("careNexttime", "1988", "03", "24", "12", "30", "00");
	ccpage.addCareAll("", "lisa", birth, "上门拜访", "阿呆", "么么哒");
	Assert.assertEquals(lpage.loginerror(), customerCareContent.error1);
}

  
  //新增，不填关怀时间
@Test(priority=4)
public void addCaseThree(){
	page.clickName(customerCareContent.back);  //点击返回
	page.clickXpath(customerCareContent.careadd);  //点击添加
	ccpage.addCareOther("结婚", "lisa", "上门拜访", "阿呆", "么么哒");
	Assert.assertEquals(lpage.loginerror(), customerCareContent.error2);
}
 */ 
 // 新增成功后验证页面是否有添加的信息
@Test(priority=5)
public void addCaseFour(){
	page.clickXpath(customerCareContent.careadd);
	 String birth=ccpage.choseBirth("careNexttime", "1999", "10", "24", "02", "30", "00");
	 ccpage.addCareAll("高中状元", "lisa", birth, "上门拜访", "阿呆", "李时珍的");
	 lpage.loginerror();
	 
	 ccpage.findCare("lisa", "关怀客户"); //先查询出信息条数
	 ccpage.addCareSucess( "lisa","高中状元","上门拜访","", birth+".0", "李时珍的" ,"阿呆");//第四个是当前时间，选择跳过不对比

	
}
  
  
  @BeforeClass
  public void beforeClass() {
	  ccpage=new customerCarePage();
	  cpage=new customerPage();
	  lpage=new loginPage();
	  browser=new UseBrowser();
	  page=new BasePage(UseBrowser.driver);
	  page.getUrl(loginContent.url);
  }

  @AfterClass
  public void afterClass() {
	  page.close();
  }

}
