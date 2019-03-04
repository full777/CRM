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
    //打开网址
  	public void getUrl(String url){
  		dirver.get(url);
  	}
	//点击,name
	public void clickName(String name){
		WebElement login=dirver.findElement(By.name(name));
		login.click();
		
	}

	//点击,用id
	public void clickId(String id){
		
		WebElement click=dirver.findElement(By.id(id));
		click.click();
	}
	//点击,用xpath
	public void clickXpath(String xpath){
		
		WebElement click=dirver.findElement(By.xpath(xpath));
		click.click();
	}
	//根据xpath，获取信息
	
	public String gettext(String xpath){
		WebElement text=dirver.findElement(By.xpath(xpath));
		return text.getText();
		
	}
	
	//根据name，获取信息
	
	public String getNameText(String name){
		WebElement nameText=dirver.findElement(By.name(name));
		return nameText.getText();
		
	}
	
	//根据name，输入信息
	public void sendKeyName(String name,String key){
		WebElement send=dirver.findElement(By.name(name));
		send.sendKeys(key);

	}
	//根据xpath，输入信息
	public void sendKeyXpath(String xpath,String key){
		WebElement send=dirver.findElement(By.xpath(xpath));
		send.sendKeys(key);

	}

	
//休眠
	public void delay(int n){
		try{
			Thread.sleep(n*1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	//退出全部
	public void quit(){
		
		//driver.navigate().refresh();
		delay(5);
		dirver.quit();
	}
	
	//关闭当前页
	public void close(){
		delay(2);
		dirver.close();
	}

	//下拉单的选择
	public void select(String value,String name ){
		
		WebElement selector=dirver.findElement(By.name(name));
		Select select=new Select(selector);
		select.selectByVisibleText(value);
		
	}

	//查询信息
	public void find(String value,String key){
		dirver.findElement(By.name(value)).sendKeys(key);

			}	
	
	//窗口转换

	public void Add(String infor){
		Set<String> add=dirver.getWindowHandles();
		for(String str : add){
			if(dirver.switchTo().window(str).getTitle().contains(infor)){  
				break;
		}

	}
	}

	//切换frame
	public void changeFrame(String xpath){
		
		dirver.switchTo().frame(dirver.findElement(By.xpath(xpath)));
			delay(1);
						
	}

	//返回上一级的frame
	public void backFrame(){
		dirver.switchTo().parentFrame();
		delay(2);
	}
	//返回上一个页面
	public void back(){
		dirver.navigate().back();
		delay(5);
	}
	




	
	//清空输入框的输入
	
	
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
	
//清除输入框的内容,不用双击
public void Clear(String name) {
	WebElement ys=dirver.findElement(By.name(name));
	ys.clear();

}


//单选框选择男或女

public void single(String sex){

	if(sex.equals("男")){
		clickXpath("/html/body/form/table[1]/tbody/tr[4]/td[2]/input[1]");

	}
	else if(sex.equals("女")){

		clickXpath("/html/body/form/table[1]/tbody/tr[4]/td[2]/input[2]");
	}
	else{
		System.out.println("无此选项!");
		}

}

//弹出的alert框，点击确定
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
