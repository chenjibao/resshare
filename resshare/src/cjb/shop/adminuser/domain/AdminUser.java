package cjb.shop.adminuser.domain;
/**
 *@author chenjibao
 *@date2018年4月8日上午9:49:03
 *@description:：后台管理员实体
 */
public class AdminUser {
	private Integer uid;
	private String username;
	private String password;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
