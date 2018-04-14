package cjb.shop.user.service;

import java.io.IOException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cjb.shop.user.dao.UserDao;
import cjb.shop.user.domain.User;
import cjb.shop.utils.PageBean;
import utils.MailUitls;
import utils.UUIDUtils;

/**
 * @author chenjibao
 *@date2018年3月30日下午9:45:07
 *@description;用户模块业务层类
 */
@Transactional
public class UserService {
	// 注入UserDao
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	// 按用户名查询用户的方法:
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}
	/**
	 * 用户注册的方法
	 * @param user
	 * @throws IOException 
	 */
	// 业务层完成用户注册代码:
	public void save(User user) {
		// 将数据存入到数据库
		user.setState(1); // 0:代表用户未激活.  1:代表用户已经激活.
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		//因为阿里云服务器端口25没有解封，所以暂时关闭邮件发送功能
		//MailUitls.sendMail(user.getEmail(), code);
		/*
		 * 发邮件
		 * 准备配置文件！
		 */
		// 获取配置文件内容
		/*Properties props = new Properties();
		try {
			props.load(this.getClass().getClassLoader()
					.getResourceAsStream("email_template.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String host = props.getProperty("host");//获取服务器主机
		String uname = props.getProperty("uname");//获取用户名
		String pwd = props.getProperty("pwd");//获取密码
		String from = props.getProperty("from");//获取发件人
		String to = user.getEmail();//获取收件人
		String subject = props.getProperty("subject");//获取主题
		String content = props.getProperty("content");//获取邮件内容
		content = MessageFormat.format(content, code);//替换{0}
		Session session = MailUtils.createSession(host, uname, pwd);//得到session
		Mail mail = new Mail(from, to, subject, content);//创建邮件对象
		try {
			try {//发邮件！
				MailUtils.send(session, mail);
				System.out.println("邮件发送成功");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("邮件发送失败");
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}*/
	}

	public User findByCode(String code) {
		return userDao.findByCode(code);
	}
	/**
	 * 修改用户状态的方法
	 * @param existUser
	 */
	public void update(User existUser) {
		userDao.update(existUser);
	}
	
	/**
	 * 用户登录的方法
	 * @param user
	 */
	public User login(User user) {
		return userDao.login(user);
	}

	// 业务层用户查询所有
		public PageBean<User> findByPage(Integer page) {
			PageBean<User> pageBean = new PageBean<User>();
			// 设置当前页数:
			pageBean.setPage(page);
			// 设置每页显示记录数:
			// 显示5个
			int limit = 5;
			pageBean.setLimit(limit);
			// 设置总记录数:
			int totalCount = 0;
			totalCount = userDao.findCount();
			pageBean.setTotalCount(totalCount);
			// 设置总页数
			int totalPage = 0;
			if(totalCount % limit == 0){
				totalPage = totalCount / limit;
			}else{
				totalPage = totalCount / limit + 1;
			}
			pageBean.setTotalPage(totalPage);
			// 设置每页显示数据集合:
			int begin = (page - 1)*limit;
			List<User> list = userDao.findByPage(begin,limit);
			pageBean.setList(list);
			return pageBean;
		}


		public User findByUid(Integer uid) {
			return userDao.findByUid(uid);
		}

		public void delete(User existUser) {
			userDao.delete(existUser);
		}

}
