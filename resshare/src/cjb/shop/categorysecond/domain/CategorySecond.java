package cjb.shop.categorysecond.domain;

import java.util.HashSet;
import java.util.Set;

import cjb.shop.category.domain.Category;
import cjb.shop.product.domain.Product;

public class CategorySecond {
	private Integer csid;//二级分类id
	private String csname;//二级分类名称
	private Category category;//二级分裂所属的一级分类
	private Set<Product> products=new HashSet<Product>();//二级分类下的商品
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
