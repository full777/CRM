package crm.com.page;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import crm.com.base.BasePage;
import crm.com.base.UseBrowser;
import crm.com.content.customerContent;

public class customerPage {
	BasePage page;
	public void add(){
		page=new BasePage(UseBrowser.driver);
		page.Add(customerContent.window1);
		page.changeFrame(customerContent.leftframe); //切换到左边的
		page.clickXpath(customerContent.click1); //点击客户信息
		page.backFrame();
		page.changeFrame(customerContent.rightframe);
		page.clickXpath(customerContent.add);//点击添加

	}
	
	//登陆后开始编辑
	public void edit(){
		page=new BasePage(UseBrowser.driver);
		page.Add(customerContent.window1);
		page.changeFrame(customerContent.leftframe); //切换到左边的
		page.clickXpath(customerContent.click1); //点击客户信息
		page.backFrame();
		page.changeFrame(customerContent.rightframe);
	}

	//添加4个必填项
	public void addCustomer(String cname,String email,String birth,String createman){
		page=new BasePage(UseBrowser.driver);
		page.sendKeyName(customerContent.Cname, cname);
		page.sendKeyName(customerContent.CEmail,email);
		page.sendKeyName(customerContent.Cbirth, birth);
		page.sendKeyName(customerContent.Ccreateman,createman);
		page.clickName(customerContent.Csubmit); //点击提交
	}
		


	//添加一条成功的客户信息,除去出生日期
	
	public void addSucess(String str1,String str2,String str3,String str4,String str5,String str6,String str7,String str8,String str9,String str10,
			String str11,String str12,String str13,String str14,String str15,String str16,String str17,String str18){
		page=new BasePage(UseBrowser.driver);
		page.sendKeyName(customerContent.Cname, str1);
		page.select( str2,customerContent.Csource); //客户来源
		page.sendKeyName(customerContent.Cjob, str3);
		page.select(str4,customerContent.Ctype);
		page.single(str5);  //选择男或女
		page.sendKeyName(customerContent.CEmail, str6);
		page.sendKeyName(customerContent.Cbirth,str7);
		page.select( str8,customerContent.Cstate);
		page.sendKeyName(customerContent.Cphone ,str9);
		page.sendKeyName(customerContent.Cqq, str10);
		page.sendKeyName(customerContent.Caddress, str11);
		page.sendKeyName(customerContent.Cchangeman, str12);
		page.sendKeyName(customerContent.Ccreateman, str13);
		page.sendKeyName(customerContent.Cweb, str14);
		page.sendKeyName(customerContent.Ctel, str15);
		page.sendKeyName(customerContent.Cmsn, str16);
		page.sendKeyName(customerContent.Ccompany, str17);
		page.sendKeyName(customerContent.Cmark, str18);
		page.clickName(customerContent.Csubmit); //保存

	}
	//手动输入出生日期

	public String choseBirth(String ID,String birth){
		
		JavascriptExecutor js = (JavascriptExecutor) page.dirver;
		js.executeScript("document.getElementById('"+ID+"').readOnly=false;");
		return birth;
	}


	
	//根据信息的查询
	//精确查询
	public void CustFind(String name,String chose){
		page.sendKeyName(customerContent.selectName, name);  //查询的内容
		page.select(chose, customerContent.findSelect); //查询的种类
		page.clickXpath(customerContent.findButton);
	}
	
//直接登录查询
	public void find(String name,String chose){
		page=new BasePage(UseBrowser.driver);
		page.Add(customerContent.window1);
		page.changeFrame(customerContent.leftframe); //切换到左边的
		page.clickXpath(customerContent.click1); //点击客户信息
		page.backFrame();
		page.changeFrame(customerContent.rightframe);
		page.sendKeyName(customerContent.selectName, name);  //查询的内容
		page.select(chose, customerContent.findSelect); //查询的种类
		page.clickXpath(customerContent.findButton);

	}
	
