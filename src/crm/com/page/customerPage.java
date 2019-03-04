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
		page.changeFrame(customerContent.leftframe); //�л�����ߵ�
		page.clickXpath(customerContent.click1); //����ͻ���Ϣ
		page.backFrame();
		page.changeFrame(customerContent.rightframe);
		page.clickXpath(customerContent.add);//������

	}
	
	//��½��ʼ�༭
	public void edit(){
		page=new BasePage(UseBrowser.driver);
		page.Add(customerContent.window1);
		page.changeFrame(customerContent.leftframe); //�л�����ߵ�
		page.clickXpath(customerContent.click1); //����ͻ���Ϣ
		page.backFrame();
		page.changeFrame(customerContent.rightframe);
	}

	//���4��������
	public void addCustomer(String cname,String email,String birth,String createman){
		page=new BasePage(UseBrowser.driver);
		page.sendKeyName(customerContent.Cname, cname);
		page.sendKeyName(customerContent.CEmail,email);
		page.sendKeyName(customerContent.Cbirth, birth);
		page.sendKeyName(customerContent.Ccreateman,createman);
		page.clickName(customerContent.Csubmit); //����ύ
	}
		


	//���һ���ɹ��Ŀͻ���Ϣ,��ȥ��������
	
	public void addSucess(String str1,String str2,String str3,String str4,String str5,String str6,String str7,String str8,String str9,String str10,
			String str11,String str12,String str13,String str14,String str15,String str16,String str17,String str18){
		page=new BasePage(UseBrowser.driver);
		page.sendKeyName(customerContent.Cname, str1);
		page.select( str2,customerContent.Csource); //�ͻ���Դ
		page.sendKeyName(customerContent.Cjob, str3);
		page.select(str4,customerContent.Ctype);
		page.single(str5);  //ѡ���л�Ů
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
		page.clickName(customerContent.Csubmit); //����

	}
	//�ֶ������������

	public String choseBirth(String ID,String birth){
		
		JavascriptExecutor js = (JavascriptExecutor) page.dirver;
		js.executeScript("document.getElementById('"+ID+"').readOnly=false;");
		return birth;
	}


	
	//������Ϣ�Ĳ�ѯ
	//��ȷ��ѯ
	public void CustFind(String name,String chose){
		page.sendKeyName(customerContent.selectName, name);  //��ѯ������
		page.select(chose, customerContent.findSelect); //��ѯ������
		page.clickXpath(customerContent.findButton);
	}
	
