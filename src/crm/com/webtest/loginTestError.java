package crm.com.webtest;

import org.testng.annotations.Test;

import crm.com.base.BasePage;
import crm.com.base.UseBrowser;
import crm.com.content.loginContent;
import crm.com.page.loginPage;

import org.testng.annotations.BeforeClass;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class loginTestError {
	loginPage login;
	BasePage page;
	UseBrowser browser;

	  //用户名不输入
	  @Test(priority=1)
	  public void loginCaseTwo() {
		login.clear(loginContent.username, loginContent.pwd);
		  login.login("", "123456");
		 Assert.assertEquals(login.loginerror(),  loginContent.error1);
		  
	  }

	  //密码不输入
	  @Test(priority=2)
	  public void loginCaseThree()  {
		  login.clear(loginContent.username, loginContent.pwd);
		 login.login("admin", "");
		 Assert.assertEquals(login.loginerror(), loginContent.error2);
		  
	  }

 //均不输入
	  @Test(priority=3)
	  public void loginCaseFour() {
		  login.clear(loginContent.username, loginContent.pwd);
		 login.login("", ""); 
		 Assert.assertEquals(login.loginerror(), loginContent.error3); 
	  }

	  //用户名和密码均错误
	@Test(priority=4)
	  public void loginCaseFive() {
		  login.clear(loginContent.username, loginContent.pwd);
		login.login("ad","12");
		 Assert.assertEquals(login.loginerror(), loginContent.error4); 
  
	  }
//用户名错误
	@Test(priority=5)
	  public void loginCaseSix() {
		  login.clear(loginContent.username, loginContent.pwd);
		login.login("ad","123456");
		 Assert.assertEquals(login.loginerror(), loginContent.error4);  

	  }
	
	//密码错误
	@Test(priority=6)
	  public void loginCaseSeven() {
		  login.clear(loginContent.username, loginContent.pwd);
		login.login("admin","12");
		 Assert.assertEquals(login.loginerror(), loginContent.error4); 

	  }

	

	  //密码输入空格
	  @Test(priority=7)
	  public void loginCaseEight() {
		 login.login("admin", "   ");
		 Assert.assertEquals(login.loginerror(), loginContent.error2);
		  
	  }

	  
  @BeforeClass
  public void beforeClass() {
	  browser=new UseBrowser();
		login=new loginPage();
		 page=new BasePage(UseBrowser.driver);
		page.getUrl(loginContent.url);
  }

  @AfterClass
  public void afterClass() {
	  page.close();
  }

}
