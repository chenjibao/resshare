package cjb.shop.user.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cjb.shop.user.domain.User;
import utils.PageHibernateCallback;


/**
 * @author chenjibao
 *@date2018年3月30日下午9:44:37
 *@description:用户模块持久层类
 */
public class UserDao {
		//得到hibernateTemplate对象
		private HibernateTemplate hibernateTemplate;
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
		

	   public HibernateTemplate getHibernateTemplate() {
			return hibernateTemplate;
		}


	/**
	 * 按用户名查询是否有该用户
	 * @param username
	 * @return
	 */
	public User findByUsername(String username){
		String hql="from User where username=?";
		List<User> list=(List<User>)hibernateTemplate.find(hql, username);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	/**
	 * 向user表汇总插入一条记录
	 * @param user
	 */
	// 注册用户存入数据库代码实现
	public void save(User user) {
		
		hibernateTemplate.save(user);
	}


	public User findByCode(String code) {
		String hql="from User where code=?";
		List<User> list=(List<User>) hibernateTemplate.find(hql, code);
		if(list!=null && list.size()>=0){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 修改用户状态的方法
	 * @param existUser
	 */
	public void update(User existUser) {
		hibernateTemplate.update(existUser);
	}

	/**
	 * 用户登录的方法
	 * @param user
	 * @return
	 */
	public User login(User user) {
		String hql="from User where username=? and password=? and state=?";
		List<User> list=(List<User>) hibernateTemplate.find(hql, user.getUsername(),user.getPassword(),1);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}


	public List<User> findByPage(int begin, int limit) {
		String hql = "from User";
		List<User> list = hibernateTemplate.execute(
				new PageHibernateCallback<User>(hql, null, begin, limit));
		return list;
	}


	public int findCount() {
		String hql = "select count(*) from User";
		List<Long> list = (List<Long>) hibernateTemplate.find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}


	public User findByUid(Integer uid) {
		return hibernateTemplate.get(User.class, uid);
	}


	public void delete(User existUser) {
		hibernateTemplate.delete(existUser);
	}
}