//ֱ�ӵ�¼��ѯ
	public void find(String name,String chose){
		page=new BasePage(UseBrowser.driver);
		page.Add(customerContent.window1);
		page.changeFrame(customerContent.leftframe); //�л�����ߵ�
		page.clickXpath(customerContent.click1); //����ͻ���Ϣ
		page.backFrame();
		page.changeFrame(customerContent.rightframe);
		page.sendKeyName(customerContent.selectName, name);  //��ѯ������
		page.select(chose, customerContent.findSelect); //��ѯ������
		page.clickXpath(customerContent.findButton);

	}
	
		//��ӿͻ���Ϣ�ɹ��󣬷���
		public void addallot(){
			page=new BasePage(UseBrowser.driver);
			page.backFrame();
			page.changeFrame(customerContent.leftframe); //�л�����ߵ�
			page.clickXpath(customerContent.click2); //����ͻ�����
			page.backFrame();
			page.changeFrame(customerContent.rightframe);

		}
		//����ͻ���ʱ�򣬸��ݿͻ�������ȷ��ѯ,
		public void selectAllot(String name,String men){   //men�Ƿ����Ա��
			WebElement n=page.dirver.findElement(By.xpath(customerContent.findload));
			String a=n.getText();// 
			String findChar=a.substring(5, 6);
			int last=Integer.parseInt(findChar);//ǿ��ת����int��
			System.out.print(last);
			String [] arrayA=new String[last];
			String [] arrayB=new String[last];
			int sum=0;
			
			if(last<=20){
				for(int i=0;i<last;i++){
					arrayA[i]="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr["+(i+2)+"]/td[2]/div/span";//�ͻ�����
					arrayB[i]="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr["+(i+2)+"]/td[1]/div/input";//��Ӧ�ͻ�ǰ��ĸ�ѡ��
					if(page.dirver.findElement(By.xpath(arrayA[i])).getText().equals(name)){
						sum=sum+1;
						page.clickXpath(arrayB[i]);
					}				 
				}							
			}
			
			System.out.println("��ƥ���"+sum+"����Ϣ");  
			page.clickXpath(customerContent.allotcustomer);  //������ѡ�ͻ�
			page.delay(2);
			page.select(men, customerContent.allotmen);
			page.clickName(customerContent.allotbutton);
			page.delay(2);
		}
		
		//����ͻ���Ϣ�ɹ����л�frame
		public void addallotBack(){
			//page=new BasePage(UseBrowser.driver);
			page.backFrame();
			page.changeFrame(customerContent.leftframe); //�л�����ߵ�
			page.clickXpath(customerContent.click1); //����ͻ���Ϣ
			page.backFrame();
			page.changeFrame(customerContent.rightframe);

		}
		
		//����ͻ���Ϣ�ɹ��󣬲�ѯ����
		//���ݿͻ�����ģ����ѯ
			public boolean mohu(String name,String type){
				//name�ǲ�ѯ���������ݣ�type������
				page.sendKeyName(customerContent.selectName, name);
				page.select(type, customerContent.findSelect);
				page.clickXpath(customerContent.findButton);
				
				WebElement n=page.dirver.findElement(By.xpath(customerContent.findload));
				String a=n.getText();// 
				String findChar=a.substring(4, 5);
				System.out.print(findChar);
				int last=Integer.parseInt(findChar);//ǿ��ת����int��
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
				System.out.println("��ƥ���"+sum+"����Ϣ");  
				if(sum==last){
					return true;
				}
				else{
					return false;
				}
			}	
		
	//	����ҳ���ƥ����Ϣ����
			//���ݿͻ�����ģ����ѯ
			public int MOHU(String name,String type){
				//name�ǲ�ѯ���������ݣ�type������
				page.sendKeyName(customerContent.selectName, name);
				page.select(type, customerContent.findSelect);
				page.clickXpath(customerContent.findButton);
				
				WebElement n=page.dirver.findElement(By.xpath(customerContent.findload));
				String a=n.getText();// 
				String findChar=a.substring(4, 5);
				System.out.print(findChar);
				int last=Integer.parseInt(findChar);//ǿ��ת����int��
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
				System.out.println("��ƥ���"+sum+"����Ϣ");  
				return sum;
			}		
			
			
	//�༭��Ϣ,ģ����ѯ��������Ϣ���ٱ༭
			public void selectEdit(String name,String chose,int m){   //men�Ƿ����Ա��,m�ǵ�ƥ�������ʱ��Ҫ�޸ĵ�����
				page=new BasePage(UseBrowser.driver);
				page.sendKeyName(customerContent.selectName, name);  //��ѯ������
				page.select(chose, customerContent.findSelect); //��ѯ������
				page.clickXpath(customerContent.findButton);
				WebElement n=page.dirver.findElement(By.xpath(customerContent.findload));
				String a=n.getText();// 
				String findChar=a.substring(4, 5);
				int last=Integer.parseInt(findChar);//ǿ��ת����int��
				System.out.print(last);
				String [] arrayA=new String[last];
				int sum=0;	
				if(last<=20){
					for(int i=0;i<last;i++){
						arrayA[i]="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr["+(i+2)+"]/td[1]/div/span";//�ͻ�����
							if(page.dirver.findElement(By.xpath(arrayA[i])).getText().contains(name)){
							sum=sum+1;
							
						}				 
					}							
				}
				
				System.out.println("һ����"+sum+"����Ϣ");  
				System.out.println("��ѡ����ǵ�"+m+"����Ϣ,�����޸�");  
				String edit="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr["+(m+1)+"]/td[13]/div/span/a[1]";//��Ӧ�ͻ�����ı༭
				page.clickXpath(edit);
				page.delay(2);
			}	
	//��ȷ��ѯ,�༭��Ա�ȫ����Ϣ		
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
						System.out.println("���ǵ�"+i+"��");
						break;
					}
				}
				System.out.println("���Ա���"+sum+"��");
				
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
			
			//�༭�ɹ�
				public void editSucess(String str1,String str2,String str3,String str4,String str5,String str6,String str7,String str8,String str9,String str10,
						String str11,String str12,String str13,String str14,String str15,String str16){
					page=new BasePage(UseBrowser.driver);

					page.select( str1,customerContent.editmen); //�ͻ���Դ
					page.select(str2,customerContent.Csource);
					page.select(str3,customerContent.Cstate);
					page.single(str4);  //ѡ���л�Ů
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
					page.clickName(customerContent.Csubmit); //����

				}
	//����ֱ�������ѡ���name�����޸Ķ�Ӧ��ѡ��
				public void editOnly(String name,String value ){
					page=new BasePage(UseBrowser.driver);	
					page.Clear(name);
					page.sendKeyName(name, value);
					page.clickName(customerContent.Csubmit); //����
				}
				
//��������ɾ���ͻ�
	public void deleteCust(int index){
		page=new BasePage(UseBrowser.driver);
		String find=page.dirver.findElement(By.xpath(customerContent.findload)).getText().substring(4, 5);//ȡ���ܹ���¼������
		System.out.println(find);
		int findnum=Integer.parseInt(find);
		if(findnum==0){
			System.out.println("û�м�¼���޷�ɾ��");
		}else if(findnum>1){
			System.out.println("��ǰҪɾ����Ϣ��ֹһ������ѡ���"+index+"��ɾ��");
			page.dirver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr["+(index+1)+"]/td[13]/div/span/a[3]")).click();
		}
		else{
			page.dirver.findElement(By.xpath(customerContent.delete)).click();
		}
	}
				
//����Excel���Ϊ��	
	public void Cell(int row){
		String [] Arr1={customerContent.Cname,customerContent.Csource,customerContent.Cjob,customerContent.Ctype,customerContent.Csex,customerContent.CEmail,
				customerContent.Cbirth,customerContent.Cstate,customerContent.Cphone,customerContent.Cqq,customerContent.Caddress,customerContent.Cchangeman,
				customerContent.Ccreateman,customerContent.Cweb,customerContent.Ctel,customerContent.Cmsn,customerContent.Ccompany,customerContent.Cmark};
	
	}


}


