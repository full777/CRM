package crm.com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
public WebDriver dirver;
	public BasePage(WebDriver dirver){
		this.dirver=dirver;
	}
    //����ַ
  	public void getUrl(String url){
  		dirver.get(url);
  	}
	//���,name
	public void clickName(String name){
		WebElement login=dirver.findElement(By.name(name));
		login.click();
		
	}

	//���,��id
	public void clickId(String id){
		
		WebElement click=dirver.findElement(By.id(id));
		click.click();
	}
	//���,��xpath
	public void clickXpath(String xpath){
		
		WebElement click=dirver.findElement(By.xpath(xpath));
		click.click();
	}
	//����xpath����ȡ��Ϣ
	
	public String gettext(String xpath){
		WebElement text=dirver.findElement(By.xpath(xpath));
		return text.getText();
		
	}
	
	//����name����ȡ��Ϣ
	
	public String getNameText(String name){
		WebElement nameText=dirver.findElement(By.name(name));
		return nameText.getText();
		
	}
	
	//����name��������Ϣ
	public void sendKeyName(String name,String key){
		WebElement send=dirver.findElement(By.name(name));
		send.sendKeys(key);

	}
	//����xpath��������Ϣ
	public void sendKeyXpath(String xpath,String key){
		WebElement send=dirver.findElement(By.xpath(xpath));
		send.sendKeys(key);

	}

	
//����
	public void delay(int n){
		try{
			Thread.sleep(n*1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	//�˳�ȫ��
	public void quit(){
		
		//driver.navigate().refresh();
		delay(5);
		dirver.quit();
	}
	
	//�رյ�ǰҳ
	public void close(){
		delay(2);
		dirver.close();
	}

	//��������ѡ��
	public void select(String value,String name ){
		
		WebElement selector=dirver.findElement(By.name(name));
		Select select=new Select(selector);
		select.selectByVisibleText(value);
		
	}

	//��ѯ��Ϣ
	public void find(String value,String key){
		dirver.findElement(By.name(value)).sendKeys(key);

			}	
	
	//����ת��

	public void Add(String infor){
		Set<String> add=dirver.getWindowHandles();
		for(String str : add){
			if(dirver.switchTo().window(str).getTitle().contains(infor)){  
				break;
		}

	}
	}

	//�л�frame
	public void changeFrame(String xpath){
		
		dirver.switchTo().frame(dirver.findElement(By.xpath(xpath)));
			delay(1);
						
	}

	//������һ����frame
	public void backFrame(){
		dirver.switchTo().parentFrame();
		delay(2);
	}
	//������һ��ҳ��
	public void back(){
		dirver.navigate().back();
		delay(5);
	}
	




	
	//�������������
	
	
public void Change(String name) {
	try{
			Actions actionDouble=new Actions(dirver);
			WebElement kw=dirver.findElement(By.name(name));
			kw.click();
			actionDouble.doubleClick(kw);
			actionDouble.build().perform();
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_DELETE);
			robot.keyRelease(KeyEvent.VK_ALT);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}
	
//�������������,����˫��
public void Clear(String name) {
	WebElement ys=dirver.findElement(By.name(name));
	ys.clear();

}


//��ѡ��ѡ���л�Ů

public void single(String sex){

	if(sex.equals("��")){
		clickXpath("/html/body/form/table[1]/tbody/tr[4]/td[2]/input[1]");

	}
	else if(sex.equals("Ů")){

		clickXpath("/html/body/form/table[1]/tbody/tr[4]/td[2]/input[2]");
	}
	else{
		System.out.println("�޴�ѡ��!");
		}

}

//������alert�򣬵��ȷ��
public void alertAccpet()  {
	delay(2);
	Alert alert=dirver.switchTo().alert();
	delay(2);
	alert.accept();
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
