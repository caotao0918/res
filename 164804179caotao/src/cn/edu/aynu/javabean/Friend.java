package cn.edu.aynu.javabean;

public class Friend {
	private int userId;
	private int id;
	private String name;
	private String tel;
	private String addr;
	public Friend() {
	}
	public Friend(int userId, int id, String name, String tel, String addr) {
		this.userId = userId;
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Friend [userId=" + userId + ", id=" + id + ", name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}
	
	
}
