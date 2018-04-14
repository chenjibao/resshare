package cjb.shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cjb.shop.category.domain.Category;

/**
 * @author chenjibao
 *@date2018年4月3日下午7:36:17
 *@description:一级分类持久层对象
 */
public class CategoryDao {
	//注入HibernateTemplate
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	/**
	 * 查询所有一级分类的方法
	 * @return
	 */
	public List<Category> findAll() {
		String hql="from Category";
		List<Category> cList=(List<Category>) hibernateTemplate.find(hql);
		return cList;
	}
	//持久层保存一级分类的方法
	public void save(Category category) {
		hibernateTemplate.save(category);
	}
	//持久层根据cid查询一级分类
	public Category findByCid(Integer cid) {
		return hibernateTemplate.get(Category.class,cid);
	}
	//dao层删除一级分类
	public void delete(Category category) {
		hibernateTemplate.delete(category);
	}
	//dao层更新一级分类的方法
	public void update(Category category) {
		hibernateTemplate.update(category);
	}

}
