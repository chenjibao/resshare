package cjb.shop.adminuser.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cjb.shop.adminuser.domain.AdminUser;
import cjb.shop.adminuser.service.AdminUserService;
/**
 *@author chenjibao
 *@date2018年4月8日上午9:52:32
 *@description:后台管理的Action
 */
public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser>{
	//模型
	private AdminUser adminUser=new AdminUser();
	//注入service
	private AdminUserService adminUserService;
	
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	@Override
	public AdminUser getModel() {
		return adminUser;
	}

	public String login(){
		AdminUser existAdminUser=adminUserService.login(adminUser);
		if(existAdminUser==null){
			//登录失败
			this.addActionError("用户名或密码错误");
			return "loginFail";
		}else{
			//登录成功
			ServletActionContext.getRequest().getSession().setAttribute("existAdminUser", existAdminUser);
			return "loginSuccess";
		}
	}
}