		//添加客户信息成功后，分配
		public void addallot(){
			page=new BasePage(UseBrowser.driver);
			page.backFrame();
			page.changeFrame(customerContent.leftframe); //切换到左边的
			page.clickXpath(customerContent.click2); //点击客户分配
			page.backFrame();
			page.changeFrame(customerContent.rightframe);

		}
		//分配客户的时候，根据客户姓名精确查询,
		public void selectAllot(String name,String men){   //men是分配的员工
			WebElement n=page.dirver.findElement(By.xpath(customerContent.findload));
			String a=n.getText();// 
			String findChar=a.substring(5, 6);
			int last=Integer.parseInt(findChar);//强制转换成int型
			System.out.print(last);
			String [] arrayA=new String[last];
			String [] arrayB=new String[last];
			int sum=0;
			
			if(last<=20){
				for(int i=0;i<last;i++){
					arrayA[i]="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr["+(i+2)+"]/td[2]/div/span";//客户姓名
					arrayB[i]="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr["+(i+2)+"]/td[1]/div/input";//对应客户前面的复选框
					if(page.dirver.findElement(By.xpath(arrayA[i])).getText().equals(name)){
						sum=sum+1;
						page.clickXpath(arrayB[i]);
					}				 
				}							
			}
			
			System.out.println("共匹配出"+sum+"条信息");  
			page.clickXpath(customerContent.allotcustomer);  //分配所选客户
			page.delay(2);
			page.select(men, customerContent.allotmen);
			page.clickName(customerContent.allotbutton);
			page.delay(2);
		}
		
		//分配客户信息成功后，切换frame
		public void addallotBack(){
			//page=new BasePage(UseBrowser.driver);
			page.backFrame();
			page.changeFrame(customerContent.leftframe); //切换到左边的
			page.clickXpath(customerContent.click1); //点击客户信息
			page.backFrame();
			page.changeFrame(customerContent.rightframe);

		}
		
		//分配客户信息成功后，查询姓名
		//根据客户姓名模糊查询
			public boolean mohu(String name,String type){
				//name是查询的输入内容，type是类型
				page.sendKeyName(customerContent.selectName, name);
				page.select(type, customerContent.findSelect);
				page.clickXpath(customerContent.findButton);
				
				WebElement n=page.dirver.findElement(By.xpath(customerContent.findload));
				String a=n.getText();// 
				String findChar=a.substring(4, 5);
				System.out.print(findChar);
				int last=Integer.parseInt(findChar);//强制转换成int型
				String [] arrayA=new String[last];
				int sum=0;
				
				if(last<=30){
					for(int i=0;i<last;i++){
						arrayA[i]="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr["+(i+2)+"]/td[1]/div/span";
						if(page.dirver.findElement(By.xpath(arrayA[i])).getText().contains(name)){
							sum=sum+1;
						}				 
					}							
				}
				System.out.println("共匹配出"+sum+"条信息");  
				if(sum==last){
					return true;
				}
				else{
					return false;
				}
			}	
		
