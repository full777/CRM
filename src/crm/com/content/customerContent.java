package crm.com.content;

public class customerContent {
	public static final String window1="客户关系管理系统";
	public static final String topframe="//*[@id='topFrame']";  //上边的xpath
	public static final String leftframe="/html/frameset/frameset/frame[1]";  //左边的xpath
	public static final String rightframe="/html/frameset/frameset/frame[2]"; //右边的xpath
	public static final String click1="//*[@id='submenu1']/div/table/tbody/tr[1]/td/table/tbody/tr[1]/td[2]/table/tbody/tr/td/span/a";//客户信息
	public static final String click2="//*[@id='submenu1']/div/table/tbody/tr[1]/td/table/tbody/tr[2]/td[2]/table/tbody/tr/td/span/a";//客户分配
	public static final String find="/html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td[2]/table/tbody/tr/td[3]/input"; //查询
	public static final String add="/html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td[2]/table/tbody/tr/td[4]/input"; //添加
	public static final String delete="/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[13]/div/span/a[3]";//删除第一行的信息
	public static final String Cname="customerName";
	public static final String Csource="customerSource" ;
	public static final String Cjob="customerJob";
	public static final String Ctype="customerType";
	public static final String Csex="customerSex"; //客户性别
	public static final String CEmail="customerEmail";
	public static final String Cbirth="customerBirthday";  //点击弹出选择框
	public static final String Cstate="customerCondition";//客户状态
	public static final String Cphone="customerMobile";
	public static final String Cqq="customerQq";
	public static final String Caddress="customerAddress";
	public static final String Cchangeman="customerChangeMan";
	public static final String Ccreateman="customerAddMan";
	public static final String Cweb="customerBlog";
	public static final String Ctel="customerTel";
	public static final String Cmsn="customerMsn";
	public static final String Ccompany="customerCompany";
	public static final String Cmark="customerRemark";
	public static final String Csubmit="submit";
	public static final String Creset="reset";
	public static final String Creturn="button"; //返回
	public static final String error1="- 客户姓名不能为空!- Email不能为空- 出生日期不能为空!- 创建人不能为空!";
	public static final String error2="- Email不能为空- 出生日期不能为空!- 创建人不能为空!";//填客户名
	public static final String error3="- 客户姓名不能为空!- 出生日期不能为空!- 创建人不能为空!";	 //填email
	public static final String error4="- 客户姓名不能为空!- Email不能为空- 创建人不能为空!";//填出身
	public static final String error5="- 客户姓名不能为空!- Email不能为空- 出生日期不能为空!";//填创建人
	public static final String  error6="- Email格式不对!";
	public static final String  error7="- 请输入正确的手机号码!";
	public static final String  error8="- 请输入正确的座机号码!";
	
	
	public static final String year="//*[@id='dpTitle']/div[4]/input";
	public static final String month="//*[@id='dpTitle']/div[3]/input";
	public static final String hour="//*[@id='dpTime']/table/tbody/tr[1]/td[1]/input[1]";
	public static final String minute="//*[@id='dpTime']/table/tbody/tr[1]/td[1]/input[3]";
	public static final String second="//*[@id='dpTime']/table/tbody/tr[1]/td[1]/input[5]";
	public static final String save="dpOkInput";  //日期确定
	
	public static final String sucess="客户添加成功";
	
	//查询
	public static final String selectName="customerInput";  //输入查询内容
	public static final String findSelect="queryType"; //查询方式
	public static final String findButton="/html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td[2]/table/tbody/tr/td[3]/input";  //查询按钮
										
	public static final String  findload="/html/body/form/table/tbody/tr[3]/td/table/tbody/tr/td[2]/table/tbody/tr/td[1]";//查询记录显示
	public static final String selectallot="/html/body/form/table/tbody/tr[3]/td/table/tbody/tr/td[2]/table/tbody/tr/td[1]"; //分配的记录显示
	public static final String allotcustomer="/html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td[2]/table/tbody/tr/td[2]/input"; //分配所选客户按钮
	public static final String allotmen="customerForUser"; //要分配给的员工
	public static final String allotbutton="submit";
	public static final String allotSucess="客户分配成功";

	//编辑
	public static final String editmen="customerForUser";
	public static final String editSucess="客户修改成功";
	public static final String deleteSucess="客户信息删除成功";
	//编辑座机格式错误
	public static final String editError1="- 请输入正确的座机号码!";
//邮箱格式错误
	public static final String editError2="- Email格式不对!";
//手机号格式不对
	public static final String editError3="- 请输入正确的手机号码!";
	

		
	
	
	
	
	
	
	
			
			
	
	
	
	
	
	
}
