package cjb.shop.adminuser.service;

import org.springframework.transaction.annotation.Transactional;

import cjb.shop.adminuser.dao.AdminUserDao;
import cjb.shop.adminuser.domain.AdminUser;

/**
 *@author chenjibao
 *@date2018年4月8日上午9:55:05
 *@description:后台用户业务层类
 */
@Transactional
public class AdminUserService {
	//注入dao
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}
	//管理员登录的方法
	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}
	
}