	//	返回页面的匹配信息条数
			//根据客户姓名模糊查询
			public int MOHU(String name,String type){
				//name是查询的输入内容，type是类型
				page.sendKeyName(customerContent.selectName, name);
				page.select(type, customerContent.findSelect);
				page.clickXpath(customerContent.findButton);
				
				WebElement n=page.dirver.findElement(By.xpath(customerContent.findload));
				String a=n.getText();// 
				String findChar=a.substring(4, 5);
				System.out.print(findChar);
				int last=Integer.parseInt(findChar);//强制转换成int型
				String [] arrayA=new String[last];
				int sum=0;
				
				if(last<=30){
					for(int i=0;i<last;i++){
						arrayA[i]="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr["+(i+2)+"]/td[1]/div/span";
						if(page.dirver.findElement(By.xpath(arrayA[i])).getText().contains(name)){
							sum=sum+1;
						}				 
					}							
				}
				System.out.println("共匹配出"+sum+"条信息");  
				return sum;
			}		
			
			
	//编辑信息,模糊查询出来的信息，再编辑
			public void selectEdit(String name,String chose,int m){   //men是分配的员工,m是当匹配出多条时，要修改的行数
				page=new BasePage(UseBrowser.driver);
				page.sendKeyName(customerContent.selectName, name);  //查询的内容
				page.select(chose, customerContent.findSelect); //查询的种类
				page.clickXpath(customerContent.findButton);
				WebElement n=page.dirver.findElement(By.xpath(customerContent.findload));
				String a=n.getText();// 
				String findChar=a.substring(4, 5);
				int last=Integer.parseInt(findChar);//强制转换成int型
				System.out.print(last);
				String [] arrayA=new String[last];
				int sum=0;	
				if(last<=20){
					for(int i=0;i<last;i++){
						arrayA[i]="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr["+(i+2)+"]/td[1]/div/span";//客户姓名
							if(page.dirver.findElement(By.xpath(arrayA[i])).getText().contains(name)){
							sum=sum+1;
							
						}				 
					}							
				}
				
				System.out.println("一共有"+sum+"条信息");  
				System.out.println("您选择的是第"+m+"条信息,进行修改");  
				String edit="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr["+(m+1)+"]/td[13]/div/span/a[1]";//对应客户后面的编辑
				page.clickXpath(edit);
				page.delay(2);
			}	
	//精确查询,编辑后对比全部信息		
			public boolean editCompare(String str1,String str2,String str3,String str4,String str5,String str6,String str7,String str8,String str9,String str10,
					String str11,String str12){
				String [] Array=new String []{str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12};		
				int sum=0;
				for(int i=0;i<Array.length;i++){
					String xpath="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td["+(i+1)+"]/div/span";
					if(page.dirver.findElement(By.xpath(xpath)).getText().equals(Array[i])){
						sum=sum+1;
					}
					else
					{
						System.out.println("这是第"+i+"个");
						break;
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
			
			//
			public void CustAddAll(){
				
			}
			
			//编辑成功
				public void editSucess(String str1,String str2,String str3,String str4,String str5,String str6,String str7,String str8,String str9,String str10,
						String str11,String str12,String str13,String str14,String str15,String str16){
					page=new BasePage(UseBrowser.driver);

					page.select( str1,customerContent.editmen); //客户来源
					page.select(str2,customerContent.Csource);
					page.select(str3,customerContent.Cstate);
					page.single(str4);  //选择男或女
					page.select(str5,customerContent.Ctype);
					page.Change(customerContent.Cphone);
					page.sendKeyName(customerContent.Cphone ,str6);
					page.Change(customerContent.Cqq);
					page.sendKeyName(customerContent.Cqq, str7);
					page.Clear(customerContent.Caddress);
					page.sendKeyName(customerContent.Caddress, str8);
					page.Clear(customerContent.CEmail);
					page.sendKeyName(customerContent.CEmail, str9);
					page.Clear(customerContent.Cjob);
					page.sendKeyName(customerContent.Cjob, str10);
					page.Clear(customerContent.Cweb);
					page.sendKeyName(customerContent.Cweb, str11);
					page.Clear(customerContent.Ctel);
					page.sendKeyName(customerContent.Ctel, str12);
					page.Clear(customerContent.Cmsn);
					page.sendKeyName(customerContent.Cmsn, str13);
					page.Clear(customerContent.Ccompany);
					page.sendKeyName(customerContent.Ccompany, str14);
					page.Clear(customerContent.Cchangeman);
					page.sendKeyName(customerContent.Cchangeman, str15);
					page.Clear(customerContent.Cmark);
					page.sendKeyName(customerContent.Cmark, str16);
					page.clickName(customerContent.Csubmit); //保存

				}
	//根据直接输入的选项的name，来修改对应的选项
				public void editOnly(String name,String value ){
					page=new BasePage(UseBrowser.driver);	
					page.Clear(name);
					page.sendKeyName(name, value);
					page.clickName(customerContent.Csubmit); //保存
				}
				
//根据姓名删除客户
	public void deleteCust(int index){
		page=new BasePage(UseBrowser.driver);
		String find=page.dirver.findElement(By.xpath(customerContent.findload)).getText().substring(4, 5);//取出总共记录的条数
		System.out.println(find);
		int findnum=Integer.parseInt(find);
		if(findnum==0){
			System.out.println("没有记录，无法删除");
		}else if(findnum>1){
			System.out.println("当前要删除信息不止一条，您选择第"+index+"条删除");
			page.dirver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr["+(index+1)+"]/td[13]/div/span/a[3]")).click();
		}
		else{
			page.dirver.findElement(By.xpath(customerContent.delete)).click();
		}
	}
				
//处理Excel表格为空	
	public void Cell(int row){
		String [] Arr1={customerContent.Cname,customerContent.Csource,customerContent.Cjob,customerContent.Ctype,customerContent.Csex,customerContent.CEmail,
				customerContent.Cbirth,customerContent.Cstate,customerContent.Cphone,customerContent.Cqq,customerContent.Caddress,customerContent.Cchangeman,
				customerContent.Ccreateman,customerContent.Cweb,customerContent.Ctel,customerContent.Cmsn,customerContent.Ccompany,customerContent.Cmark};
	
	}


}


