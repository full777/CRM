package crm.com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import crm.com.base.BasePage;
import crm.com.base.UseBrowser;
import crm.com.content.customerCareContent;
import crm.com.content.customerContent;

public class customerCarePage {
	BasePage page;
	//进入客户关怀子页面
	public void addCareStart(){
		page=new BasePage(UseBrowser.driver);
		page.Add(customerContent.window1);
		page.changeFrame(customerContent.leftframe); //切换到左边的
		page.clickXpath(customerCareContent.care); //点击客户关怀
		page.backFrame();
		page.changeFrame(customerContent.rightframe);
		page.clickXpath(customerContent.add);//点击添加

	}
	
	//添加所有的
	public void addCareAll(String theme,String people,String time,String ways,String who,String mark){
		page.sendKeyName(customerCareContent.caretheme, theme);
		page.select(people, customerCareContent.careid);
		page.sendKeyName(customerCareContent.caretime, time);
		page.select(ways, customerCareContent.careway);
		page.sendKeyName(customerCareContent.carewho, who);
		page.sendKeyName(customerCareContent.caremark, mark);
		page.clickName(customerContent.Csubmit);
		
	}
//添加除"关怀时间"之外的
	public void addCareOther(String theme,String people,String ways,String who,String mark){
		page.sendKeyName(customerCareContent.caretheme, theme);
		page.select(people, customerCareContent.careid);
		page.select(ways, customerCareContent.careway);
		page.sendKeyName(customerCareContent.carewho, who);
		page.sendKeyName(customerCareContent.caremark, mark);
		page.clickName(customerContent.Csubmit);
	}
	
	//手动输入出生日期
	public String choseBirth(String ID,String year,String month, String day,String hour,String min,String sec){
		
		JavascriptExecutor js = (JavascriptExecutor) page.dirver;
		js.executeScript("document.getElementById('"+ID+"').readOnly=false;");
		return year+"-"+month+"-"+day+" "+hour+":"+min+":"+sec;
	}
//验证是否新增成功
	public boolean addCareSucess(String str1,String str2,String str3,String str4,String str5,String str6,String str7){
			String num=page.dirver.findElement(By.xpath(customerContent.findload)).getText().substring(5, 6);
			int number=Integer.parseInt(num);
				String [] Array=new String []{str1,str2,str3,str4,str5,str6,str7};		
				int sum=0;
				for(int i=0;i<Array.length;i++){
					String xpath="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr["+(number+1)+"]/td["+(i+2)+"]/div/span";  //客户的姓名那列,由于添加成功的在最后一列
					if(page.dirver.findElement(By.xpath(xpath)).getText().equals(Array[i])){						
						if(i+2!=5){
							sum=sum+1;
						}
						else{
							continue;
						}
					}
					else
					{
						System.out.println("这是第"+(i+1)+"个跳过");
						continue;
					}
				}
				System.out.println("共对比了"+sum+"项");
				
				if(sum==Array.length){
					return true;
				}
				else{
					return false;
				}
			}
//根据客户姓名，查询添加的内容,返回一个值是记录的条数
	public void findCare(String name,String chose){
		page.sendKeyName(customerContent.selectName, name);  //查询的内容
		page.select(chose, customerContent.findSelect); //查询的种类
		page.clickXpath(customerContent.findButton);
		
	}

	
	
}
