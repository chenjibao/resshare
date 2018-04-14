package cjb.shop.index.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cjb.shop.category.domain.Category;
import cjb.shop.category.service.CategoryService;
import cjb.shop.product.domain.Product;
import cjb.shop.product.service.ProductService;

public class IndexAction extends ActionSupport {
	//注入一级分类的Service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//注入商品的service
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}	



	@Override
	public String execute() throws Exception {
		//查询所有一级分类的集合
		List<Category> cList=categoryService.findAll();
		//将一级分类存入到session的范围
		ActionContext.getContext().getSession().put("cList", cList);
		//查询热门商品
		List<Product> hList=productService.findHot();
		//保存到值栈中
		ActionContext.getContext().getValueStack().set("hList", hList);
		
		//查询最新商品
		List<Product> nList=productService.findNew();
		//保存到值栈中
		ActionContext.getContext().getValueStack().set("nList", nList);
		return "index";
	}
}
