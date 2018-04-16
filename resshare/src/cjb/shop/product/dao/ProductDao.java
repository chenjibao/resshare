package cjb.shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import cjb.shop.product.domain.Product;
import utils.PageHibernateCallback;
/**
 * @author chenjibao
 *@date2018年4月3日下午9:08:21
 *@description:商品的持久层类
 */
public class ProductDao {
	//注入hibernateTemplate对象
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	/**
	 * 热门商品的查询
	 * @return
	 */
	public List<Product> findHot() {
		//使用离线查询
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		criteria.add(Restrictions.eq("is_hot", 1));
		//按日期降序排序
		criteria.addOrder(Order.desc("pdate"));
		//执行查询
		List<Product> list=(List<Product>) hibernateTemplate.findByCriteria(criteria, 0, 20);
		return list;
	}
	/**
	 * 首页最新商品查询
	 * @return
	 */
	public List<Product> findNew() {
		//使用离线查询
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//按日期降序排序
		criteria.addOrder(Order.desc("pdate"));
		//执行查询，显示最新商品10件
		List<Product> list=(List<Product>) hibernateTemplate.findByCriteria(criteria, 0, 10);
		return list;
	}
	/**
	 * 根据商品的id查询商品
	 * @param pid
	 * @return
	 */
	public Product findByPid(Integer pid) {
		return hibernateTemplate.get(Product.class, pid);
	}
	/**
	 * 根据分类的id查询商品的个数
	 * @param cid
	 * @return
	 */
	public int findTotalCountByCid(Integer cid) {
		String hql="select count(*) from Product p where p.categorySecond.category.cid=?";
		List<Long> list=(List<Long>) hibernateTemplate.find(hql, cid);
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	/**
	 * 根据一级分类id查询商品的集合
	 * @param cid
	 * @param begin
	 * @param limit
	 * @return
	 */
	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		//多表查询
		//普通sql:select p.* from category c, categorysecond cs, prouct p where c.cid=cs.cid and cs.csid=p.csid and c.cid=?;
		//hql(1):select p from Category c,CategorySecond cs,Product p where c.cid=cs.category.cid and cs.csid=p.categorySecond.csid  and c.cid=?;
		//hql(2):select p from Product p join p.categorySecond cs join cs.category c where c.cid=?;
		String hql="select p from Product p join p.categorySecond cs join cs.category c where c.cid=?";
		List<Product> list=(List<Product>) hibernateTemplate.execute((HibernateCallback<Product>) new PageHibernateCallback(hql, new Object[]{cid}, begin, limit));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}
	/**
	 * 根据二级分类去查询商品个数
	 * @param csid
	 * @return
	 */
	public int findTotalCountByCsid(Integer csid) {
		String hql="select count(*) from Product p where p.categorySecond.csid=?";
		List<Long> list=(List<Long>) hibernateTemplate.find(hql, csid);
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
;		return 0;
	}
	/**
	 * 根据二级分类去查询商品集合
	 * @param csid
	 * @param begin
	 * @param limit
	 * @return
	 */
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
				//多表查询
				String hql="select p from Product p join p.categorySecond cs  where cs.csid=?";
				List<Product> list=(List<Product>) hibernateTemplate.execute((HibernateCallback<Product>) new PageHibernateCallback(hql, new Object[]{csid}, begin, limit));
				if(list!=null && list.size()>0){
					return list;
				}
				return null;
	}
	//dao层统计商品个数的方法
	public int findCount() {
		String hql="select count(*) from Product";
		List<Long> list=(List<Long>) hibernateTemplate.find(hql);
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	//返回当前页商品的集合
	public List<Product> findByPage(int begin, int limit) {
		String hql="from Product order by pdate desc";
		List<Product> list=hibernateTemplate.execute(new PageHibernateCallback<Product>(hql, null, begin, limit));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}
	//dao层将商品保存到数据库中
	public void save(Product product) {
		hibernateTemplate.save(product);
	}
	//删除商品的方法
	public void delete(Product product) {
		hibernateTemplate.delete(product);
	}
	public void update(Product product) {
		hibernateTemplate.update(product);
	}
	//	dao层按searchkey统计教程个数的方法
	public int findTotalCountBySearchkey(String searchkey) {
		String hql="select count(*) from Product p where p.pname like '%"+searchkey+"%'";
		List<Long> list=(List<Long>) hibernateTemplate.find(hql);
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	//使用searchkey查询教程集合
	public List<Product> findByPageSearchkey(String searchkey, int begin, int limit) {
		String hql="from Product where pname like '%"+searchkey+"%'";
		List<Product> list=(List<Product>) hibernateTemplate.execute((HibernateCallback<Product>) new PageHibernateCallback(hql, null, begin, limit));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}
	
	

}
