package cjb.shop.user.action;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cjb.shop.user.domain.User;
import cjb.shop.user.service.UserService;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
/**
 * @author chenjibao
 *@date2018年3月30日下午8:42:14
 *@description:用户模块Aciton
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	// 注入UserService
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserService getUserService() {
		return userService;
	}
	
	private String checkcode;

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	//模型驱动要使用的对象
	private User user=new User();
	@Override
	public User getModel() {
		return user;
	}
	
	/**
	 * 跳转到注册页面的方法
	 */
	public String registPage() {
		return "registPage";
	}
	/**
	 * 用户激活的方法
	 * @return
	 */
	public String active(){
		//按照激活码查询用户
		User existUser=userService.findByCode(user.getCode());
		if(existUser==null){
			this.addActionMessage("激活失败：激活码错误");
		}else{
			//激活成功，修改用户状态
			existUser.setState(1);
			userService.update(existUser);
			this.addActionMessage("激活成功，您可以登录了");
		}
		return "msg";
	}
	
	/**
	 * AJAX进行异步校验用户名的执行方法
	 * 
	 * @throws IOException
	 */
	public String findByUsername() throws IOException {
		// 调用Service进行查询:
		User existUser = userService.findByUsername(user.getUsername());
		// 获得response对象,项页面输出:
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// 判断
		if (existUser != null) {
			// 查询到该用户:用户名已经存在
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		} else {
			// 没查询到该用户:用户名可以使用
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return NONE;
	}
	/**
	 * 用户注册的方法
	 * @return
	 * @throws IOException 
	 */
	public String regist() {
		String checkcode1=(String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(checkcode1)){//验证码错误
			this.addActionError("验证码错误");
			return "checkcodeFail";
		}
		userService.save(user);
		this.addActionMessage("注册成功,请登录！");
		return "msg";
	}
	/**
	 * 跳转到登录页面
	 * @return
	 */
	public String loginPage(){
		return "loginPage";
	}
	
	/**
	 * 用户登录的方法
	 * @return
	 */
	public String login(){
		String checkcode1=(String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(checkcode1)){//验证码错误
			this.addActionError("验证码错误");
			return "checkcodeFail1";
		}
		User existUser=userService.login(user);
		if(existUser==null){
			//登录失败
			this.addActionError("登录失败:用户名或密码错误或用户未激活!");
			return LOGIN;
		}else{
			//登录成功
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return "loginSuccess";
		}
	}
	/**
	 * 用户退出的方法
	 * @return
	 */
	public String quit(){
		//销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}

}
