package crm.com.webtest;

import org.testng.annotations.Test;

import crm.com.base.BasePage;
import crm.com.base.UseBrowser;
import crm.com.content.loginContent;
import crm.com.page.loginPage;

import org.testng.annotations.BeforeMethod;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class loginTest {
	loginPage login;
	BasePage page;
	UseBrowser browser;


	//µÇÂ¼³É¹¦
  @Test(priority=1)
  public void loginCaseOne() {
	 login.login("admin", "123456");
	 Assert.assertEquals(login.loginsucess(), loginContent.titile);  
  }


  
  @BeforeMethod
  public void beforeMethon() {
	  browser=new UseBrowser();
	login=new loginPage();
	 page=new BasePage(UseBrowser.driver);
	page.getUrl(loginContent.url);
	
  }

  @AfterMethod
  public void afterMethod() {
	  page.close();
  }

}
