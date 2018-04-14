package cjb.shop.category.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import cjb.shop.categorysecond.domain.CategorySecond;

/**
 * @author chenjibao
 *@date2018年4月3日下午7:28:21
 *@description:一级分类的实体类对象
 */
public class Category implements Serializable{
	private Integer cid;
	private String cname;
	private Set<CategorySecond> categorySeconds=new HashSet<CategorySecond>();
	
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	

}
