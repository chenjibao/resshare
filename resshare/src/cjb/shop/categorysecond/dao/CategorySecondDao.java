package cjb.shop.categorysecond.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cjb.shop.categorysecond.domain.CategorySecond;
import utils.PageHibernateCallback;

/**
 *@author chenjibao
 *@date2018年4月8日下午6:50:25
 *@description:二级分类管理持久层类
 */
public class CategorySecondDao {
			//注入HibernateTemplate
			private HibernateTemplate hibernateTemplate;
			public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
				this.hibernateTemplate = hibernateTemplate;
			}
			
			//dao层统计二级分类个数的方法
			public int findCount() {
				String hql="select count(*) from CategorySecond";
				List<Long> list=(List<Long>) hibernateTemplate.find(hql);
				if(list!=null && list.size()>0){
					return list.get(0).intValue();
				}
				return 0;
			}
			//dao层分页查询二级分类的方法
			public List<CategorySecond> findByPage(int begin, int limit) {
				String hql="from CategorySecond order by csid desc";
				List<CategorySecond> list=hibernateTemplate.execute(new PageHibernateCallback<CategorySecond>(hql, null, begin, limit));
				if(list!=null && list.size()>0){
					return list;
				}
				return null;
			}

			public void save(CategorySecond categorySecond) {
				hibernateTemplate.save(categorySecond);
			}

			//DAo层根据二级分类id查询二级分类的方法
			public CategorySecond findByCsid(Integer csid) {
				return hibernateTemplate.get(CategorySecond.class, csid);
			}
			//DAo层删除二级分类的方法
			public void datete(CategorySecond categorySecond) {
				hibernateTemplate.delete(categorySecond);
			}
			//dao层修改二级分类的方法
			public void update(CategorySecond categorySecond) {
				hibernateTemplate.update(categorySecond);
			}
			//dao层查询所有二级分类的方法
			public List<CategorySecond> findAll() {
				String hql="from CategorySecond";
				return (List<CategorySecond>) hibernateTemplate.find(hql);
			}

}
