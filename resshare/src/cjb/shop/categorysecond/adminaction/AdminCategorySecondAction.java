package cjb.shop.categorysecond.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cjb.shop.category.domain.Category;
import cjb.shop.category.service.CategoryService;
import cjb.shop.categorysecond.domain.CategorySecond;
import cjb.shop.categorysecond.service.CategorySecondService;
import cjb.shop.utils.PageBean;
/**
 *@author chenjibao
 *@date2018年4月8日下午6:45:46
 *@description:后台二级分类管理的action 
 */
public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{
	//模型驱动使用的对象
	private CategorySecond categorySecond=new CategorySecond();
	//注入service
	private CategorySecondService categorySecondService;
	//注入page
	private Integer page;
	//注入一级分类的service
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	@Override
	public CategorySecond getModel() {
		return categorySecond;
	}
	//后台管理查询二级分类的方法
	public String findAll(){
		//获取pageBean
		PageBean<CategorySecond> pageBean=categorySecondService.findByPage(page);
		//将pageBean保存到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	//跳转到添加页面
	public String addPage(){
		//查询所有一级分类
		List<Category> cList=categoryService.findAll();
		//把数据显示到页面的下拉列表中，先把数据保存到值栈中
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "addPageSuccess";
	}
	//保存二级分类的方法
	public String save(){
		categorySecondService.save(categorySecond);
		return "saveSuccess";
	}
	//删除二级分类的方法
	public String  delete(){
		//如果要进行级联删除，应该先查询后删除，配置cascade
		categorySecond =categorySecondService.findByCsid(categorySecond.getCsid());
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}
	
	//编辑二级分类的方法
	public String edit(){
		//根据二级分类查询二级分类对象
		categorySecond =categorySecondService.findByCsid(categorySecond.getCsid());//可以通过模型驱动在页面中直接使用
		//查询所有一级分类
		List<Category> cList=categoryService.findAll();
		//保存到值栈中
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "editSuccess";
	}
	
	//修改二级分类的方法
	public String update(){
		categorySecondService.update(categorySecond);
		return "updateSuccess";
	}
}
