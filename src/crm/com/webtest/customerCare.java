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

 //�����ͻ��ػ� 
  @Test(priority=2)
  public void addCaseOne() { 
	 ccpage.addCareStart();
	 String birth=ccpage.choseBirth("careNexttime", "1988", "03", "24", "12", "30", "00");
	 ccpage.addCareAll("����", "lisa", birth, "���Űݷ�", "����", "ôô��");
	Assert.assertEquals(lpage.loginerror(),customerCareContent.addsucess);
  }
  /*
  //����������ػ�����
@Test(priority=3)
public void addCaseTwo(){
	page.clickXpath(customerCareContent.careadd);  //������
	String birth=ccpage.choseBirth("careNexttime", "1988", "03", "24", "12", "30", "00");
	ccpage.addCareAll("", "lisa", birth, "���Űݷ�", "����", "ôô��");
	Assert.assertEquals(lpage.loginerror(), customerCareContent.error1);
}

  
  //����������ػ�ʱ��
@Test(priority=4)
public void addCaseThree(){
	page.clickName(customerCareContent.back);  //�������
	page.clickXpath(customerCareContent.careadd);  //������
	ccpage.addCareOther("���", "lisa", "���Űݷ�", "����", "ôô��");
	Assert.assertEquals(lpage.loginerror(), customerCareContent.error2);
}
 */ 
 // �����ɹ�����֤ҳ���Ƿ�����ӵ���Ϣ
@Test(priority=5)
public void addCaseFour(){
	page.clickXpath(customerCareContent.careadd);
	 String birth=ccpage.choseBirth("careNexttime", "1999", "10", "24", "02", "30", "00");
	 ccpage.addCareAll("����״Ԫ", "lisa", birth, "���Űݷ�", "����", "��ʱ���");
	 lpage.loginerror();
	 
	 ccpage.findCare("lisa", "�ػ��ͻ�"); //�Ȳ�ѯ����Ϣ����
	 ccpage.addCareSucess( "lisa","����״Ԫ","���Űݷ�","", birth+".0", "��ʱ���" ,"����");//���ĸ��ǵ�ǰʱ�䣬ѡ���������Ա�

	
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
