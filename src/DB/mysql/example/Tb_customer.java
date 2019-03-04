//类的名字要和对应的表的名字一致
package DB.mysql.example;

public class Tb_customer {
	private int oid;
	private String otime;
	private String oinfo;
	private String oq;
	private String ocNo;
	private String oPNo;
	//另一个表
	private int proNO;
	private String proName;
	public int getProNO() {
		return proNO;
	}
	public void setProNO(int proNO) {
		this.proNO = proNO;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	

public int  getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public String getOtime() {
	return otime;
}
public void setOtime(String otime) {
	this.otime = otime;
}
public String getOinfo() {
	return oinfo;
}
public void setOinfo(String oinfo) {
	this.oinfo = oinfo;
}
public String getOq() {
	return oq;
}
public void setOq(String oq) {
	this.oq = oq;
}
public String getOcNo() {
	return ocNo;
}
public void setOcNo(String ocNo) {
	this.ocNo = ocNo;
}
public String getoPNo() {
	return oPNo;
}
public void setoPNo(String oPNo) {
	this.oPNo = oPNo;
}


}
