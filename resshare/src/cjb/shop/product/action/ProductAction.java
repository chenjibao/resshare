package cjb.shop.product.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cjb.shop.category.service.CategoryService;
import cjb.shop.product.domain.Product;
import cjb.shop.product.service.ProductService;
import cjb.shop.utils.PageBean;
/**
 * @author chenjibao
 *@date2018年4月3日下午9:07:48
 *@description:商品的Action类
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	//注入ProductService
	private ProductService productService;
	//注入cid
	private Integer cid;
	//注入一级分类的service
	private CategoryService categoryService;
	//注入当前页数
	private int page;
	//注入searchkey
	private String searchkey;
	
	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey;
	}

	private Integer csid;
	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	//用于接受数据的模型
	private Product product=new Product();

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@Override
	public Product getModel() {
		return product;
	}
	
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	public Integer getCid() {
		return cid;
	}


	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * 根据商品的id进行查询
	 * @return
	 */
	public String findByPid(){
		 product=productService.findByPid(product.getPid());
		return "findByPid";
	}
	
	/**
	 * 根据一级分类id查询商品
	 * @return
	 */
	public String findByCid(){
//		List<Category>  cList=categoryService.findAll();
		//根据一级分类查询商品，带分页查询
		PageBean<Product> pageBean=productService.findByPageCid(cid,page);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}
	
	/**
	 * 根据二级分类id查询商品
	 * @return
	 */
	public String findByCsid(){
		//根据二级分类id查询
		PageBean<Product> pageBean=productService.findByPageCsid(csid,page);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCsid";
	}
	//更新教程下载量
	public void updateDownloadNum() throws IOException{
		product=productService.findByPid(product.getPid());
		product.setDownloadnum(product.getDownloadnum()+1);
		productService.update(product);
		ServletActionContext.getResponse().sendRedirect(product.getUrl());
	}
	//搜索教程的方法
	public String findByProductPartName(){
		PageBean<Product> pageBean=productService.findByProductPartName(searchkey,page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		ActionContext.getContext().getValueStack().set("searchkey", searchkey);
		return "findByProductPartName";
	}

}
