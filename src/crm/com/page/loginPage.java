package crm.com.page;


import org.openqa.selenium.Alert;

import crm.com.base.BasePage;
import crm.com.base.UseBrowser;
import crm.com.content.loginContent;

public class loginPage {
	BasePage page;
		public void login(String uname,String pwd){
			page=new BasePage(UseBrowser.driver);
			page.sendKeyName(loginContent.username, uname);
			page.sendKeyName(loginContent.pwd, pwd);
			page.clickId(loginContent.savebutton);
			
		}
		
		//ץȡ�ɹ���¼����Ϣ
		public String loginsucess(){
			
			return page.dirver.getTitle();
		}
	//��¼ʧ��	,Ϊ��
		public String loginerror()  {
			page.delay(2);
			Alert alert=page.dirver.switchTo().alert();
			String error=alert.getText();
			page.delay(2);
			alert.accept();
			error=error.replace("\n", "");
			System.out.print(error);
			return error;	
			
		}

		
		//����û���������
		public void clear(String name,String pwd) {
			page=new BasePage(UseBrowser.driver);
			page.Change(loginContent.username);
			page.Change(loginContent.pwd);
		}
		
		
		
		
}
