package cjb.shop.category.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cjb.shop.category.domain.Category;
import cjb.shop.category.service.CategoryService;
/**
 *@author chenjibao
 *@date2018年4月8日上午10:45:39
 *@description:后台一级分类管理的Action
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{
	//模型
	private Category category=new Category();
	@Override
	public Category getModel() {
		return category;
	}
	//注入一级分类的service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//查询所有一级分类
	public String findAll(){
		List<Category> cList=categoryService.findAll();
		//将集合保存到值栈中
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	//后台添加一级分类的方法
	public String save(){
		categoryService.save(category);
		return "saveSuccess";
	}
	
	//后台删除一级分类的方法
	public String delete(){
		//查询
		category=categoryService.findByCid(category.getCid());
		//删除
		categoryService.delete(category);
		//页面跳转
		return "deleteSuccess";
	}
	//跳转到编辑页面
	public String edit(){
		category=categoryService.findByCid(category.getCid());
		return "editSuccess";
	}
	//更新一级分类的信息
	public String update(){
		categoryService.update(category);
		return "updateSuccess";
	}

}
