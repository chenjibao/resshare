package cjb.shop.categorysecond.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cjb.shop.categorysecond.dao.CategorySecondDao;
import cjb.shop.categorysecond.domain.CategorySecond;
import cjb.shop.utils.PageBean;

/**
 *@author chenjibao
 *@date2018年4月8日下午6:50:47
 *@description:二级分类管理业务层类
 */
@Transactional
public class CategorySecondService {
	//注入dao
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}
	
	//业务层分类查询二级分类的方法
	public PageBean<CategorySecond> findByPage(Integer page) {
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
		// 设置参数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置页面显示数据的集合:
		int begin = (page - 1) * limit;
		List<CategorySecond> list = categorySecondDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	//保存分级分类的方法
	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);
	}
	
	//业务层根据二级分类的id查询二级分类的方法
	public CategorySecond findByCsid(Integer csid) {
		return categorySecondDao.findByCsid(csid);
	}
	//业务层删除二级分类的犯法
	public void delete(CategorySecond categorySecond) {
		categorySecondDao.datete(categorySecond);
	}
	//业务层修改二级分类的方法
	public void update(CategorySecond categorySecond) {
		categorySecondDao.update(categorySecond);
	}
	//业务层查询所有二级分类的方法
	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}
	
}
