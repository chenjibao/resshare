package cjb.shop.adminuser.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cjb.shop.adminuser.domain.AdminUser;

/**
 *@author chenjibao
 *@date2018年4月8日上午9:56:00
 *@description:后台用户dao层的类
 */

public class AdminUserDao {
			//得到hibernateTemplate对象
			private HibernateTemplate hibernateTemplate;
			public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
				this.hibernateTemplate = hibernateTemplate;
			}
			//后台管理员登录的方法
			public AdminUser login(AdminUser adminUser) {
				String hql="from AdminUser where username=? and password=?";
				List<AdminUser> list=(List<AdminUser>) hibernateTemplate.find(hql, adminUser.getUsername(),adminUser.getPassword());
				if(list!=null && list.size()>0){
					return list.get(0);
				}
				return null;
			}

}
