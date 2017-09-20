package cart.bean;

public class User {
	private int uid;
	private String name;
	private String pwd;
	private String mailid;
	public User(int uid, String name, String pwd, String mailid) {
		super();
		this.uid = uid;
		this.name = name;
		this.pwd = pwd;
		this.mailid = mailid;
	}
	
	public User(String name, String pwd, String mailid) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.mailid = mailid;
	}

	public User(int uid) {
		super();
		this.uid = uid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	

}
