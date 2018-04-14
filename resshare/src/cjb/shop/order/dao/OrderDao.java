package cjb.shop.order.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cjb.shop.order.domain.Order;
import cjb.shop.order.domain.OrderItem;
import utils.PageHibernateCallback;

public class OrderDao {
		//注入HibernateTemplate
		private HibernateTemplate hibernateTemplate;
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
		//生成订单
		public void save(Order order) {
			hibernateTemplate.save(order);
		}
		//dao层我的订单的个数统计（根据用户id查询用户的订单个数）
		public Integer findCountByUid(Integer uid) {
			String hql="select count(*) from Order o where o.user.uid=?";
			List<Long> list=(List<Long>) hibernateTemplate.find(hql, uid);
			if(list!=null && list.size()>0){
				return list.get(0).intValue();
			}
			return null;
		}
		//dao层我的订单当前页的集合查询
		public List<Order> findPageByUid(Integer uid, int begin, int limit) {
			String hql="from Order o where o.user.uid=? order by ordertime desc";
			List<Order> list= hibernateTemplate.execute(new PageHibernateCallback<Order>(hql, new Object[]{uid}, begin, limit)); 
			return list;
		}
		//根据订单id查询订单
		public Order findByOid(Integer oid) {
			return hibernateTemplate.get(Order.class, oid);
		}
		//修改订单
		public void update(Order currOrder) {
			hibernateTemplate.update(currOrder);
		}
		//dao层统计订单个数的方法
		public int findCount() {
			String hql="select count(*) from Order";
			List<Long> list=(List<Long>) hibernateTemplate.find(hql);
			if(list!=null && list.size()>0){
				return list.get(0).intValue();
			}
			return 0;
		}
		//dao层带分页的查询所有订单的方法
		public List<Order> findByPage(int begin, int limit) {
			String hql="from Order order by ordertime desc";
			List<Order> list=hibernateTemplate.execute(new PageHibernateCallback<Order>(hql, null, begin, limit));
			if(list!=null && list.size()>0){
				return list;
			}
			return null;
		}
		//dao层根据订单id去查询订单项的方法
		public List<OrderItem> findOrderItem(Integer oid) {
			String hql="from OrderItem oi where oi.order.oid=?";
			List<OrderItem> list=(List<OrderItem>) hibernateTemplate.find(hql, oid);
			if(list!=null && list.size()>0){
				return list;
			}
			return null;
		}

}
