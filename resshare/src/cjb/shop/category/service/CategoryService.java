package cjb.shop.category.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cjb.shop.category.dao.CategoryDao;
import cjb.shop.category.domain.Category;

/**
 * @author chenjibao
 *@date2018年4月3日下午7:36:58
 *@description:以及分类业务层对象
 */
@Transactional
public class CategoryService {
	//在service层里面注入dao
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	/**
	 * 查询所有一级分类的方法
	 * @return
	 */
	public List<Category> findAll() {
		return categoryDao.findAll();
	}
	//业务层保存一级分类的方法
	public void save(Category category) {
		categoryDao.save(category);
	}
	//业务层根据cid查询一级分类
	public Category findByCid(Integer cid) {
		
		return categoryDao.findByCid(cid);
	}
	//业务层删除一级分类
	public void delete(Category category) {
		categoryDao.delete(category);
	}
	//业务层更新一级分类的信息
	public void update(Category category) {
		categoryDao.update(category);
	}
	

}
